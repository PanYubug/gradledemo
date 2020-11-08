package com.panyu.jase.collectionsdemo;

import com.panyu.dao.Person;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        System.out.println("集合是否为空："+people.isEmpty());
        people.add(0, new Person("张三", 12));
        people.add(1, new Person("李四", 9));
        people.add(2, new Person("王五", 22));
        people.add(3, new Person("杨六", 43));
        Person xiaoqi = new Person("小七", 7);
        people.add(4, xiaoqi);

        System.out.println("集合中元素的个数："+people.size());
        System.out.println("集合中是否含有小七："+people.contains(xiaoqi));
        System.out.println("集合是否为空："+people.isEmpty());

        Iterator<Person> it = people.iterator();
        while (it.hasNext()){
            Person next = it.next();
            System.out.println(next.toString());
        }

        System.out.println("删除元素index=4");
        people.remove(4);
        System.out.println("再次查看，集合中是否含有小七："+people.contains(xiaoqi));

        Object[] objects = people.toArray();
        for (int i = 0; i < objects.length; i++) {
            Person per = (Person) objects[i];
            System.out.println(per.toString());
        }

    }
}
