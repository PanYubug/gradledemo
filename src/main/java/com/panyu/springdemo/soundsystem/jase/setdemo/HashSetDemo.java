package com.panyu.springdemo.soundsystem.jase.setdemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        //1、创建一个Set容器对象
        Set set = new HashSet();
        //2、添加元素
        set.add("haha");
        set.add("afadf");
        set.add("heihei");
        set.add("nba");
        set.add("nba");
        set.add("nba");
        //3、只能用迭代器取出
        for (Iterator it = set.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }
}
