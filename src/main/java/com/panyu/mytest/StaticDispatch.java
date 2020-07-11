package com.panyu.mytest;

/*
    静态分派，重载
 */
public class StaticDispatch {

    static abstract class Human{

    }

    static class Man extends Human{

    }

    static class Woman extends Human{

    }

    public void sayHello(Human guy){

        System.out.println("hello, guy!");

    }

    public void sayHello(Man guy){

        System.out.println("hello, gentleman!");

    }

    public void sayHello(Woman guy){

        System.out.println("hello, lady!");

    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch std = new StaticDispatch();
        std.sayHello(man);
        std.sayHello(woman);
    }
}


/* Human man = new Man();
上面代码中"Human"称为静态类型，或者叫做外观类型，后面的"Man"则称为变量的实际类型。静态类型和实际类型程序中发生变化
区别：静态类型的变化仅仅发生在使用期，变量本身的静态类型不会发生改变，并且最终的静态类型是在编译器可知的：
而实际类型的
*/