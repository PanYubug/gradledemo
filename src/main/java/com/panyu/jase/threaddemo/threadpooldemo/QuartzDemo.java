package com.panyu.jase.threaddemo.threadpooldemo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class QuartzDemo {
    public static class PrintWordJob implements Job {
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {

            String printTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println("Job start at " + printTime + ", prints: Hello Job" + new Random().nextInt(100));
        }
    }

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 1、scheduler
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        // 2、jobDetail
        JobDetail jobDetail = JobBuilder.newJob(PrintWordJob.class).withIdentity("job1", "group1").build();
        // 3、trigger
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                .build();
        // 4、执行
        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("-------scheduler start !-------");
        scheduler.start();
        // 5、睡眠
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("---------scheduler shutdown !---------");
    }
}
