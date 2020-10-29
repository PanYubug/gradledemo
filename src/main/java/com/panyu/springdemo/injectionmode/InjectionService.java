package com.panyu.springdemo.injectionmode;

public class InjectionService {

    private InjectionDAO injectionDAO;

    // 设值注入必须
    public void setInjectionDAO(InjectionDAO injectionDAO) {
        this.injectionDAO = injectionDAO;
    }

    public void say(String arg){
        injectionDAO.hello(arg);
    }
}
