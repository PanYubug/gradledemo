package com.panyu.springdemo.soundsystem.jase.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        //为了运行时期不出现类型异常。可以再定义容器时，就明确容器中的元素的类型
        List<String> list = new ArrayList<String>();

        list.add("abc");
//        list.add(4); //list.add(Integer.valueOf(4));

        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String next =  it.next();
            System.out.println(next);

        }

    }
}
