package com.panyu.springdemo.soundsystem.jase.generic;


import com.panyu.springdemo.soundsystem.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/*
* 什么时候会用到上限呢？
* 一般往集合存储元素时，如果集合定义了E类型通常情况下应该存储E类型的对象。
* 对E的子类型的对象E类型也可以接受，所以这时可以将泛型从E改为       ? extends E
*
*
* */

public class GenericDemo6 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");


//        printCll(list);
    }

    //泛型通配符
    //在不明确具体类型的情况下，可以使用通配符来标识?
    //泛型的限定  ? extends E。接受E类型或者E的子类型
    //          ? super E 接受E类型或者E类型的父类型
    private static void printCll(Collection<? extends Person> coll) {
        for (Iterator<? extends Person> it = coll.iterator(); it.hasNext(); ) {
            Object next = it.next();
            System.out.println(next);
        }
    }

}
