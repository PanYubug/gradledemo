package com.panyu.springdemo.soundsystem.jase.listdemo;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        //1、创建一个链表对象。//xxxFirst xxxLast
        LinkedList link = new LinkedList();
        //2、添加元素
        link.addFirst("abc1");
        link.addFirst("abc2");
        link.addFirst("abc3");
        //3、获取元素
//        System.out.println(link.getFirst());
        System.out.println(link.getFirst());

        //4、删除元素
//        System.out.println(link.removeFirst());
//        System.out.println(link.removeFirst());

        //获取link中所有的元素
        while (!link.isEmpty()){
//            System.out.println(link.removeFirst());
            System.out.println(link.removeLast());
        }
    }
}
