package com.qdz.proxy.lambada;

import java.util.ArrayList;
import java.util.List;

/**
 * @author authorZhao
 * @date 2019/12/30
 */
public class Test1 {



    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        //list.forEach(s->System.out.println(s));
        System.out.println("=================分隔符=============");
        list.forEach(System.out::println);
    }

    //public static void lambda$main$0(String s){};
}
