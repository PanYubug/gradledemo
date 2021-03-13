package com.panyu.jase.java8;

import com.panyu.dao.Person;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.function.*;

public class TestMethodRef {

    //对象::实例方法名
    @Test
    public void test1() {

        Consumer<String> con = System.out::println;
        con.accept("abcdd");

        Person p1 = new Person("张三", 12);
        Supplier<String> sup = p1::getName;
        String s = sup.get();
        System.out.println(s);
    }

    //类::静态方法名
    @Test
    public void test2() {

        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> com1 = Integer::compareTo;

    }

    //类::实例方法名
    @Test
    public void test3() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        BiPredicate<String, String> bp2 = String::equals;
    }

    //构造器引用
    @Test
    public void test4(){
        Supplier<Person> sup = ()->new Person();
        //构造器引用方式
        Supplier<Person> sup2 = Person::new;
        Person person = sup2.get();
        System.out.println(person);
    }

    @Test
    public void test5(){

        Function<Integer, Person> fun = (x)->new Person(x);
        Function<Integer, Person> fun2 = Person::new;
        Person person = fun2.apply(18);
        System.out.println(person);

        BiFunction<String, Integer, Person> bf = Person::new;
        Person person1 = bf.apply("李四", 22);
        System.out.println(person1);

    }

    // 数组引用
    @Test
    public void test6(){
        Function<Integer, String[]> fun = (x)->new String[x];
        String[] str = fun.apply(10);
        System.out.println(str.length);

        Function<Integer, String[]> fun2 = String[]::new;
        String[] str2 = fun2.apply(20);
        System.out.println(str2.length);
    }
}
