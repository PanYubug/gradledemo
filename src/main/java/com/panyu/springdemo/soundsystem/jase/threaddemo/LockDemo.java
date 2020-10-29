package com.panyu.springdemo.soundsystem.jase.threaddemo;

/*
 * 使用了java.util.concurrent.locks包中的对象
 * Lock接口：它的出现比synchronized有更多的操作
 *       lock():获取锁
 *       unlock():释放锁
 * 同步代码块或者同步函数的锁操作时隐式的
 *
 * JDK1.5 Lock接口，按照面向对象的思想，将锁单独封装成了一个对象
 *                 并提供了对锁的显示操作。
 *
 * Lock接口就是同步的替代。
 * 1、将线程中的同步更换为Lock接口的形式。
 *
 * 替换完运行失败了。因为wait没有了同步区域，没有了所属的同步锁
 * 同步升级了。其中锁已经不是任意对象。而是Lock类型的对象
 * 那么和任意对象绑定的监视器方法，是不是也升级了，有了专门和Lock类型的绑定的的监视器
 * Condition接口
 *
 * 现在将监视器方法封装到Condition接口中
 *  await(),signal(), signalAll()
 *
 * 监视器对象Condition如果和Lock绑定
 *      newCondition()
 *
 *
 * wait()和sleep()的区别
 * 相同点：可以让线程处于冻结状态
 * 不同点：
 * 1、wait()可以致电时间，也可以不指定
 *      sleep(),必须指定时间
 * 2、wait():释放cpu资源，释放锁
 *      sleep():释放cpu资源，不释放锁
 *
 * 异常发生在哪个线程，就会终止哪个线程
 *
 *
 * */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Res1 {
    private String name;
    private int count = 1;
    private boolean flag;

    //定义标记
    private Lock l = new ReentrantLock();
    private Condition pro_con = l.newCondition();
    private Condition cons_con = l.newCondition();

    //提供了给商品赋值的的方法
    public void set(String name) {
        //获取锁
        l.lock();
        try {
            while (flag)
                try {
                    pro_con.await();} catch (InterruptedException e) { } //判断标记为true，执行wait。等待。为false。就生产
            this.name = name + "--" + count;
            count++;
            System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
            //生成完毕，将标记改为true
            flag = true;
            //唤醒消费者
            cons_con.signal();
        }finally {
            l.unlock();

        }


    }

    public void get() {

        l.lock();
        try {
            while (!flag)
                try {
                    cons_con.await(); //判断标记为true，执行wait。等待。为false。就生产
                } catch (InterruptedException e) {

                }
            System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
            //将标记改为false
            flag = false;
            pro_con.signal();
        }finally {
            l.unlock();
        }

    }
}


public class LockDemo {
}
