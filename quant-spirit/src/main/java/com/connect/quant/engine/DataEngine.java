package com.connect.quant.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.connect.quant.Constant;
import com.connect.quant.dao.mapper.AccountMapper;
import com.connect.quant.dao.mapper.BarMapper;
import com.connect.quant.dao.mapper.ContractMapper;
import com.connect.quant.dao.mapper.ErrorMapper;
import com.connect.quant.dao.mapper.OrderMapper;
import com.connect.quant.dao.mapper.PositionMapper;
import com.connect.quant.dao.mapper.TickMapper;
import com.connect.quant.dao.mapper.TradeMapper;
import com.connect.quant.engine.event.ContractEvent;
import com.connect.quant.engine.event.OrderEvent;
import com.connect.quant.engine.event.TradeEvent;
import com.connect.quant.model.Account;
import com.connect.quant.model.Contract;
import com.connect.quant.model.Order;
import com.connect.quant.model.Position;
import com.connect.quant.model.Trade;

/**
 * 数据引擎
 * @author liugy
 *
 */
@Component
public class DataEngine implements ApplicationRunner {
	
	private Map<String, Contract> contractDict;
	private Map<String, Order> orderDict;
	/**可撤销委托*/
	private Map<String, Order> workingOrderDict;
	private Map<String, Trade> tradeDict;
	private Map<String, Account> accountDict;
	private Map<String, Position> positionDict;
	private List<Error> errorList;
    /**持仓细节相关*/
    private Map<String, PositionDetail> detailDict;
    /**平今手续费惩罚的产品代码列表*/
    private List<String> tdPenaltyList;
    
    @Autowired
	private AccountMapper accountMapper;
    @Autowired
	private ContractMapper contractMapper;
    @Autowired
	private ErrorMapper errorMapper;
    @Autowired
	private OrderMapper orderMapper;
    @Autowired
	private PositionMapper positionMapper;
    @Autowired
	private TradeMapper tradeMapper;
    @Autowired
	private TickMapper tickMapper;
	@Autowired
	private BarMapper barMapper;
    
	@Override
	public void run(ApplicationArguments args) throws Exception {
		contractDict = new HashMap<String, Contract>();
		orderDict = new HashMap<String, Order>();
		workingOrderDict = new HashMap<String, Order>();
		tradeDict = new HashMap<String, Trade>();
		accountDict = new HashMap<String, Account>(); 
		positionDict = new HashMap<String, Position>();
		errorList = new ArrayList<Error>();
	    detailDict = new HashMap<String, PositionDetail>();
	    tdPenaltyList = new ArrayList<String>();
	    tdPenaltyList.add("tdPenalty");
	}
    
	@EventListener
    public void processContractEvent(ContractEvent event){
    	Contract contract = event.getContract();
    	this.contractDict.put(contract.getVtSymbol(), contract);
    	this.contractDict.put(contract.getSymbol(), contract);//使用常规代码（不包括交易所）可能导致重复
    }
	
	@EventListener
	public void processOrderEvent(OrderEvent event){
		Order order = event.getOrder();
		this.orderDict.put(order.getVtOrderId(), order);
		//如果订单的状态是全部成交或者撤销，则需要从workingOrderDict中移除
		if(Constant.FINISHED_STATUS.contains(order.getStatus())){
			if(workingOrderDict.get(order.getVtOrderId()) != null){
				workingOrderDict.remove(order.getVtOrderId());
			}
		}
		//否则则更新字典中的数据 
		else{
			workingOrderDict.put(order.getVtOrderId(), order);
		}
		
		//更新到持仓细节中
        PositionDetail detail = getPositionDetail(order.getVtSymbol());
        detail.updateOrder(order);
	}
	@EventListener
	public void processTradeEvent(TradeEvent event){
		Trade trade = event.getTrade();
		tradeDict.put(trade.getVtTradeId(), trade);
		PositionDetail detail = this.getPositionDetail(trade.getVtSymbol());
		detail.updateTrade(trade);
	}
	
	@EventListener
	public void processPositionEvent(PositionEvent event){
		Position pos = event.getPosition();
		
		positionDict.put(pos.getVtPositionName(), pos);
		PositionDetail detail = this.getPositionDetail(pos.getVtSymbol());
		detail.updatePosition(pos);
		
	}
	
	@EventListener
	public void processAccountEvent(AccountEvent event){
		Account account = event.getAccount();
		accountDict.put(account.getVtAccountId(), account);
	}
	
	@EventListener
	public void processErrorEvent(ErrorEvent event){
		Error error = event.getError();
		errorList.add(error);
	}
	
	
	/**
	 * 查询持仓细节
	 * */
	public PositionDetail getPositionDetail(String vtSymbol){
		PositionDetail detail;
		
		if(detailDict.containsKey(vtSymbol)){
			detail = detailDict.get(vtSymbol);
		}else{
			Contract contract = getContract(vtSymbol);
			detail = new PositionDetail();
			detail.setVtSymbol(vtSymbol);
			if(contract != null){
				detail.setSymbol(contract.getSymbol());
				detail.setExchange(contract.getExchange());
				detail.setName(contract.getName());
				detail.setSize(contract.getSize());
			}
			detailDict.put(vtSymbol, detail);
			
			if(contract != null){
				detail.setExchange(contract.getExchange());
				
				//上期所合约
                if(Constant.EXCHANGE_SHFE.equals(contract.getExchange())){
                	detail.setMode(Constant.MODE_SHFE);
                }
                //检查是否有平今惩罚
                for(String productID:tdPenaltyList){
                    if(contract.getSymbol().contains(productID)){
                        detail.setMode(Constant.MODE_TDPENALTY);
                    }     
                }
			}
		}
		
		return detail;
	}
	
	public Contract getContract(String vtSymbol){
		return contractDict.get(vtSymbol);
	}
}
