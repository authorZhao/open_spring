package com.qdz.proxy.asm;

import com.qdz.frameWork.annotation.QdzController;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author authorZhao
 * @date 2020年05月09日
 */
public class AsmAnnotationUtil<T extends Annotation> {
    private static Map<String,Object> map = new HashMap<>();

    public static<T> void setValue(T t,String methodName,Object value){
        Class<?> aClass = t.getClass();

        Arrays.stream(aClass.getDeclaredMethods()).forEach(i->{
            if(i.getName().equals(methodName)){
                    map.put(aClass.getName()+"#"+methodName,value);
            }
        });
    }

    public Object getValue(T t,String methodName){
        Class<?> aClass = t.getClass();
        if(map.containsKey(methodName)){
            return map.get(aClass.getName()+"#"+methodName);
        }else{
            Arrays.stream(t.getClass().getDeclaredMethods()).forEach(i->{
                if(i.getName().equals(methodName)){
                    try {
                        map.put(aClass.getName()+"#"+methodName,i.invoke(t,methodName));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return map.get(aClass.getName()+"#"+methodName);

    }



    /*1 = {Method@851} "public abstract boolean java.lang.annotation.Annotation.equals(java.lang.Object)"
            2 = {Method@852} "public abstract java.lang.String java.lang.annotation.Annotation.toString()"
            3 = {Method@853} "public abstract int java.lang.annotation.Annotation.hashCode()"
            4 = {Method@854} "public abstract java.lang.Class java.lang.annotation.Annotation.annotationType()"*/


    public static void main(String[] args) {
        Class<QdzController> qdzControllerClass = QdzController.class;
        qdzControllerClass.getMethods();
        System.out.println(qdzControllerClass);

    }
}


