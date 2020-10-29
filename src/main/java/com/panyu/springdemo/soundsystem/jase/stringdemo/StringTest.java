package com.panyu.springdemo.soundsystem.jase.stringdemo;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "java";
        testDemo(s1,s2);
        System.out.println(s1+"........."+s2);
    }

    private static void testDemo(String s1, String s2) {
        s2.replace('a','o');
        s1 = s2;

    }

}
