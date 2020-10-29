package com.panyu.springdemo.soundsystem.jase;

public class ThisDemo {
    public static void main(String[] args) {
        Person p = new Person("xiaoqiang", 22);
        Person p2 = new Person("lisi", 22);

        boolean b = p.equalsAge(p2);
        System.out.println(b);
    }
}
