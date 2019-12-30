package com.git.array;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author authorZhao
 * @date 2019/12/16
 */
public class Test2 {

    @Test
    public void test1(){
        List<String> list = new LinkedList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add(null);
        list.add("asd=");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            iterator.remove();;
        }

        System.out.println(list);
    }


    @Test
    public void test2(){
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add(null);
        list.add("asd=");
        list.add(1,"哈哈");
        list.addFirst("阿萨德");
        list.addLast("安尔碘群无");
        list.remove();
        list.remove(2);
        System.out.println(list);

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println("当前删除的东西是:"+next);
            iterator.remove();

        }

    }
}
