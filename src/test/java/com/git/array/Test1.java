package com.git.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test1 {
    @Test
    public void test1(){
        MyArrayList<String> list = new MyArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("ads");
        list.add("asdf");
        list.add("asdf");
        list.add("gras");
        list.add("asfd");
        list.add("asdf");
        list.add("asfd");
        list.add("asfasdf");
        list.add("ads");
        System.out.println(list.size());
        Assert.assertSame("张三",list.get(0));
        Assert.assertSame("李四",list.get(1));
        Assert.assertSame("王五",list.get(2));
        Assert.assertEquals("溜溜",list.get(3));
        Assert.assertEquals("七七",list.get(4));
        Assert.assertEquals("八八",list.get(5));
        Assert.assertEquals("九九",list.get(6));
        Assert.assertEquals("试试",list.get(7));
        Assert.assertEquals("事宜",list.get(8));
        Assert.assertEquals("十二",list.get(9));
        Assert.assertEquals("十三",list.get(10));
        Assert.assertEquals("十四",list.get(11));
        list.stream().forEach(System.out::print);
        //结果
        //12
        //张三李四王五溜溜七七八八九九试试事宜十二十三十四

    }

    @Test
    public void test2(){
        MyArrayList<String> list = new MyArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("ads");
        list.add("asdf");
        list.add("asdf");
        list.add("gras");
        list.add("asfd");
        list.add("asdf");
        list.add("asfd");
        list.add("asfasdf");
        list.add("ads");
        System.out.println(list.size());
        list.stream().forEach(System.out::print);
        System.out.println(list.indexOf("李四"));
        list.remove(1);
        System.out.println(list.indexOf("李四"));
        System.out.println(list.size());
        list.stream().forEach(System.out::print);
        //结果
        //12
        //张三李四王五溜溜七七八八九九试试事宜十二十三十四1
        //-1
        //11
        //张三王五溜溜七七八八九九试试事宜十二十三十四

    }

    @Test
    public void test3(){
        MyArrayList<String> list = new MyArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("ads");
        list.add("asdf");
        list.add("asdf");
        list.add("gras");
        list.add("asfd");
        list.add("asdf");
        list.add("asfd");
        list.add("asfasdf");
        list.add("ads");
        System.out.println(list.size());
        list.stream().forEach(System.out::print);
        list.add(2,"十八");
        System.out.println(list.size());
        list.stream().forEach(System.out::print);
        //结果
        //12
        //张三李四王五溜溜七七八八九九试试事宜十二十三十四13
        //张三李四十八王五溜溜七七八八九九试试事宜十二十三十四

    }

    @Test
    public void test4(){
        MyArrayList<String> list = new MyArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("七七");
        list.add("八八");
        list.add("九九");
        list.add("诸葛狗蛋");
        list.add("慕容铁锤");
        list.add("史珍香");
        list.add("上官翠花");
        list.add("渣渣辉");
        list.add("古田乐");
        System.out.println(list.size());
        list.stream().forEach(System.out::print);
        list.add(2,"十八");
        System.out.println(list.size());
        list.stream().forEach(System.out::print);
        //结果
        //12
        //张三李四王五溜溜七七八八九九试试事宜十二十三十四13
        //张三李四十八王五溜溜七七八八九九试试事宜十二十三十四

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            //String name = iterator.next();
            //if(name.equals("李四"))iterator.remove();
            String name = iterator.next();
            iterator.remove();
        }
        System.out.println("\r\n");
        System.out.println(list.size());
        System.out.println("\r\n");
        list.stream().forEach(System.out::print);
    }

    @Test
    public void test5(){
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("七七");
        list.add("八八");
        list.add("九九");
        list.add("诸葛狗蛋");
        list.add("慕容铁锤");
        list.add("史珍香");
        list.add("上官翠花");
        list.add("渣渣辉");
        list.add("古田乐");
        System.out.println(list.size());
        list.stream().forEach(System.out::print);
        list.add(2,"十八");
        System.out.println(list.size());
        list.stream().forEach(System.out::print);
        //结果
        //12
        //张三李四王五溜溜七七八八九九试试事宜十二十三十四13
        //张三李四十八王五溜溜七七八八九九试试事宜十二十三十四

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
           // String name = iterator.next();
                iterator.remove();
        }
        System.out.println("\r\n");
        System.out.println(list.size());
        System.out.println("\r\n");
        list.stream().forEach(System.out::print);
    }

}
