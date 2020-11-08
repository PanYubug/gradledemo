package com.panyu.quartzdemo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class QuartsDemo {
    public static void main(String[] args) throws SchedulerException {
//        helloJobDemo();
        simpleJobDemo();

    }

    public static void helloJobDemo() throws SchedulerException {
        //创建一个scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.getContext().put("skey", "svalue");

        //创建一个Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .usingJobData("t1", "tv1")
                .withSchedule(simpleSchedule().withIntervalInSeconds(3)
                        .repeatForever()).build();
        trigger.getJobDataMap().put("t2", "tv2");

        //创建一个job
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .usingJobData("j1", "jv1")
                .withIdentity("myjob", "mygroup").build();
        job.getJobDataMap().put("j2", "jv2");

        //注册trigger并启动scheduler
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }

    public static void simpleJobDemo() {

        try {
            // 1、获取调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            // 2、启动调度器，等待执行
            scheduler.start();
            // 3、创建任务详情
            JobDetail job = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("job1", "group1")
                    .build();
            // 3.1 传递参数
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("hello", "quartz");
            job.getJobDataMap().put("data", data);
            // 4、创建触发器：触发事件、触发条件等
            SimpleTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(6)
                            .withRepeatCount(0))
                    .build();
            // 5、将任务和触发器绑定交给调度器管理
            scheduler.scheduleJob(job, trigger);


        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
