package com.panyu.jase.enumdemo;

public class EnumDemo {
    public static void main(String[] args) {
        System.out.println(PizzaStatus.ORDERED.name());
        System.out.println(PizzaStatus.ORDERED);
        System.out.println(PizzaStatus.ORDERED.name().getClass());
        System.out.println(PizzaStatus.ORDERED.getClass());
    }
}
