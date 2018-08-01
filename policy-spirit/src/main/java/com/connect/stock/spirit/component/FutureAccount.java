package com.connect.stock.spirit.component;

import com.connect.stock.spirit.model.Share;
import com.connect.stock.spirit.model.future.FutureQuote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

@Component
@Configuration
@ConfigurationProperties(prefix = "future.account")
public class FutureAccount {
    private static final Logger logger = LoggerFactory.getLogger(FutureAccount.class);
    private double capital;

    private Map<String, Share> buyLongShares = new LinkedHashMap<String, Share>();
    private Map<String, Share> shortSellingShares = new LinkedHashMap<String, Share>();
    private LinkedList<String> tradesLogs = new LinkedList<String>();

    public LinkedList<String> getTradesLogs() {
        return tradesLogs;
    }

    public void setTradesLogs(LinkedList<String> tradesLogs) {
        this.tradesLogs = tradesLogs;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public Map<String, Share> getBuyLongShares() {
        return buyLongShares;
    }

    public void setBuyLongShares(Map<String, Share> buyLongShares) {
        this.buyLongShares = buyLongShares;
    }

    public Map<String, Share> getShortSellingShares() {
        return shortSellingShares;
    }

    public void setShortSellingShares(Map<String, Share> shortSellingShares) {
        this.shortSellingShares = shortSellingShares;
    }

    public void showStatus() {
        logger.info("-----Show future account status-----");
        logger.info("[Capital]:" + capital);
        logger.info("Bug long:");
        for (String key : buyLongShares.keySet()) {
            Share s = buyLongShares.get(key);
            logger.info("[SNO]:" + s.getSno() + ",[ID]:" + s.getId() + ",[deal price]:" + s.getDealPrice() + ",[amount]:" + s.getAmount() + ",[date]:" + s.getDate() + ",[]:" + s.getTotalCost() + ",[user id]:" + s.getUserId());
        }
        logger.info("Short sell:");
        for (String key : shortSellingShares.keySet()) {
            Share s = shortSellingShares.get(key);
            logger.info("[SNO]:" + s.getSno() + ",[ID]:" + s.getId() + ",[deal price]:" + s.getDealPrice() + ",[amount]:" + s.getAmount() + ",[date]:" + s.getDate() + ",[]:" + s.getTotalCost() + ",[user id]:" + s.getUserId());
        }
    }

    public boolean buy(FutureQuote fq, int amount, boolean isShortSelling, double rateForTrade, double revenceStamp, double securityDepositRate) {
        try {
            double totalMoney = (fq.getCurrentPrice() * amount * (1 + securityDepositRate)) * (1 + rateForTrade + revenceStamp);

            if (capital < totalMoney) {
                return false;
            } else {
                capital = capital - totalMoney;

                if (!isShortSelling) {
                    Share share = buyLongShares.get(fq.getID());
                    if (share != null) {
                        int _amount = share.getAmount() + amount;
                        double cost = share.getTotalCost() + totalMoney;
                        double price = cost / _amount;
                        share.setAmount(_amount);
                        share.setDealPrice(price);
                        share.setTotalCost(cost);
                    } else {
                        share = new Share();
                        share.setId(fq.getID());
                        share.setTotalCost(totalMoney);
                        share.setDealPrice(fq.getCurrentPrice());
                        share.setAmount(amount);
                        buyLongShares.put(fq.getID(), share);
                    }
                    return true;
                } else {
                    Share share = shortSellingShares.get(fq.getID());
                    if (share != null) {
                        int _amount = share.getAmount() + amount;
                        double cost = share.getTotalCost() + totalMoney;
                        double price = cost / _amount;
                        share.setAmount(_amount);
                        share.setDealPrice(price);
                        share.setTotalCost(cost);
                    } else {
                        share = new Share();
                        share.setId(fq.getID());
                        share.setTotalCost(totalMoney);
                        share.setDealPrice(fq.getCurrentPrice());
                        share.setAmount(amount);
                        shortSellingShares.put(fq.getID(), share);
                    }
                    return true;
                }
            }
        }finally{
            String log = "{BUY}[ID]:"+fq.getID()+",[cur price]:"+fq.getCurrentPrice()+",[amount]:"+amount+",[isShortSelling]:"+isShortSelling+",[rateForTrade]:"+rateForTrade+",[revenceStamp]:"+revenceStamp+",[securityDepositRate]:"+securityDepositRate;
            logger.info(log);
            tradesLogs.add(log);
            showStatus();
        }

    }


    public boolean sell(FutureQuote fq, int amount, boolean isShortSelling, double rateForTrade, double revenceStamp, double securityDepositRate){
        try {
            if (!isShortSelling) {
                Share share = buyLongShares.get(fq.getID());
                if (share == null) {
                    return false;
                } else if (amount > share.getAmount()) {
                    return false;
                } else {
                    double money = (fq.getCurrentPrice() * amount * (1 + securityDepositRate)) * (1 - rateForTrade + revenceStamp);
                    share.setAmount(share.getAmount() - amount);
                    this.capital = capital + money;
                    if (share.getAmount() == 0) {
                        buyLongShares.remove(fq.getID());
                    }
                    return true;
                }
            } else {
                Share share = shortSellingShares.get(fq.getID());
                if (share == null) {
                    return false;
                } else {
                    if (amount > share.getAmount()) {
                        return false;
                    } else {
                        double money = ((share.getDealPrice() - fq.getCurrentPrice()) + share.getDealPrice()) * amount * (1 + securityDepositRate) * (1 - rateForTrade + revenceStamp);
                        share.setAmount(share.getAmount() - amount);
                        this.capital = capital + money;
                        if (share.getAmount() == 0) {
                            shortSellingShares.remove(fq.getID());
                        }
                        return true;
                    }
                }
            }
        }finally{
            String log = "{SELL}[ID]:"+fq.getID()+",[cur price]:"+fq.getCurrentPrice()+",[amount]:"+amount+",[isShortSelling]:"+isShortSelling+",[rateForTrade]:"+rateForTrade+",[revenceStamp]:"+revenceStamp+",[securityDepositRate]:"+securityDepositRate;
            logger.info(log);
            tradesLogs.add(log);
            showStatus();
        }
    }

    public Share getShare(String id, boolean isShortSelling){
        if(!isShortSelling){
            return buyLongShares.get(id);
        }else{
            return shortSellingShares.get(id);
        }
    }


}
