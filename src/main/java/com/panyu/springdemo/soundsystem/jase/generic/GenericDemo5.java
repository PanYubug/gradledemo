package com.panyu.springdemo.soundsystem.jase.generic;

public class GenericDemo5 {
    public static void main(String[] args) {
        SubDemo sd = new SubDemo();
        sd.show("abc");

    }
}


interface Inter<T>{
    public void show(T t);
}

class InterImpl<W> implements Inter<W>{

    @Override
    public void show(W w) {
        System.out.println("show:"+w);
    }
}

class SubDemo extends InterImpl<String>{

}

//class InterImpl implements Inter<String>{
//
//    @Override
//    public void show(String s) {
//
//    }
//}