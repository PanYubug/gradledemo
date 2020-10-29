package com.panyu.springdemo;

import com.panyu.demo.soundsystem.Person;

public class main {
    public static void main(String[] args) {
        Person zhangsan = new Person("zhangsan", 15);
        String name = zhangsan.getName();
        System.out.println(name);
    }
}
