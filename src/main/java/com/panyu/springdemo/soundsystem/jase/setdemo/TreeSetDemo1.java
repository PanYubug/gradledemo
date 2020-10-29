package com.panyu.springdemo.soundsystem.jase.setdemo;


import com.panyu.springdemo.soundsystem.Student;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo1 {
    public static void main(String[] args) {

        //初始化TreeSet集合明确一个比较器
        Set set = new TreeSet(new ComparatorByName());
        set.add(new Student("xiaoqiang12", 20)); //ClassCastException学生要排序就需要比较，而没有定义比较方法，无法排序
        //比较add方法中使用的是Comparable接口的比较方法
        set.add(new Student("wangcai12", 27));
        set.add(new Student("xiaoming12", 22));
        set.add(new Student("xiaoming12", 22));
        set.add(new Student("xiaoming12", 22));
        set.add(new Student("xiaoming1", 22));
        set.add(new Student("daniu1", 25));
        set.add(new Student("daniu1", 25));
        for (Iterator it = set.iterator(); it.hasNext(); ) {
            Student stu = (Student)it.next();
            System.out.println(stu.getName()+"::"+stu.getAge());
            
        }
    }
}
