package com.panyu.springdemo.soundsystem;

//public class Student extends Person implements Comparable{
public class Student extends Person {
    private String name;
    private int age;

    public Student() {
        super();
    }

    public Student(String name, int age) {
        super();
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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getAge() != student.getAge()) return false;
        return getName().equals(student.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAge();
        return result;
    }

    //学生就具备了比较功能，该功能是自然排序使用的方法
    //自然排序就年龄的圣墟排序为主
//    @Override
//    public int compareTo(Object o) {
//        Student stu = (Student)o;
//        if (this.age>stu.age)
//                return 1;
//        if (this.age< stu.age)
//                return -1;
//        return 0;
}

//    @Override
//    public int hashCode() {
//        final int NUMBER = 37;
//        return this.name.hashCode()+this.age*NUMBER;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Student)) {
//            throw new ClassCastException("类型错误");
//        }
//        Student stu = (Student) obj;
//        return this.name.equals(stu.name) && this.age == stu.age;
//    }
