package com.panyu.springdemo.soundsystem.jase.threaddemo;


/*
* 如何停止线程？
* 原理：让run方法结束
*       线程任务通常都有循环。因为开启线程的目的为了执行需要一些时间的代码
*
*       只要控制住循环，就可以结束run()方法，就可以停止线程。
*
*       控制循环弄个标记即可。定义变量
*
* 1、join()
* 2、setDaemon()
* 3、优先级
*    1-10大最高优先级，1，5，10。。默认是5
*                   MIN_PRIORITY
*                   NORM_PRIORITY
*                   MAX_PRIORITY
*    setPriority()
*    getPriority()
*
* 4、yield()释放执行权，也可能抢到
*
* 5、ThreadGroup
*   对n个线程做同一个操作
*
*
*
* */

class StopThread implements Runnable

{
    private boolean flag = true;
    @Override
    public void run() {
        while (flag)
        System.out.println(Thread.currentThread().getName()+"...hello");
    }
    public void changeFlag(){
        flag = false;
    }
}


public class StopThreadDemo {
    public static void main(String[] args) {

        StopThread st = new StopThread();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        t1.start();
        t2.start();
        for (int x=1; x<50; x++){
            if (x==40){
                st.changeFlag();
                t1.interrupt();//将t1中断
            }
            System.out.println("main...."+x);
        }
    }
}
