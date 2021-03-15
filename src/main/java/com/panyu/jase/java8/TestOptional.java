package com.panyu.jase.java8;

import com.panyu.dao.Person;
import org.testng.annotations.Test;

import java.util.Optional;

public class TestOptional {

    /**
     * Optional.of(T t)：创建一个Optional实例
     * Optional.empty()：创建一个空的Optional实例
     * Optional.ofNullable(T t)：若t不为null，创建Optional实例，否则创建空实例
     * isPresent()：判断是否包含值
     * orElse(T t)：如果调用对象包含值，返回该值，否则返回t
     * orElseGet(Supplier s)：如果调用对象包含值，返回该值，否则返回s获取的值
     * map(Function f)：如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
     * flatMap(Function mapper)：与map类似，要求返回值必须是Optional
     */
    @Test
    public void test4() {
        Optional<Person> op = Optional.of(new Person("张三", 18, 8888.88, Person.Status.FREE));
//        Optional<String> str = op.map(Person::getName);
//        System.out.println(str.get());

        Optional<String> str = op.flatMap((p) -> Optional.of(p.getName()));
        System.out.println(str.get());
    }

    @Test
    public void test3() {
        Optional<Person> op = Optional.ofNullable(null);
//        op.ifPresent(System.out::println);

//        Person person = op.orElse(new Person("张三", 18, 8888.88, Person.Status.FREE));
//        System.out.println(person);
        Person person = op.orElseGet(Person::new);
        System.out.println(person);


    }

    @Test
    public void test2() {
        Optional<Object> op = Optional.empty();
        System.out.println(op.get());
    }

    @Test
    public void test1() {
        Optional<Person> op = Optional.of(new Person());
        System.out.println(op.get());
    }

    @Test
    public void test5() {
        Man man = new Man();
        String n = getGodnessName(man);
        System.out.println(n);

        Optional<Godness> gn = Optional.ofNullable(null);
        Optional<NewMan> newMan = Optional.ofNullable(new NewMan(gn));
        String godnessName2 = getGodnessName2(newMan );
        System.out.println(godnessName2);

    }

    public String getGodnessName2(Optional<NewMan> man) {
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("canglaoshi"))
                .getName();
    }

    // 获取一个男人心中女神的名字
    public String getGodnessName(Man man) {
        if (man != null) {
            if (man.getGodness() != null) {
                return man.getGodness().getName();
            }
        }
        return "canglaoshi";
    }
}
