package com.panyu.jase.java8;

public class SubMyClass /*extends MyClass*/ implements MyFun, MyFunInterface {


    @Override
    public String getName() {
        return MyFun.super.getName();
    }
}
