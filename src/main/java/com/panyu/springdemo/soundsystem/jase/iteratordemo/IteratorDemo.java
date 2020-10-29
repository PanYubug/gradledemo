package com.panyu.springdemo.soundsystem.jase.iteratordemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
* 迭代器是取出Collection结合中元素的公共方式
*
* Collection
*   List：有序，（存入的顺序和取出的顺序一致）。有索引，允许重复元素
*   Set：不允许重复元素
*
*
*       List接口中的特有方法：他的特有方法都是围绕索引定义的
*
*
*       List集合具体子类      子类之所以区分是因为内部的数据结构（存储数据的方式）不同
*           Vector      数据结构是数组。数组是可变长度（不断new新数组并将原数组元素复制到新数组）线程同步的。都慢
*           ArrayList   数据结构是数组。也是长度可变的，线程不同步的，替代了Vector，增删的速度不快，查询快
*           LinkedList  链表结构，线程不同步。增删的速度快，查询慢
*
*
*       LinkedList:
*
*   Set集合：不允许重复。和Collection的方法相同。set集合取出方法只有一个：迭代器
*           不保证顺序
*
*      HashSet: 哈希表结构
*               不允许存储重复元素，因为会发生查找的不确定性
*               不保证存入和取出的顺序的一致
*               比数组的查询效率高
*               为何保证唯一性
*               元素必须覆盖hashCode和equals方法
*               覆盖hashCode方法时为了根据元素自身的特点确定哈希值
*               覆盖equals方法，是为了解决哈希值的冲突。
*
*      LinkedHashSet: 基于哈希表，加入了链表，
*
*      TreeSet: 二叉树数据结构，可以对元素进行排序，不同步的。
*               如何保证元素唯一性
*                   参考的就是比较方法的返回值是否是0，是，就是重复元素
*               排序方式：需要元素具备比较功能。所以元素需要实现Comparable接口
*                       覆盖Comparable方法。
*
*               需求中也有这样一种情况，元素具备的比较功能不是所需要的，也就是说不想按照自然排序的方法，
*               而是按照自定义的排序方式，对元素进行排序。
*               而且，存储到TreeSet中的元素万一没有比较功能，该如何排序呢？
*               这时，就只能使用第二种比较方式：是让集合具备比较功能。
*
*               实现Comparator接口，覆盖Compara方法。将Comparator接口的对象，
*               作为参数传递给TreeSet集合的构造函数
*
*               比较器更为灵活，自然排序通常作为元素的默认排序
*
* 技巧：
* jdk1.2以后出现的集合框架中的常用子类对象，存在规律
* 前缀名是数据结构名，后缀名是所属体系名。
* ArrayList     数组结构。看到数组，就知道查询快，看到list，就知道可以重复，可以增删改查
* LinkedList    链表结构，增删快，xxxFirst xxxLast xxx: add, get, remove
* HashSet       哈希表，就要想到元素必须覆盖hashcode和equals。 查询速度更快，不保证有序，看到set，就知道不可以重复
* LinkedHashSet 链表+哈希表，可以实现有序，因为有链表，但保证唯一，
* TreeSet       二叉树，可以自然排序，就要想到，两种比较方式，一种是自然排序Comparable，一种是比较器Comparator
*
*
*
*
*
*
* */


public class IteratorDemo {
    public static void main(String[] args) {
//        Collection coll = new ArrayList();
//        coll.add("abcd1");
//        coll.add("abcd2");
//        coll.add("abcd3");
//        coll.add("abcd4");

//        Iterator it = coll.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//
//        }
//        for(Iterator it=coll.iterator();it.hasNext();){
//            System.out.println(it.next());
//        }
//        System.out.println(coll);

        List list = new ArrayList();
        list.add("abcde1");
        list.add("abcde2");
        list.add("abcde3");
        list.add("abcde4");

//        for (Iterator it = list.iterator(); it.hasNext(); ) {
//                Object obj = it.next();
//                if (obj.equals("abcde2")){
//                    list.add("haha");
//                }
//        }

        //使用list集合的特有的迭代器。ListIterator  通过List集合的方法listIterator()获取该迭代器对象
        //ListIterator可以实现在迭代过程中的增删改查
        for (ListIterator it = list.listIterator(); it.hasNext(); ) {
            Object obj = it.next();
            if (obj.equals("abcde2")){
                it.add("haha");
            }

        }
        System.out.println(list);

//        methodDemoList(list);
    }

    public static void methodDemoList(List list){
        list.add("abcde1");
        list.add("abcde2");
        list.add("abcde3");

        //2、插入元素
        list.add(1,"hehe");
        System.out.println(list);
        //3、删除
        list.remove(1);
        //4、获取
        System.out.println(list.get(1));
        System.out.println(list.indexOf("abcde3"));
        //5、修改
        list.set(1,"bb");

        System.out.println(list);
        //取出集合中所有的元素
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            System.out.println(it.next());

        }
        //list集合特有的取出方式
        for (int i = 0; i < list.size(); i++) {
            System.out.println("get:"+list.get(i));
        }

    }
}
