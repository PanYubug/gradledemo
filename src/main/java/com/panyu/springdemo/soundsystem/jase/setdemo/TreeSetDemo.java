package com.panyu.springdemo.soundsystem.jase.setdemo;


import com.panyu.springdemo.soundsystem.Student;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set set = new TreeSet();
//        set.add("haha1");
//        set.add("afadf1");
//        set.add("heihei1");
//        set.add("nba1");
//        set.add("nba1");
        set.add(new Student("xiaoqiang1", 20)); //ClassCastException学生要排序就需要比较，而没有定义比较方法，无法排序
                                                        //比较add方法中使用的是Comparable接口的比较方法
        set.add(new Student("wangcai1", 27));
        set.add(new Student("xiaoming1", 22));
        set.add(new Student("xiaoming1", 22));
        set.add(new Student("xiaoming1", 22));
        set.add(new Student("xiaoming", 22));
        set.add(new Student("daniu", 25));
        set.add(new Student("daniu", 25));
        for (Iterator it = set.iterator(); it.hasNext(); ) {
            Student stu = (Student)it.next();
            System.out.println(stu.getName()+"::"+stu.getAge());

        }
    }
}
