package com.panyu.springdemo.soundsystem.jase.threaddemo;



/*
 * 该类的描述中有创建线程的两种方式
 * 1、继承Thread类
 *   步骤：
 *       1、继承Thread类
 *       2、覆盖run方法
 *       3、创建子类对象就是创建线程对象
 *       4、调用Thread类中的start方法就可以执行线程。并会调用run方法
 *
 *       start()开启线程后，都会执行run方法。说明run方法中存储的事线程要运行的代码。
 *       所以，记住，自定义线程的任务代码都是存储在run方法中。
 *
 *
 * 2、实现Runnable接口
 *     1、定义一个类实现Runnable
 *     2、覆盖Runnable接口中的run方法，将线程要运行的任务代码存储到该方法中
 *     3、通过Thread类创建线程对象，并将实现了Runnable接口的对象作为Thread类的构造函数的参数进行传递。
 *     4、调用Thread类的start方法，开启线程。
 *
 * 实现Runnable接口的好处：
 *      1、避免了继承Thread类的单继承的局限性
 *      2、Runnable接口出现更符合面向对象，将线程任务单独进行对象的封装
 *      3、Runnable接口出现，降低了线程对象和线程任务的耦合性。
 * 所以，以后创建线程都使用第二种方式。
 *
 *
 * 多线程安全问题：
 *      产生的原因：
 *          1、线程任务中有共享的数据。
 *          2、线程任务中有多条对共享数据的操作
 *      一个线程在操作共享数据的过程中，其他线程参与了运算，造成了数据的错误。
 *
 *      解决的思想：
 *          只要保证多条操作共享数据的代码在某一时间段，被一条线程所执行，在执行期间，不允许其他线程参与。
 *
 *      用到同步代码块
 *      synchronized(对象)
 *      {
 *          需要被同步的代码
 *      }
 *
 * 同步在目前情况下保证了一次只能有一个线程在执行，其他线程进不来。
 * 这就是同步的锁机制
 *
 * 好处：解决了多线程的安全问题。
 * 弊端：降低效率
 *
 * 有可能出现这样一种情况：
 * 多线程安全问题出现后，加入了同步机制，没有想到，安全问题依旧。
 * 同步代码块出现问题了。
 *
 * 只要遵守了同步的前提，就可以解决。
 * 同步的前提：
 *      多个线程在同步中必须使用同一个锁，这才是对多个线程同步。
 *
 * 线程不安全的情况
 * 1、线程任务中是否有共享的数据
 * 2、是否多条操作共享数据的代码
 *
 * 同步函数：其实就是在函数上加上了同步关键字进行修饰
 * 同步表现形式有两种：1、同步代码块，2、同步函数
 *
 * 同步函数使用的锁是什么？
 * 同步函数使用的锁是this
 *
 * 静态同步函数使用的锁是 类名.class
 *
 *
 * 单例模式的并发访问
 *      饿汉式。相对与多线程并发，安全
 *
 *      懒汉式：延迟加载模式
 *          在多线程并发访问时，会出现线程安全问题。加了同步就可以解决问题，无论是同步函数，还是同步代码块都行，但是效率低了。
 *      怎么解决效率低的问题。
 *          可以通过if对单例对象的双重判断的形式。
 *
 * 同步函数，同步代码块
 *
 * 同步代码块使用的任意的对象作为锁
 * 同步函数只能使用this作为锁
 *
 * 如果一个类中只需要一个锁，这时可以考虑同步函数，使用this，写法简单
 * 但是，一个类中如果需要多个锁，还有多个类中使用同一个锁。
 *
 * 建议使用同步代码块
 *
 * */


class DemoThread1 implements Runnable {

    private int tickets = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {

            synchronized (obj) {

                if (tickets > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread().getName() + "...." + tickets--);
                } else {
                    return;
                }


            }

        }
    }
}


class DemoThread extends Thread {
    private String name;

    DemoThread(String name) {
        this.name = name;
    }

    public void run() {
//        this.show();
        for (int x = 1; x <= 30; x++) {
            System.out.println(Thread.currentThread().getName() + this.name + "--;x=" + x);
        }
    }

    public void show() {

    }
}


/*
 * 调用start和run方法的区别？
 * 调用start会开启线程，让开启的线程去执行run方法中的线程任务
 * 直接调用run方法，线程并未开启，去执行run方法的只有主线程
 *
 *
 * 线程的周期：被创建：
 *           运行：具备cpu的执行资格
 *                具备cpu的执行权
 *           冻结：sleep
 *                   自动返回
 *                   释放了cpu的执行权
 *                   同时释放了cpu的执行资格
 *                wait和notify
 *                   不传时间自己回不来，需通过notify返回。
 *
 *           临时阻塞状态：具备cpu的执行资格，不具备cpu的执行权
 *
 *           消亡：
 *
 *
 * */

public class ThreadDemo {
    public static void main(String[] args) {
//        Demo d1 = new Demo("张三");
//        Demo d2 = new Demo("李四");
//        d1.show();
//        d2.show();
//        DemoThread dt1 = new DemoThread("张三");
//        DemoThread dt2 = new DemoThread("李四");
//
//        dt1.start();
//        dt2.start();
//
//        for (int x = 1; x < 40; x++) {
//            System.out.println(Thread.currentThread().getName() + "------" + x);
//        }

        DemoThread1 d11 = new DemoThread1();
        Thread t1 = new Thread(d11);
        Thread t2 = new Thread(d11);
        Thread t3 = new Thread(d11);
        Thread t4 = new Thread(d11);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

    public static void printMax(double... number) {
        if (number.length == 0) {
            System.out.println("no argument passed");
            return;
        }
        double result = number[0];
        for (int i = 0; i < number.length; i++) {
            if (number[i] > result) {
                result = number[i];
                System.out.println("The max value is " + result);
            }

        }
    }
}
