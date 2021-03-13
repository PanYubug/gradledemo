package com.panyu.dao;

import java.io.Serializable;


/**
 * Person类的对象如果需要序列化，就需要实现Serializable标记接口。
 * 该接口给需要序列化的类，提供了一个序列版本号，serialVerionUID
 * 该版本号的目的在于验证序列化对象和对应类是否版本匹配。
 */
public class Person implements Serializable {

    private static final long serialVerionUID = 12334L;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age, Double salary, Status status) {
        this.name = name;
        this.age = age;
        this.status = status;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                ", salary=" + salary +
                '}';
    }

    public String name;
    // 不序列化age
    private transient Integer age;

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Double salary;

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getAge() != person.getAge()) return false;
        return getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAge();
        return result;
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }
}
