package com.panyu.springdemo.injectionmode;

public class AutoWireService {

    private AutoWireDAO autoWireDAO;

    public void setAutoWireDAO(AutoWireDAO autoWireDAO) {
        this.autoWireDAO = autoWireDAO;
    }
    public void say(){
        autoWireDAO.hello();
    }
}
