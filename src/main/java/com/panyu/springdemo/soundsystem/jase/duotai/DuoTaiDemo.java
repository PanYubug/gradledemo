package com.panyu.springdemo.soundsystem.jase.duotai;

/*
* 多态：多种形态。
*   重点说的是：对象的多态性
*
* class 动物
* {
*
* }
*
* class 动物 extends 动物
* {}
* 狗 x = new 狗();
* 动物 x = new 狗();//狗实例既是狗类型，又是动物类型。多态性
*
* 多态在程序中的体现：父类的引用或者接口的引用指向了子类的对象
*
* 多态的好处：提高了代码的扩展性
*
* 多态的弊端：不能使用子类的特有方法
*
* 多态的前提：
*          1、必须有关系，继承，实现。
*          2、通常有覆盖。
*          3、
*
* */


abstract class Animal{
    abstract void eat();
}

class Dog extends Animal{
    @Override
    //向上转型
    /*
    * 向上转型的好处：隐藏了子类型，提高了代码扩展性
    *         弊端：只能使用父类中的功能，不能使用子类特有功能。功能被限定
    * 如果不需要面对子类型，通过提高了扩展，或者使用父类的功能即可完成操作，就可以向上转型
    *
    * 向下转型的好处：可以使用子类型的特有功能，
    *         弊端：面对具体的子类型向下转型有风险。容易发生ClassCastException。只要转换类型和对象类型不匹配就会发生
    *               想要安全必须判断，判断一个对象是否匹配某一类型，
    *               需要使用一个关键字 instanceof 对象  instanceof 类型
    * 什么时候使用向下转型：需要子类型的特有方法时，但一定要有判断
    *
    *
    * 如果想要使用子类型的特有功能，
    * */
    void eat() {
        System.out.println("骨头");
    }
    void lookHome(){
        System.out.println("看家");
    }

}

class Cat extends Animal{

    @Override
    void eat() {
        System.out.println("骨头");
    }
    void CatMouse(){
        System.out.println("抓老鼠");
    }
}


public class DuoTaiDemo {
    public static void main(String[] args) {
        Animal a = new Dog();
//        a.eat();
//
//        Animal a1 = new Cat();
//        a.eat();

//        Dog d1 = new Dog();
//        Dog d2 = new Dog();
//        Dog d3 = new Dog();
//        Dog d4 = new Dog();
//        d1.eat();
//        d2.eat();
//        d3.eat();
//        d4.eat();

        method(new Dog());
        if (!(a instanceof Dog)) {
            return;
        }
        Dog d = (Dog) a;
        d.lookHome();

    }

    public static void method(Animal a){
        a.eat();
    }
}
