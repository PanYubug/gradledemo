package com.panyu.springdemo.soundsystem.jase.reflect;


import com.panyu.dao.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {

    public static void main(String[] args) throws Exception {

        String name = "com.panyu.dao.Person";
        Class clazz = Class.forName(name);
        System.out.println("clazz的反射类为：" + clazz);
        // 获取构造函数
        // 1、获取构造函数,默认构造函数
        Object person = clazz.newInstance();
        System.out.println("clazz默认构造函数为： " + person.toString());
        // 2、获取指定构造函数
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Person zhangsan = (Person) constructor.newInstance("zhangsan", 22);
        System.out.println("zhangsan的实例为： " + zhangsan.toString());
        // 3、获取所有的构造函数
        Constructor[] constructors = clazz.getConstructors();
        System.out.print("clazz的构造函数的参数有：");
        for (Constructor constructor1 : constructors) {
            Class[] clazzList = constructor1.getParameterTypes();
            for (Class clazz1 : clazzList) {
                System.out.println(clazz1.getName());
            }
        }
        // 获取字段
        // 1、只能拿到public
        Field fieldName = clazz.getField("name");
        System.out.print("name: " + fieldName);
        System.out.println("value：" + fieldName.get(zhangsan));
        // 2、获取指定字段
        Field fieldAge = clazz.getDeclaredField("age");
        System.out.print("age: " + fieldAge);
        // 2.1 暴力获取
        fieldAge.setAccessible(true);
        System.out.println("value：" + fieldAge.get(zhangsan));
        // 3、获取所有字段
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("clazz的所有字段有：");
        for (Field field1 : fields) {
            System.out.println(field1);
        }
        // 获取方法
        // 1、获取指定方法
        Class<?> aClass = Class.forName("com.panyu.springdemo.soundsystem.jase.reflect.ReflectDemo");
        Method methodReflect = aClass.getDeclaredMethod("reflectMethod", String.class, int.class);
        System.out.println("reflectMethod：" + methodReflect);
        // 2、获取所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("clazz方法有：");
        for (Method declaredMethod : declaredMethods) {
            System.out.print(declaredMethod);
            System.out.println("返回参数：" + declaredMethod.getReturnType());
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("入参：" + parameterType);
            }
        }
        // 调用方法
        Method reflectMethod = aClass.getDeclaredMethod("reflectMethod", String.class, int.class);
        reflectMethod.invoke(aClass.newInstance(), "李四", 33);
        // 3、暴力获取值


        Class superClass = clazz.getSuperclass();
        System.out.println("clazz的父类为：" + superClass.getName());
        Class[] interfaces = clazz.getInterfaces();
        System.out.println("clazz实现的接口有：");
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
    }


    private void reflectMethod(String name, int age) {
        System.out.print("反射机制，调用方法——");
        System.out.println("name：" + name + "，age:" + age);
    }

}
