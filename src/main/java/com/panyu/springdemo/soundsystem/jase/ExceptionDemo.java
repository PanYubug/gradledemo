package com.panyu.springdemo.soundsystem.jase;


/*
 * 异常
 *   java程序在运行 时期发送的不正常情况
 *   java就按照面向对象的思想对不正常情况进行描述和对象的封装
 *
 *   问题分为两种：
 *   Throwable：定义了对于问题的共性功能
 *       Error：由系统底层发生的，告诉jvm，jvm告诉使用者，不做针对性的处理，修改代码。
 *       Exception：jvm发生，告诉使用者，可以针对性的处理
 *
 * 异常的处理
 *   1、遇到问题不进行具体的处理，而是继续抛给使用者
 *       其实就是在函数上通过throws关键字声明异常，告诉使用者管理
 *   2、针对性的处理方式：捕获异常
 *       try{
 *           //有可能发生异常的代码
 *       }catch(异常类 变量){
 *           //这时真正的捕获
 *       }finally{
 *           //一定会被执行的代码
 *       }
 *
 * throw和throws有什么区别
 *
 * 1、位置不同，
 *   throws用在函数上，后面跟的是异常类，可以跟多个
 *   throw用在函数内，后面跟的是异常对象，一个对象
 *
 * 2、功能不同，
 *   throws用来声明异常，让调用者知道该功能有可能出现的问题，并由调用者可以给出预先处理的方式
 *   throw抛出具体问题对象，执行到throw功能就已经结束了，跳转到调用者，并将具体的问题对象，抛给调用者。
 *
 *   也就是说throw语句独立存在时，下面不要定义其他语句，因为执行不到。
 *
 *
 * 异常体系的特殊情况：
 *   Error：
 *   Exception：
 *   异常体系最大的特点就是体系中的类以及类产生的对象，都具备这可抛性，可抛性是指，可以被throws和throw可操作的。
 *
 *
 *
 *   异常的原则：
 *       1、功能内部有异常throw抛出，功能上一定要throws声明
 *           内部抛出什么，就声明什么
 *           声明的目的就是让调用者处理，如果调用者不处理，编译失败。
 *
 *       2、特殊情况：
 *           当函数内出现throw抛出runtimeException及其子类对象，函数上可以不用throws声明。
 *           不声明的目的就是不让调用者处理，让调用者的程序停止，要对代码进行修改。
 *
 *
 *   Exception分两种：
 *      1、编译时会被检测的异常
 *      2、运行时异常（编译时不检测）RuntimeException
 *
 *
 * 自定义异常：
 *      在自定义的程序中，如果有了问题，也可以像java中的异常一样，
 *      对问题进行描述
 *
 *      举例：
 *          定义一个功能可以实现除法运算，但是除数不可以为零和负数。
 *
 *
 *  小节：
 *      异常：其实就将问题封装成对象，并抛给调用者。
 *      如果声明了，就需要调用者处理（继续声明或捕获）
 *      什么时候声明，什么时候捕获？
 *          功能内部可以解决，就捕获，不能解决，或者解决了还必须告诉调用者问题这时就应该声明。
 *
 *  举例：
 *  老师上课用电脑
 *
 *
 * finally作用是：无论是否有异常发生，都要对资源进行释放。
 * 资源释放的动作定义在finally代码块中。
 *
 *
 * try
 * catch
 * finally
 * 的几种组合方式
 * 1、
 * try{}catch(){}
 * 2、分别处理
 * try{}catch(){}catch(){}
 *  特殊情况，多catch中出现子父类的情况，父类一定要放在下面，否则编译失败
 *
 * 3、不一定要处理异常，但是要释放资源
 * try{}catch(){ throw e}finally{}
 *
 * 4、try{}catch(){}finally{}
 * */


class Fu1{
     void show(){
         System.out.println("fu show");
     }
}

class Zi1 extends Fu1{
    void show(){
        System.out.println("zi show");
    }

}

class Tool{
    void method(Fu1 f){
        f.show();
    }
}


//是可以处理的，继承Exception
class LanpingException extends Exception {
    LanpingException() {
        super();
    }

    LanpingException(String message) {
        super(message);
    }
}

class MaoYanException extends Exception {
    MaoYanException() {
        super();
    }

    MaoYanException(String message) {
        super(message);
    }
}


class Computer {
    private int state = 0;
    private Computer comp;


    void run() throws LanpingException, MaoYanException {
        if (state == 1) {
            throw new LanpingException("蓝屏了");
        }
        if (state == 2) {
            throw new MaoYanException("冒烟了");
        }
        System.out.println("电脑运行");

    }

    void reset() {
        System.out.println("重启");
    }
}

class EnglishTeacher {
    private String name;
    private Computer comp;

    EnglishTeacher(String name) {
        this.name = name;
        comp = new Computer();
    }

    public void prelect() throws MaoYanException{
        try {
            comp.run();
        } catch (LanpingException e) {
            System.out.println(e.toString());
            comp.reset();
            //重新讲课
            prelect();
            System.out.println("讲课");
        } catch (MaoYanException e) {
            test();
            throw e;//继续抛
        }


    }

    public void test() {
        System.out.println("练习");
    }
}


class DivException extends RuntimeException {

    DivException() {
        super();
    }

    DivException(String s) {
        super(s);
    }
}


class Demo10 {
    int div(int a, int b) {

        if (b < 0) {
            throw new DivException("除数小于0了");
        }

        if (b == 0) {
            throw new ArithmeticException("除零了");
        }
        return a / b;
    }
}


public class ExceptionDemo {
    public static void main(String[] args) {

//        Demo10 d = new Demo10();
//        try {
//            int num = d.div(4, -1);
//            System.out.println(num);
//        } catch (Exception e) {
//            System.out.println(e);
//            System.out.println(e.getClass());
//            System.out.println(e.toString());
//
//        } finally {
//            System.out.println("over");
//            int[] arr = new int[3];
//            int element = getElement(arr, -2);
//            System.out.println(element);
//        }


//        EnglishTeacher t = new EnglishTeacher("毕老师");
//        try {
//            t.prelect();
//        }catch (MaoYanException e){
//            System.out.println("换老师");
//            //不执行finally
//            System.exit(0);
//
//        }finally {
//            System.out.println("必须执行");
//
//        }

        Tool t = new Tool();
        t.method(new Fu1());
        t.method(new Zi1());




    }

    public static int getElement(int[] arr, int index) {

        if (arr != null) {
            throw new NullPointerException("数组实体不存在");
        }
        if (index < 0 || index >= arr.length) {
            System.out.println("角标不存在");
            throw new ArrayIndexOutOfBoundsException(index + "角标不存在");
        }
        int element1 = arr[index];
        return element1;
    }
}
