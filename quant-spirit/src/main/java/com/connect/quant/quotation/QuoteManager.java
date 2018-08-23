package com.connect.quant.quotation;

import javax.annotation.Resource;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.connect.quant.Constant;
import com.connect.quant.QuantSpiritConfig;
import com.connect.quant.dao.mapper.BarMapper;
import com.connect.quant.dao.mapper.TickMapper;
import com.connect.quant.quotation.sina.SinaQuoteConfig;
import com.connect.quant.quotation.sina.SinaQuoteReceiver;
import com.connect.quant.quotation.sina.SinaQuoteService;

/**
 * 行情接收调度，整个程序启动后自动执行行情接收任务。
 * @author liugy
 *
 */
@Component
public class QuoteManager implements ApplicationRunner {
	private static final Logger logger = LoggerFactory.getLogger(QuoteManager.class);
	private static final String JOB_GROUP = "quote_job_group";
    private static final String TRIGGER_GROUP = "quote_trigger_group";

    @Autowired
	private SinaQuoteService quoteService;
	@Autowired
	private SinaQuoteConfig sinaQuoteConfig;
	@Autowired
	private QuantSpiritConfig config;
	@Resource
	private ApplicationContext applicationContext;
	@Autowired
    private Scheduler scheduler;
	@Autowired
	private TickMapper tickMapper;
	@Autowired
	private BarMapper barMapper;
	
	@EventListener
	public void onTick(ReceiveTickEvent event){
		tickMapper.insert(event.getTick());
	}

	@EventListener
	public void onBar(ReceiveBarEvent event){
		barMapper.insert(event.getBar());
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Initializing task to receive the quote.");
		logger.info("Define the quote source: "+config.getQuoteSource());
		
		if(Constant.SOURCE_SINA.equals(config.getQuoteSource())){
			JobDetail jobDetail = JobBuilder.newJob(SinaQuoteReceiver.class).withIdentity("ReceiveQuoteFromSina", JOB_GROUP).build();
			jobDetail.getJobDataMap().put("quoteService", quoteService);
			jobDetail.getJobDataMap().put("sinaQuoteConfig", sinaQuoteConfig);
			jobDetail.getJobDataMap().put("applicationContext", applicationContext);
			
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sinaQuoteConfig.getTradeTimeExpression());    
	        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("MarketTimeTrigger", TRIGGER_GROUP) .withSchedule(scheduleBuilder).build();   
	        scheduler.scheduleJob(jobDetail,cronTrigger);   
		}

	}

}
