package com.panyu.springdemo.soundsystem.jase;


// 父类、超类、基类
class Person {
    private int age;
    private String name;

    Person(String name, int age) {
        if (age < 0) {
            return;
        }
        this.age = age;
        this.name = name;
    }

    void setAge(int a) {
        if (a < 1 || a > 130) {
            System.out.println(a + "数值是错误的");
            throw new RuntimeException(a + ", 数值是错误的");
        } else {
            age = a;
        }
    }

    int getAge() {
        return this.age;
    }

    String getName(){
        return this.name;
    }

    void speak() {
        System.out.println("age:" + age);
    }

    void show() {
        System.out.println("name:" + name + ",age:" + age);
    }

    public static void sleep(){
        System.out.println("睡觉");
    }

    public boolean equalsAge(Person pp) {
        return pp.age == this.age;
    }


}


class Student extends Person
{
    Student(String name, int age) {
        super(name, age);
    }

    void study(){
        System.out.println("学习！");
    }
}

class Worker extends Person
{

    Worker(String name, int age) {
        super(name, age);
    }

    void work(){
        System.out.println("工作。。");
    }
}

class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person("xiaoqiang", 18);
        p.show();
        Person.sleep();
        Person p2 = new Person("lisi", 21);
        p.equalsAge(p2);

//        p2.show();

    }
}

/*
* 继承：
* 1、提高了代码的复用性
* 2、让类与类之间产生了关系， 为第三个特征多态提供了前提
*
* Java支持单继承，不直接支持多继承。
*
*
* */
class ExtendsDemo {
    public static void main(String[] args) {
        Student stu = new Student("张三", 22);
        stu.study();
        Student.sleep();
        int stu_age = stu.getAge();
        System.out.println(stu_age);
        String stu_name = stu.getName();
        System.out.println(stu_name);

    }
}