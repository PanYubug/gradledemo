package com.panyu.jase.java8.annotation;

import org.testng.annotations.Test;

import javax.annotation.Nonnull;
import java.lang.reflect.Method;

/**
 * 重复注解和类型注解
 */
public class TestAnnotation {

    private @Nonnull
    Object obj = null;

    @Test
    public void test1() throws Exception {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show");
        MyAnnotation[] mas = m1.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : mas) {
            System.out.println(myAnnotation.value());
        }
    }

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("abc") String str) {

    }
}
