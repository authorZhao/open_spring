package com.qdz.base.class_test;

import com.qdz.frameWork.util.MyArrayList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArray {

    @Test
    public void test1(){
        Object[] objects = new Object[10];
        objects[0] = null;
        objects[1] = null;
        objects[2] = null;
        objects[3] = null;
        System.out.println(objects.length);
        Arrays.stream(objects).forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("ads");
        list.add(2,"哈哈");
        list.add(null);
        list.add(null);
        System.out.println(list);
    }


    @Test
    public void test3(){
        MyArrayList<String> list = new MyArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("ads");
        list.remove(1);
        System.out.println(list);
    }

}
