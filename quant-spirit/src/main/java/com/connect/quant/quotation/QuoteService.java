package com.connect.quant.quotation;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 本文件中实现了行情数据记录引擎，用于汇总TICK数据，并生成K线插入数据库。
 * 使用配置来设定需要收集的合约，以及主力合约代码。
 * @author liugy
 *
 */
public abstract class QuoteService implements Job{
	
	public abstract void receive();
	
	public abstract void processBar();

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		processTick();
		processBar();
	}
	
	public abstract void beforeExecute();
	
	public abstract void afterExecute();
}
