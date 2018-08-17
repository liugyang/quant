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
public abstract class QuoteReceiver implements Job{
	
	public abstract void receive(JobExecutionContext context);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		receive(context);
	}
	
	
}
