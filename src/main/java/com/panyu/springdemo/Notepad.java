package com.panyu.springdemo;

public class Notepad {
    public Notepad() {
        super();
        System.out.println("NotePad的构造函数......"+this.toString());
    }

    public void init(){
        System.out.println("Notepad的初始化方法");
    }

    public void destroy(){
        System.out.println("Notepad的销毁方法");
    }
}
