package com.panyu.springdemo.soundsystem.jase.collectiondemo;

import java.util.ArrayList;
import java.util.Collection;

public class ForEachDemo {
    public static void main(String[] args) {
        /*
        * jdk1.5特性，
        * 增强for循环，作用：用于遍历Collection集合or数组。
        * 格式：
        * for(元素类型变量:Collection容器或者数组){
        * }
        *
        * 传统for和增强for有什么区别？
        * 增强for有限制：
        *               必须有被遍历的目标。该目标是Collection和数组
        *
        * */

        Collection coll = new ArrayList();
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");

//        for (Iterator it = coll.iterator(); it.hasNext(); ) {
//            String next = (String) it.next();
//            System.out.println(next);
//        for (Object obj:coll
//             ) {
//            System.out.println(obj);
//        }
//
//        }
        for (Object it : coll) {
            System.out.println(it);
        }

        //对于数组的遍历，如果不操作其角标，可以使用增强for，如果要使用角标，使用传统for
        int[] arr = {23, 12, 14, 49};
        for (int i : arr) {
            System.out.println(i);
        }


    }
}
