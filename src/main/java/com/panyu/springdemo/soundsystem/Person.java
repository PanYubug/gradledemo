package com.panyu.springdemo.soundsystem;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person() {
        System.out.println("Person run");
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        return result;
    }

    @Override
    public String toString() {

        return "[" + this.name + "," + this.age + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (!(obj instanceof Person)) {
            throw new ClassCastException("类型错误");
        }
        Person p = (Person) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {

        int temp = this.age -o.age;

        return temp==0?this.name.compareTo(o.name):temp;
    }

}
