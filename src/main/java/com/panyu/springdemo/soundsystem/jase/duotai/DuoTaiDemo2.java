package com.panyu.springdemo.soundsystem.jase.duotai;


/*
 * 1、成员变量。
 *   当子父类中出现同名成员变量时。
 *   多态调用时，只看调用该成员变量的引用所属的类中的成员变量。
 *
 *   简单说：无论编译或者运行，都看等号的左边
 *
 * 2、成员函数
 *   出现一模一样函数时，
 *   多态调用
 *   编译时，看的事引用变量所属的类中的方法
 *   运行时，看的是对象所属类中的方法
 *
 *   简单说：编译看左边，运行看右边
 *   成员方法动态绑定到对象上
 *
 * 3、静态函数
 *    出现一模一样函数时，
 *    多态调用
 *    编译和运行是看引用变量所属类中的方法
 *    简单说：编译运行看左边
 *    其实大家知道，真正调用静态方法时不需要对象的，直接类名调用，静态方法绑定到类上，所以上述情况，更多用于面试
 *
 * */

class Fu {
    int num = 4;

    void show() {
        System.out.println("fu show");
    }
    static void method(){
        System.out.println("fu static method");
    }
}

class Zi extends Fu {
    int num = 6;

    void show() {
        System.out.println("zi show");
    }
    static void method(){
        System.out.println("zi static method");
    }
}

public class DuoTaiDemo2 {
    public static void main(String[] args) {
        Fu f = new Zi();
        System.out.println(f.num);

        f.show();
        f.method();
    }

}
