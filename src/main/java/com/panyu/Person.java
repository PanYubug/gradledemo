package com.panyu;

import java.io.Serializable;


/**
 * Person类的对象如果需要徐硫化，就需要实现Serializable标记接口。
 * 该接口给需要序列化的类，提供了一个序列版本号，serialVerionUID
 * 该版本号的目的在于验证序列化对象和对应类是否版本匹配。
 */
public class Person implements Serializable {

    private static final long serialVerionUID = 12334L;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    // 不序列化age
    private transient int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



}
