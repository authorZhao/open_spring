package com.qdz.proxy.anno;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author authorZhao
 * @date 2019/12/31
 */
public class Test1 {

    @Test
    public void test1() {
        Field[] declaredFields = Person.class.getDeclaredFields();
        Arrays.stream(declaredFields).map(Field::getName).forEach(System.out::println);
        System.out.println("===========================分割线=======================");
        Method[] declaredMethods = Person.class.getDeclaredMethods();
        Arrays.stream(declaredMethods).map(Method::getName).forEach(System.out::println);
    }

    @Test
    public void test2() {
        Field[] declaredFields = Child.class.getDeclaredFields();
        Arrays.stream(declaredFields).map(Field::getName).forEach(System.out::println);
        System.out.println("===========================分割线=======================");
        Method[] declaredMethods = Child.class.getDeclaredMethods();
        Arrays.stream(declaredMethods).map(Method::getName).forEach(System.out::println);
    }
}
