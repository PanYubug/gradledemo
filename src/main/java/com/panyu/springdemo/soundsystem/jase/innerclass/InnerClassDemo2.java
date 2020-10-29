package com.panyu.springdemo.soundsystem.jase.innerclass;


/*
// 为什么内部类可以直接访问外部类中的成员
// 那是因为内部类持有了外部的引用，外部类名.this
class Outer2{
    int num = 2;
    class Inner{
        int num =3;
        void show(){
            int num =4;
            System.out.println("show..."+num);
            System.out.println("show...."+this.num);
            System.out.println("show....."+Outer2.this.num);
        }
    }
    public void method(){
        new Inner().show();
    }
}
*/

//将内部类定义到局部位置上，注意：局部内部类，只能访问被final修饰的局部变量。
class Outer3{
    private int num = 4;
    void method(){
        final int x = 5;
        class Inner{
            void show(){
                System.out.println("x..."+x);
                System.out.println("show...."+num);
            }
        }
        new Inner().show();
    }
}

public class InnerClassDemo2 {
    public static void main(String[] args) {
//        new Outer2().method();
//        System.out.println();

        new Outer3().method();
    }
}
