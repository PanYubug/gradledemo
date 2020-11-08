package com.panyu.quartzdemo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

import static java.lang.String.format;

public class SimpleJob implements Job {
    public SimpleJob() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.out.println("开始执行简单任务" + new Date());
        Object param = context.getJobDetail().getJobDataMap().get("data");
        System.out.println(format(param.toString()));
    }
}
