package com.panyu.springdemo.soundsystem.jase.collectiondemo;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class EnumerationDemo {
    public static void main(String[] args) {
        /*
        * Enumeration
        * 取出元素的一种方式：枚举
        * 只有一个容器具备：Vector
        *
        * */

        Vector v = new Vector();
        v.add("abc1");
        v.add("abc2");
        v.add("abc3");
        v.add("abc4");

        //枚举
        Enumeration en = v.elements();
        while (en.hasMoreElements()){
            System.out.println(en.nextElement());
        }
        
        //迭代器
        for (Iterator it = v.iterator(); it.hasNext(); ) {
            String next = (String) it.next();
            System.out.println(next);

        }

        //foreach
        for (Object o : v) {
            System.out.println(o);
        }
    }
}
