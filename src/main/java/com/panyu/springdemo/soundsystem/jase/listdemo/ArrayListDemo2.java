package com.panyu.springdemo.soundsystem.jase.listdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo2 {
    public static void main(String[] args) {
        /*
         *  练习2:定义功能，请除去ArrayList集合中的重复元素
         *
         *  方法一：
         *  方法二：1、最后唯一性的元素也很多，可以先定义一个人容器用于存储这些唯一性的元素
         *         2、对原有容器进行元素的获取，并到临时容器中去判断是否存在。容器本身就有这个功能，判断元素是否存在
         *         3、存在就不存储，不存在就存储
         *
         * */

        List list = new ArrayList();
        list.add("abc1");
        list.add("abc4");
        list.add("abc2");
        list.add("abc1");
        list.add("abc4");
        list.add("abc2");
        list.add("abc1");
        list.add("abc4");
        list.add("abc2");

        System.out.println(list);
//        singleElement(list);
        singleElement2(list);
        System.out.println(list);

    }

    public static void singleElement2(List list) {
        //1、定义一个容器
        List temp = new ArrayList();
        //2、遍历原容器
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Object obj = (Object) it.next();
            //3、在临时容器中判断遍历到的元素是否存在
            if (!temp.contains(obj)) {
                //4、如果不存在就存储到临时容器中
                temp.add(obj);
            }
        }
        //5、将原容器情况
        list.clear();
        //6、将临时容器中的元素都存储到原容器中
        list.addAll(temp);
    }

    public static void singleElement(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Object o = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Object o1 = list.get(j);
                if (o.equals(o1)) {
                    list.remove(j);
                    j--;
                }

            }
        }
    }

}
