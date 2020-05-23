package com.panyu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List list =  new ArrayList();

        Person p1 = new Person("zhangsan", 10);
        Person p2 = new Person("lisi", 20);

        list.add(p1);
        list.add(p2);

        for (Iterator it = list.iterator();it.hasNext(); ) {
            Person p = (Person) it.next();
            System.out.println(p.getName()+":"+ p.getAge());
        }
    }
}
