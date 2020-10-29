package com.panyu.springdemo.soundsystem.jase.innerclass;


/*
* 匿名内部类
* 简化书写，内部类
*
* 必须继承或者实现外部的类或者接口
*
* 格式：
*   new 父类or接口名(){
*   }
*
* 匿名内部类其实就是一个子类对象
* */


abstract class Demo4{
    abstract void show();
}

class Outer4{
    private int num = 4;
//    class Inner extends Demo4{
//        public void show(){
//            System.out.println("show..."+num);
//        }
//    }
    public void method(){

//        new Inner().show();
        new Demo4(){
            //覆盖demo中的抽象方法
            public void show(){
                System.out.println("show...."+num);
            }
        }.show();
    }
}


public class InnerClassDemo3 {
    public static void main(String[] args) {
        new Outer4().method();
    }
}
