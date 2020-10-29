package com.panyu.springdemo.soundsystem.jase.reflect;

import java.lang.reflect.Field;

public class ReflectDemo3 {

    public static void main(String[] args) throws Exception {
        /*
        * 获取类中的成员
        * 获取反射字段
        * */

        getFieldDemo();
    }

    private static void getFieldDemo() throws Exception {

        String className = "cn.panyu.domain.Person";
        Class clazz = Class.forName(className);

//        Field field = clazz.getField("age");

        Field[] field = clazz.getDeclaredFields();
        System.out.println(field);

    }
}
