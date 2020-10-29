package com.panyu.springdemo.soundsystem.jase.generic;

public class GenericDemo4 {
    public static void main(String[] args) {
        Demo1<String> d = new Demo1<String>();
        d.show("abc");
        d.print(6);
    }
}


class Demo1<W>{
    public void show(W w){
        System.out.println("show:"+w);
    }

    //静态方法是无法访问类上的泛型的，如果静态方法需要定义泛型，泛型只能定义在方法上
    //泛型方法
    public static <Q> void print(Q w){
        System.out.println("print:"+w);
    }
}