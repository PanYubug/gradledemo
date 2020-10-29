package com.panyu.springdemo.soundsystem.jase.threaddemo;

/*
* 多线程间的通信，多个线程都在处理同一个资源，但是处理的任务却不一样
* 生产者，消费者
* 通过同步，解决了没生产就消费的问题，
* 但是出现了连续的生产没有消费的情况，和需求生产一个，消费一个的情况不符
*
* 使用了等待唤醒机制(必须要在同步中，操作锁上的线程的)
* wait()：该方法可以让线程处于冻结状态，并将线程临时存储到线程池中。
* notify()：唤醒指定线程池中的任意一个线程。
* notifyAll()：唤醒指定线程池中的所有线程
*
*
* */


class Res{
    private String name;
    private int count = 1;
    private boolean flag;

    //提供了给商品赋值的的方法
    public synchronized void set(String name){

        while (flag)
            try {
                wait(); //判断标记为true，执行wait。等待。为false。就生产
            }catch (InterruptedException e){

            }
        this.name = name+"--"+count;
        count++;
        System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
        //生成完毕，将标记改为true
        flag = true;
        //唤醒消费者
        notifyAll();
    }

    public synchronized void get(){
        while (!flag)
            try {
                wait(); //判断标记为true，执行wait。等待。为false。就生产
            }catch (InterruptedException e){

            }
        System.out.println(Thread.currentThread().getName()+"...消费者..."+this.name);
        //将标记改为false
        flag = false;
        notifyAll();
    }
}

class Productor implements Runnable{
    private Res r;
    Productor(Res r){
        this.r = r;
    }
    public void run(){
        r.set("面包");
    }
}

class Consumer implements Runnable{
    private Res r;
    Consumer(Res r){
        this.r = r;
    }
    public void run(){
        r.get();
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        //1、创建资源
        Res r = new Res();
        //2、创建两个任务
        Productor pro = new Productor(r);
        Consumer con = new Consumer(r);

        //3、创建线程
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);

        t1.start();
        t2.start();

    }
}
