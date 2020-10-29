package com.panyu.springdemo.injectionmode;

public class InjectionService2 {

    private InjectionDAO2 injectionDAO2;

    // 设置注入必须
    public InjectionService2(InjectionDAO2 injectionDAO2) {
        this.injectionDAO2 = injectionDAO2;
    }

    public void say(String arg) {
        injectionDAO2.hello(arg);
    }
}
