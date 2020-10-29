package com.panyu.springdemo.soundsystem.jase.stringdemo;
/*
 *  单用例设计模式
 *  解决的问题：保证一个类的对象在内存中的唯一性
 *  应用场景：多个程序都在操作同一个配置文件时间，需要程序A操作后的结果，
 *  程序N要知道并继续基于A操作后的结果进行操作。
 *  前提，数据都存储在配置文件对象中，要求程序A和程序B操作的配置文件对象是同一个。
 *
 *  怎么实现呢？怎么可以包中这个类只能产生一个对象呢？
 *
 *  思路：
 *  1、问题是其他程序都可以通过new创建该类的对象。无法控制数量
 *   所以不让其他程序new
 *  2、那第一步的问题也产生了，那其他程序不就没有对象了吗？
 *  干脆，在本类中自己new 一个本类对象，这样的好处是，不让别的程序new， 自己new， 可以实现数量控制。
 *  3、对外提供让其他程序获取该对象的方式。
 *
 *  步骤：
 *  1、不让其他程序new该类对象？怎么做
 *  可以再类中的构造函数私有化
 *  2、在本类中new 一个对象
 *  3、定义一个方法返回该对象
 *
 *  代码体现：
 *
 * */


// 饿汉式
class Single
{
    //创建一个本类对象
    private static Single s = new Single();
    //构造函数私有化
    private Single(){

    }
    // 定义一个方法返回对象。让其他程序可以获取到。
    public static Single getInstance()
    {
        return s;
    }

}

/*
* 另一种形式 延迟加载
* class Single
* {
*       private static Single s = null;
*       private Single(){};
*       public static Single getInstance()
*       {
*           if (s == null)
*           {
*               s = new Single();
*           }
*       }
* }*/

public class SingleDemo {

    public static void main(String[] args) {
        Single s1 = Single.getInstance();
        SuperMan man = SuperMan.getInstance();
        man.setName("英雄");
        String name = man.getName();
        System.out.println(name);

    }
}


class SuperMan
{
    private String name;
    private  static SuperMan sm = new SuperMan("克拉克");
    SuperMan(String name){
        this.name = name;
    }
    public static SuperMan getInstance(){
        return sm;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}