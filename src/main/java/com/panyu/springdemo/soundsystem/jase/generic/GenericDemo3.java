package com.panyu.springdemo.soundsystem.jase.generic;


import com.panyu.demo.soundsystem.Student;

public class GenericDemo3 {
    public static void main(String[] args) {
//        Tool tool = new Tool();
//        tool.setObj(new Student());
//        Student stu = (Student) tool.getObj();
//        tool.setObj(new Worker());

        UtilTool<Student> util = new UtilTool<Student>();

        util.setObj(new Student());
        Student stu = util.getObj();//避免了向下转型
        System.out.println(stu);





    }
}

/*
* 创建一个用于操作Student对象的工具类。对 对象进行设置和获取。
* 太有局限性了，可不可以定义一个可以操作所有对象的工具呢？
* 类型向上抽取 当腰操作的对象类型不确定的时候，为了扩展。
* 可以使用Object类型来完成。
* 但是这种方式有一些小弊端：会出现转型，尤其是向下转型容易在运行时期发生ClassCastException
*
*
* jdk1.5以后，新的解决方案
* 类型不确定时，可以对外提供参数，由使用者通过传递参数的形式完成类型的确定
*
* */


//在类定义时，就明确参数，由使用该该类的调用者来传递具体的类型
//泛型类
class UtilTool<W>{

    private W obj;

    public W getObj() {
        return obj;
    }

    public void setObj(W obj) {
        this.obj = obj;
    }
}

//class Tool{
//    private Student stu;
//
//    public Student getStu() {
//        return stu;
//    }
//
//    public void setStu(Student stu) {
//        this.stu = stu;
//    }
//}


//class Tool{
//    private Object obj;
//
//    public Object getObj() {
//        return obj;
//    }
//
//    public void setObj(Object obj) {
//        this.obj = obj;
//    }
//}