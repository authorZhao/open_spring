package com.qdz.proxy.s;

public class HelloWorld3 implements HelloWorld {
 /*   HelloWorld helloWorld;
    public HelloWorld3(HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }*/
    @Override
    public void sayHello() {
        System.out.println("我是helloWorld3的");
       // helloWorld.sayHello();
    }


    /*public static void main(String[] args) {
       new HelloWorld3(new HelloWorld1()).sayHello();
    }*/
}
