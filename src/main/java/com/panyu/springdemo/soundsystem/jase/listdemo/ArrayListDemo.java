package com.panyu.springdemo.soundsystem.jase.listdemo;


import com.panyu.demo.soundsystem.Person;

import java.util.ArrayList;

import static com.panyu.demo.soundsystem.jase.listdemo.ArrayListDemo2.singleElement2;


public class ArrayListDemo {
    public static void main(String[] args) {
        /*
        * 练习：
        * 1、往ArrayList中存储自定义对象。Person(name,age)
        * 思路：
        *  1、描述Person
        *  2、定义容器对象
        *  3、将多个Person对象，存储到集合中
        *  4、取出Person对象。
        * */


        //1、创建ArrayList集合对象
        ArrayList list = new ArrayList();
        //2、添加Person类型的对象
        Person p1 = new Person("lisi1",21);
        Person p2 = new Person("lisi2",21);

        list.add(p1);
        list.add(p2);
        list.add(new Person("lisi3",23));
        list.add(new Person("lisi1",21));
        list.add(new Person("lisi2",22));
        list.add(new Person("lisi3",23));
        list.add(new Person("lisi1",21));
        list.add(new Person("lisi2",22));

        //3、取出元素
//        for (Iterator it = list.iterator(); it.hasNext(); ) {
//            //next()取出的元素都是Object类型的,需要用到具体对象内容时，需要向下转型
//            Person p = (Person) it.next();
//            System.out.println("姓名:"+p.getName()+",年龄:"+p.getAge());
//
//        }

        System.out.println(list);
        singleElement2(list);
        System.out.println(list);
    }

}
