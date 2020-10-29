package com.panyu.springdemo.soundsystem.jase.collectiondemo;


import com.panyu.demo.soundsystem.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {
    public static void main(String[] args) {
        Map<Employee, String> map = new HashMap<Employee, String>();

        //2、按照学生的年龄进行升序排序并取出，按照学生的姓名升序排序

        map.put(new Employee("xiaozhang", 33), "北京");
        map.put(new Employee("laoli", 23), "上海");
        map.put(new Employee("mingming", 26), "南京");
        map.put(new Employee("xili", 24), "广州");
        map.put(new Employee("laoli", 24), "铁岭");


        for (Employee employee : map.keySet()) {
            String value = map.get(employee);
            System.out.println(employee.getName()+":"+employee.getAge()+"..."+value);
        }

        //entrySet
        Set<Map.Entry<Employee,String>> entrySet = map.entrySet();
        for (Map.Entry<Employee, String> me : entrySet) {
            Employee key = me.getKey();
            String value = me.getValue();
            System.out.println(key.getName()+"::"+key.getAge()+"...");
        }

    }
}
