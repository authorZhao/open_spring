package com.qdz.proxy.asm;

/**
 * 自定义类加载器
 */
public class MyClassLoader extends ClassLoader {
    public MyClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
    }

    /**
     * 吧class数组转化为Class对象
     * @param name 类全名
     * @param data class数组
     * @return
     */
    public Class<?> defineClassForName(String name, byte[] data) {
        return this.defineClass(name, data, 0, data.length);
    }

}
