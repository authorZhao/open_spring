package com.qdz.proxy.s;

public interface HelloWorld {

    void sayHello();
    default void sayHello(String str){
        System.out.println("我系"+str);
    }
}
