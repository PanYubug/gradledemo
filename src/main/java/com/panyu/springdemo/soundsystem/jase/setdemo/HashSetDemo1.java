package com.panyu.springdemo.soundsystem.jase.setdemo;


import com.panyu.springdemo.soundsystem.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo1 {
    public static void main(String[] args) {
        /*
        * 练习：网HashSet中存储学生对象（姓名，年龄）。同姓名，同年龄视为同一个人，不存。
        * 1、描述学生
        * 2、定义容器
        * 3、将学生对象存储到容器中
        *
        *
        * 发现存储了同姓名同年龄的学生是可以的
        * 原因是每一次存储学生对象，都先调用hashcode()方法，获取哈希值。
        * 但是调用的事Object中的hashcode的，所以不同对象，哈希值也不同。
        *
        *
        *
        * */

        //1、创建容器
        Set set = new HashSet();
        //2、存储学生对象。
        set.add(new Student("xiaoqiang", 20));
        set.add(new Student("wangcai", 27));
        set.add(new Student("xiaoming", 22));
        set.add(new Student("xiaoming", 22));
        set.add(new Student("xiaoming", 22));
        set.add(new Student("xiaoming", 22));
        set.add(new Student("daniu", 25));
        set.add(new Student("daniu", 25));
        set.add(new Student("daniu", 25));
        set.add(new Student("daniu", 25));

        //3、获取所有学生
        for (Iterator it = set.iterator(); it.hasNext(); ) {
            Student stu = (Student)it.next();
            System.out.println(stu.getName()+"::"+stu.getAge());
        }

    }
}
