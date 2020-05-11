package com.qdz.reflect;

import com.qdz.entity.User;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author authorZhao
 * @date 2020/1/9
 */
public class Test2 {

    @Test
    public void test1(){
        Constructor<?>[] constructors = User.class.getConstructors();
        System.out.println(constructors);

    }
}
