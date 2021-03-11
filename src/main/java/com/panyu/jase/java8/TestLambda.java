package com.panyu.jase.java8;

import com.panyu.dao.Person;
import org.testng.annotations.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestLambda {

    @Test
    public void test1() {
        Runnable r1 = () -> System.out.println("Hello World");
        r1.run();
    }

    @Test
    public void test2() {
//        Consumer<String> con = (x) -> System.out.println(x);
        Consumer<String> con = x -> System.out.println(x);
        con.accept("Hello World");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        com.compare(1, 2);
    }

    // 需求：对一个数进行计算

    @Test
    public void test5() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);

        System.out.println(operation(200, (x) -> x + 200));
    }

    public Integer operation(Integer num, MyFunctionalInterFace<Integer> mf) {
        return mf.getValue(num);
    }

    @Test
    public void test6() {
        List<Person> persons = Arrays.asList(
                new Person("张三", 18),
                new Person("李四", 55),
                new Person("王五", 33),
                new Person("朱六", 44),
                new Person("田七", 22)
        );

        Collections.sort(persons, (p1, p2) -> {
            if (p1.getAge() == p2.getAge()) {
                return p1.getName().compareTo(p2.getName());
            } else {
//                return Integer.compare(p1.getAge(), p2.getAge());
                // 倒序
                return -Integer.compare(p1.getAge(), p2.getAge());
            }
        });

        for (Person person : persons) {
            System.out.println(person);
        }

    }

    @Test
    public void test7() {

        String trimStr = strHandler("\t\t\t 你好,世界", (str) -> str.trim());
        System.out.println(trimStr);

        String upper = strHandler("abcdd", (str) -> str.toUpperCase());
        System.out.println(upper);

        String newStr = strHandler("你好，世界上最好的人", (str) -> str.substring(2, 5));
        System.out.println(newStr);

    }

    // 需求：用于处理字符串
    public String strHandler(String str, MyFunctionalInterFace<String> mf) {
        return mf.getValue(str);
    }

    // 需求：对于两个Long型数据进行处理
    public void op(Long l1, Long l2, MyFunction<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }

    @Test
    public void test8() {
        op(100L, 200L, (x, y) -> x + y);

        op(100L, 200L, (x, y) -> x * y);
    }


    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }


    @Test
    public void test9() {
        happy(10000, (m) -> System.out.println("买手机，每次消费" + m + "元"));
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    @Test
    public void test10() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    public String strHandler1(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    @Test
    public void test11() {
        String newStr = strHandler1("\t\t\t\t 你好世界Java ", (str) -> str.trim());
        System.out.println(newStr);

        String subStr1 = strHandler1("你好世界Java", (str) -> str.substring(2, 5));
        System.out.println(subStr1);

    }

    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        ArrayList<String> strList = new ArrayList<>();
        for (String str : strList) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }


    @Test
    public void test12() {
        List<String> list = Arrays.asList("Hello", "Lambda", "ok", "www", "world");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);
        for (String s : strList) {
            System.out.println(s);
        }
    }

}
