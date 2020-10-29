package com.panyu.springdemo.soundsystem.jase.generic;


import com.panyu.springdemo.soundsystem.Person;

import java.util.Set;
import java.util.TreeSet;

public class GenericDemo2 {
    public static void main(String[] args) {
        Set<Person> set = new TreeSet<Person>(new ComparatorByName() );

//        set = new HashSet<Person>();

        set.add(new Person("abcd", 22));
        set.add(new Person("aa", 23));
        set.add(new Person("nba", 25));
        set.add(new Person("cba", 24));

        for (Person p : set) {
            System.out.println(p);
        }
    }
}
