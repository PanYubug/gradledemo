package com.panyu.springdemo.soundsystem.jase.listdemo;

import java.util.LinkedList;

public class LinkedListDemo2 {
    public static void main(String[] args) {
        /*
        * 练习：请荣国LinkedList实现一个堆栈，或者队列数据结构
        * 堆栈：先进后出。First In Last Out FILO
        * 队列：先进先出。First In First Out FIFO
        * */

        //1、创建自定义的队列对象
        MyQueue myqueue = new MyQueue();
        //2、添加元素
        myqueue.myAdd("abc1");
        myqueue.myAdd("abc2");
        myqueue.myAdd("abc3");
        myqueue.myAdd("abc4");
        //3、获取所有元素,先进先出
        while (!myqueue.isNull()){
            System.out.println(myqueue.myGet());
        }


    }
}

class MyQueue{
    private LinkedList link;

    public MyQueue() {
        link = new LinkedList();
    }

    /*
    * 添加元素的方法
    * */
    public void myAdd(Object obj){
        //内部使用的事LinkedList的方法
        link.addFirst(obj);
    }
    public Object myGet(){
        return link.removeLast();
    }
    public boolean isNull(){
        return link.isEmpty();
    }


}
