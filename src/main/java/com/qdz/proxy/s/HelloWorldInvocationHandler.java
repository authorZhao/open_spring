package com.qdz.proxy.s;

import org.apache.commons.io.FileUtils;
//import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloWorldInvocationHandler implements InvocationHandler {

    Object object;
    public HelloWorldInvocationHandler(Object object){
        this.object=object;
    }
    public HelloWorldInvocationHandler(){
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // object的公用方法直接调用当前invoke对象的。
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
            // 针对接口的不同方法书写我们具体的实现
        } else if ("sayHello".equals(method.getName())) {
            System.out.println("我是动态代理类的"+args[0].toString());
            return null;
        }
        return null;
    }

    public static void main1(String[] args) {
       HelloWorld helloWorld = () -> {
           System.out.println("我bu是动态代理类的");
           return;
       };
        HelloWorldInvocationHandler invocationHandler = new HelloWorldInvocationHandler(helloWorld);
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(), helloWorld.getClass().getInterfaces(), invocationHandler);
        proxy.sayHello("渣渣辉");
        /*HelloWorld helloWorld = new HelloWorld3();
        HelloWorldInvocationHandler helloWorldInvocationHandler = new HelloWorldInvocationHandler(helloWorld);*/

    }
    /*static byte[] generateProxyClass(final String name,
                                     Class<?>[] interfaces,
                                     int accessFlags);*/
    public static void main(String[] args) {
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(HelloWorld.class.getClassLoader(), new Class[]{HelloWorld.class}, new HelloWorldInvocationHandler());
        proxy.sayHello("渣渣辉");
        //java.lang.reflect.ProxyGenerator.gen
        //byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", HelloWorld.class.getInterfaces());
        try {
            FileUtils.writeByteArrayToFile(new File("E:\\idea\\workpace\\space6\\open_spring\\a.class"),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*HelloWorld helloWorld = new HelloWorld3();
        HelloWorldInvocationHandler helloWorldInvocationHandler = new HelloWorldInvocationHandler(helloWorld);*/

    }
}
