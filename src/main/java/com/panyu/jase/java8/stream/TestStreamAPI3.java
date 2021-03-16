package com.panyu.jase.java8.stream;

import com.panyu.dao.Person;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamAPI3 {

    List<Person> persons = Arrays.asList(
            new Person("张三", 18, 9999.99, Person.Status.FREE),
            new Person("李四", 55, 5555.55, Person.Status.BUSY),
            new Person("王五", 33, 3333.33, Person.Status.VOCATION),
            new Person("朱六", 44, 6666.66, Person.Status.FREE)
    );

    /**
     * 收集
     */
    @Test
    public void test10() {
        String str = persons.stream()
                .map(Person::getName)
                .collect(Collectors.joining(",", "===", "===1"));
        System.out.println(str);
    }

    @Test
    public void test9() {
        DoubleSummaryStatistics collect = persons.stream()
                .collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println(collect.getSum());
        System.out.println(collect.getAverage());
        System.out.println(collect.getMax());
    }

    //分区
    @Test
    public void test8() {
        Map<Boolean, List<Person>> map = persons.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(map);
    }

    //多级分组
    @Test
    public void test7() {
        Map<Person.Status, Map<String, List<Person>>> map = persons.stream()
                .collect(Collectors.groupingBy(Person::getStatus, Collectors.groupingBy((p) -> {
                    if (p.getAge() <= 35) {
                        return "青年";
                    } else if (p.getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(map);
    }


    // 分组
    @Test
    public void test6() {
        Map<Person.Status, List<Person>> map = persons.stream()
                .collect(Collectors.groupingBy(Person::getStatus));
        System.out.println(map);
    }

    @Test
    public void test5() {
        Long count = persons.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        Double avg = persons.stream()
                .collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println(avg);

        Double sum = persons.stream()
                .collect(Collectors.summingDouble(Person::getSalary));
        System.out.println(sum);

        Optional<Person> max = persons.stream()
                .collect(Collectors.maxBy((p1, p2) -> Double.compare(p1.getSalary(), p2.getSalary())));
        System.out.println(max.get());

        Optional<Double> min = persons.stream()
                .map(Person::getSalary)
                .collect(Collectors.minBy(Double::compareTo));
        System.out.println(min.get());
    }

    @Test
    public void test4() {

        List<String> list = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        Set<String> set = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        HashSet<String> hs = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hs.forEach(System.out::println);
    }

    /**
     * 规约
     * reduce(T identity， BinaryOperator)/reduce(BinaryOperator)
     * 可以将流中元素反复结合起来，得到一个值
     */

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Double> sum2 = persons.stream()
                .map(Person::getSalary)
                .reduce(Double::sum);
        System.out.println(sum2.get());
    }

    /**
     * allMatch(Predicate p) 检查是否匹配所有元素
     * anyMatch(Predicate p) 检查是否至少匹配一个元素
     * noneMatch(Predicate p) 检查是否没有匹配所有元素
     * findFirst() 返回第一个元素
     * findAny() 返回当前流中的任意元素
     * count
     * max
     * min
     */

    @Test
    public void test2() {
        long count = persons.stream()
                .count();
        System.out.println(count);

        Optional<Person> op1 = persons.stream()
                .max((p1, p2) -> Double.compare(p1.getSalary(), p2.getSalary()));
        System.out.println(op1.get());

        Optional<Double> op2 = persons.stream()
                .map(Person::getSalary)
                .min(Double::compareTo);
        System.out.println(op2.get());
    }

    @Test
    public void test1() {

        boolean b1 = persons.stream()
                .allMatch((p) -> p.getStatus().equals(Person.Status.BUSY));
        System.out.println(b1);

        boolean b2 = persons.stream()
                .anyMatch((p) -> p.getStatus().equals(Person.Status.BUSY));
        System.out.println(b2);

        boolean b3 = persons.stream()
                .noneMatch((p) -> p.getStatus().equals(Person.Status.BUSY));
        System.out.println(b3);

        Optional<Person> op = persons.stream()
                .sorted((p1, p2) -> Double.compare(p1.getSalary(), p2.getSalary()))
                .findFirst();
        System.out.println(op.get());

        Optional<Person> op2 = persons.stream()
                .filter((p) -> p.getStatus().equals(Person.Status.FREE))
                .findAny();
        System.out.println(op2.get());
    }
}
