package com.panyu.jase.java8.stream;

import com.panyu.dao.Person;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI4 {

    /*
        1、给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
        给定【1, 2, 3, 4, 5】，应该返回[1, 4, 9, 16, 25]
     */
    @Test
    public void test1() {
        Integer[] nums = {1, 2, 3, 4, 5};
        Arrays.stream(nums)
                .map((x) -> x * x)
                .forEach(System.out::println);
    }

    /*
        2、怎样用map和reduce方法数一数流中有多少个Person呢？
     */
    List<Person> persons = Arrays.asList(
            new Person("张三", 18, 9999.99, Person.Status.FREE),
            new Person("李四", 55, 5555.55, Person.Status.BUSY),
            new Person("王五", 33, 3333.33, Person.Status.VOCATION),
            new Person("朱六", 44, 6666.66, Person.Status.FREE)
    );

    @Test
    public void test2() {
        Optional<Integer> count = persons.stream()
                .map((p) -> 1)
                .reduce(Integer::sum);
        System.out.println(count.get());
    }
}
