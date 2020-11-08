package com.panyu.jase.reflect;

public class MouseByUSB implements USB {
    @Override
    public void close() {
        System.out.println("mouse close");
    }

    @Override
    public void open() {
        System.out.println("mouse open");
    }
}
