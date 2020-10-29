package com.panyu.springdemo.soundsystem.jase;

class Teacher extends Object {
    private int age;
    private String name;
    Teacher(String name, int age){
        this.age = age;
        this.name = name;
    }

    //定义一个方法，判断两个对象是否是同一个，
    //判断依据是根据年龄，如果年龄相同，视为同一个人。

    //不用再定义方法，判断对象是否相同，因为Object类中，已经定义了这样的方法。
    //直接使用就可以了，但是判断的内容是不是根据Teacher的特点定义的
    //需要保留父类的功能声明，定义子类功能的特有内容

    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        //obj想要使用子类的特有功能，需要进行向下转型，进行类型判断
        if (!(obj instanceof Teacher)) {
            throw new ClassCastException("类型错误");
//            return false;
        }
        Teacher p = (Teacher) obj;

        //如果判断姓名字符串是否相同，不要用==，字符串本身就是一个对象
        return this.age == p.age && this.name.equals(p.name) ;
    }

    public String toString(){
        return this.name;
    }
}

class Demo {

}


public class ObjectDemo {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("李四", 22);
        Teacher t2 = new Teacher("李四", 22);
        Teacher t3 = t1;
        System.out.println(t1.equals(t2));
        System.out.println(t1 == t2);
        System.out.println(t3.equals(new Demo()));
    }


}
