package com.panyu.jase.java8;

public interface MyFunInterface {

    default String getName(){
        return "呵呵呵";
    }

    public static void show(){
        System.out.println("接口中的静态方法");
    }
}
