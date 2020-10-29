package com.panyu.springdemo.soundsystem.jase.reflect;

import java.lang.reflect.Constructor;

public class ReflectDemo2 {


    public static void main(String[] args) throws Exception {
        /*
         * 演示如何根据指定的名称获取指定的Class对象后建立该类的对象
         * */

//        getObject();
        getObject2();

    }

    private static void getObject2() throws Exception {

        /*
        * 带参数的构造器
        * */
        String className = "cn.panyu.domain.Person";
        Class clazz = Class.forName(className);

        //对应的类型对象class类型
        Constructor cons = clazz.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("lisisi", 23);


    }

    private static void getObject() throws ClassNotFoundException, IllegalAccessException, InstantiationException {


        //1、根据给定的名称获取Class对象

        String className = "cn.panyu.domain.Person";
        Class clazz = Class.forName(className);

        //2、创建一个Person对象 默认调用该类的空参数构造函数
        // 一般被反射的类，通常都有空参数的构造函数
        Object obj = clazz.newInstance();
    }

}
