package com.panyu.jase.java8;

import com.panyu.dao.Person;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 三个操作步骤：
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作
 */
public class TestStreamAPI2 {

    List<Person> persons = Arrays.asList(
            new Person("张三", 18),
            new Person("李四", 55),
            new Person("王五", 33),
            new Person("朱六", 44),
            new Person("田七", 22),
            new Person("田七", 22),
            new Person("田七", 22)
    );

    /**
     * 排序
     * sorted()——自然排序
     * sorted(Comparator com)——定制排序
     */
    @Test
    public void test6() {
        List<String> list = Arrays.asList("bbb", "ccc", "aaa", "ddd", "eee");
        list.stream()
                .sorted()
                .forEach(System.out::println);


        persons.stream()
                .sorted((p1,p2)->{
                    if (p1.getAge()==p2.getAge()){
                        return p1.getName().compareTo(p2.getName());
                    }else {
                        return -p1.getAge()>p2.getAge()?-1:1;
                    }
                }).forEach(System.out::println);

    }


    /**
     * map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        List<Object> list2 = new ArrayList<>();

        list2.add(11);
        list2.add(22);
        list2.add(list);
        System.out.println(list2);

        list2.addAll(list);
        System.out.println(list2);


    }

    @Test
    public void test4() {

        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);


        persons.stream()
                .distinct()
                .map(Person::getName)
                .forEach(System.out::println);

        list.stream()
                .flatMap(this::filterCharacter)
                .forEach(System.out::println);
    }


    public Stream<Character> filterCharacter(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    //中间操作
    /*
        筛选与切片
        filter(Predicate p)—— 接收Lambda，从六中排除某些元素
        distinct()—— 筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        limit(long maxSize)—— 截断流，使其元素不超过给定数量
        skip(long n)—— 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补。
     */

    @Test
    public void test3() {
        persons.stream()
                .distinct()
                .filter((p) -> {
                    System.out.println("留下");
                    return p.getAge() > 22;
                })
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        persons.stream()
                .skip(2)
                .filter((p) -> {
                    System.out.println("留下");
                    return p.getAge() > 22;
                })
                .forEach(System.out::println);
    }

    // 内部迭代：迭代操作由Stream API完成
    @Test
    public void test1() {

        // 中间操作：不会执行任何操作
        Stream<Person> stream = persons.stream()
                .limit(3)
                .filter((p) -> {
                    System.out.println("Stream API 的中间操作");
                    return p.getAge() > 20;
                });
        // 终止操作：一次性执行全部内容（惰性求值））
        stream.forEach(System.out::println);

    }

}
