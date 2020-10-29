package com.panyu.springdemo.soundsystem.jase.innerclass;


/*
 * 内部类：
 *       将内定义到另一个类的内部。
 *
 * A类要直接访问B类中的成员时，可以将A类定义到B类中，作为B类
 *
 *
 * 访问规则
 *       内部类可以直接访问外部类中的成员。
 *       外部类要想访问内部类，只能创建内部类的对象来访问
 *
 * */

class Outer {
    private static int num = 4;

    //内部类
    class Inner {
        void show() {
            System.out.println(num);
        }
    }

    static class Inner2{
//        static final int count = 5;//非静态的内部类中，只允许定义静态常量。不能定义其他静态成员
        void show2(){
            System.out.println("show2..."+num);
        }
        static void show3(){
            System.out.println("show3..."+num);
        }
    }

    public void Method() {
        Inner in = new Inner();
        in.show();
    }


}


public class InnerClassDemo {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.Method();

        //非静态,非私有
        //如果内部类权限是非私有的，就可以在外部其他程序中的被访问到，就可以通过创建外部类对象完成。
        //创建的是内部对象
//        Outer.Inner in = new Outer().new Inner();
//        in.show();

        //静态，非私有，访问非静态成员
//        Outer.Inner2 in2 = new Outer.Inner2();
//        in2.show2();

        //静态，非私有，访问静态成员
//        Outer.Inner2.show3();
    }

}
