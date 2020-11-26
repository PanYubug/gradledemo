package com.panyu.annotation;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyTestAnnotation(getName = "class", getValue = "Annotation")
public class AnnotationDemo {

    @MyTestAnnotation(getName = "parameter", getValue = "demoParameter")
    private String demoParameter;

    @MyTestAnnotation(getName = "method", getValue = "hello")
    public void hello() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        /**
         * 获取类注解属性
         */
        Class<AnnotationDemo> annotationDemoClass = AnnotationDemo.class;
        if (annotationDemoClass.isAnnotationPresent(MyTestAnnotation.class)) {
            MyTestAnnotation annotation = annotationDemoClass.getAnnotation(MyTestAnnotation.class);
            System.out.println("\"类\"上的注解值获取到第一个 ："
                    + annotation.getName() + "，第二个：" + annotation.getValue());
        }

        /**
         * 获取属性、方法的注解属性
         */
        try {
            Field demoParameterField = annotationDemoClass.getDeclaredField("demoParameter");
            if (demoParameterField.isAnnotationPresent(MyTestAnnotation.class)) {
                MyTestAnnotation annotation = demoParameterField.getAnnotation(MyTestAnnotation.class);
                System.out.println("\"属性\"上的注解值获取到第一个 ："
                        + annotation.getName() + "，第二个：" + annotation.getValue());
            }

            Method helloMethod = annotationDemoClass.getDeclaredMethod("hello");
            if (helloMethod != null && helloMethod.isAnnotationPresent(MyTestAnnotation.class)) {
                MyTestAnnotation annotation2 = helloMethod.getAnnotation(MyTestAnnotation.class);
                System.out.println("\"方法\"上的注解值获取到第一个 ："
                        + annotation2.getName() + "，第二个：" + annotation2.getValue());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}