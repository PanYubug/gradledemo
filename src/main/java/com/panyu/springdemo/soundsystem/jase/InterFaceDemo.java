package com.panyu.springdemo.soundsystem.jase;




/*
* 接口中的成员和class定义不同之处：
* 接口中常见的成员有两种：1、全局常量，2、抽象方法
* 而且都有固定的修饰符，共性：成员都是public修饰的
*
*
* 接口的特点：
* 1、接口不可以实例化
* 2、需要覆盖了接口中的所有抽象方法的子类。才可以实例化
*   否则，该子类还是一个抽象函数
*
* 3、接口是用来被实现的
*
* 类和接口之间的关系是，实现关系
*
*
*
* 接口的好处或者解决了什么问题
* 多继承
*   好处：可以让子类具备更多的功能，弊端：调用的不确定性
*
*
* java中不支持多继承，而是对该机制进行改良。
* 通过接口来解决问题
*
*
* 因为继承具备所属的体系具备了该体系的基本功能
* 还想扩展一些功能，具备show1功能
* 一个类继承一个类的同时，还可以实现多个接口。
* 避免了单继承的局限性
*
* 继承是为了获取体系的基本功能。想要扩展功能可以通过实现接口来完成
*
*
* 类与类之间     继承关系
* 类与接口之间 实现关系
* 接口与接口之间是什么关系？
* 继承关系，而且是多继承
*
*
* 抽象类中可以不定义抽象方法
*
*
*
* 抽象类和接口的区别？
*
* 1、类与类之间是继承关系， is a
*    类与接口之间是实现关系， like a
* 2、抽象类中可以定义抽象和非抽象的方法。子类可以直接使用，或者覆盖使用
*   接口中定义都是抽象方法，必须实现才能使用
*
* 类用于描述是事物的共性基本功能
* 接口用于定义的都是事物的额外功能
*
* */
public class InterFaceDemo {
    public static void main(String[] args) {
        System.out.println("。。。");
    }
}


interface Inter{
    void show1();
    void show2();
    void show3();
    void show4();
}

/*
* 没有抽象方法的抽象类
* */
abstract class Demo2 implements Inter{


    @Override
    public void show1() {

    }

    @Override
    public void show2() {

    }

    @Override
    public void show3() {

    }

    @Override
    public void show4() {

    }
}

/*
* 使用接口中的部分方法。比如使用show2
*
* */
class DemoA extends Demo2{
    @Override
    public void show2() {
        System.out.println("asdhfisahp");
    }
}


interface Inter1{
    void show1();
}

interface Inter2{
    void show1();
    void show2();
}


class SubInter implements Inter1, Inter2{

    @Override
    public void show1() {

    }

    @Override
    public void show2() {

    }
}