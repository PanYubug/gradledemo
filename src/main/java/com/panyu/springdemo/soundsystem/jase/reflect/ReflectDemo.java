package com.panyu.springdemo.soundsystem.jase.reflect;


import com.panyu.demo.soundsystem.Person;

public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        /*
         * 反射技术：动态的获取类以及类中的成员，并可以调用该类的成员
         * 以前是有什么类，就new什么类，没有类，给什么类就new什么类
         *
         * 最重要的一点是，先获取class类的引用
         *
         * 无论获取什么对象，都需要获取字节码文件，
         * 如何获取？
         *   发现java已经对字节码文件进行了描述，用的Class类完成的
         *
         * */

        //获取class对象的
        //方法一 object getClass发现在反射技术里，该方法不合适，反射技术是不明确具体类的

        //方法二 所有的数据类型都有自己的Class对象，便是方式很简单
        //每一个数据类型都有一个默认的静态的属性。.class，用该属性就可以获取字节码文件对象
        //虽然不用对象调用了，还是要用具体的类调用静态属性

        //*********方法三 在Class中找到了forName方法，通过名称就可以获取字节码文件对象。重点

//        methodDemo_1();
//        methodDemo_2();
        methodDemo_3();
    }

    private static void methodDemo_3() throws ClassNotFoundException {

        String name = "cn.panyu.domain.Person";
        Class clazz = Class.forName(name);
        System.out.println(clazz);
    }


    public static void methodDemo_1(){
        //调用getclass先有对象
        Person p = new Person();
        Class clazz = p.getClass();
        System.out.println(clazz);
    }

    public static void methodDemo_2(){
        Class clazz = Person.class;
        Class clazz2 = Person.class;
    }


}
