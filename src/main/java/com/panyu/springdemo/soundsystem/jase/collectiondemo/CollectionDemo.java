package com.panyu.springdemo.soundsystem.jase.collectiondemo;

import java.util.ArrayList;
import java.util.Collection;

/*
* 1、增加
* 2、删除
* 3、获取长度
* 4、判断
* 5、将集合转成数组
* 6、取出集合元素
*   Iterator iterator()
*   获取集合中元素上迭代功能的迭代器对象
*   迭代：取出元素的一种方式。有没有啊？有，取一个，还有没有，有，取一个，还有没有？没有，算了
*   迭代器：具备着迭代功能的对象
*   而迭代器对象不需要new，直接通过iterator()方法获取即可
*
*
*
*
*
*
* */

public class CollectionDemo {
    public static void main(String[] args) {
        Collection col = new ArrayList();
//        methodDemo(col);
        methodAllDemo();
    }

    public static void methodAllDemo() {

        //1、创建集合
        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();
        //2、添加元素
        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");
        c1.add("abc4");

        c2.add("abc2");
        c2.add("abc3");
        c2.add("abc4");
        c2.add("abc5");
        //3、c1中添加c2
        System.out.println(c1.addAll(c2));
        System.out.println(c1);

        //4、判断c1中包含c2的所有元素
        boolean b = c1.contains(c2);
        System.out.println(b);

        //5、从c1中删除c2
//        c1.removeAll(c2);//将c1中和c2相同的元素删除
//        System.out.println(c1);

        //6、保留c1中和c2相同的元素，和remove相反，将不同的元素从c1中删除
        c1.retainAll(c2);
        System.out.println(c1);

    }

    public static void methodDemo(Collection coll) {

        //1、添加元素
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        System.out.println(coll.size());

        //2、移除元素
        coll.remove("abc2");
        System.out.println(coll.size());
        System.out.println(coll);
        //1，2会改变集合的长度

        System.out.println(coll.contains("abc1"));

        //3、清楚元素
        coll.clear();
        System.out.println(coll);

    }

}
