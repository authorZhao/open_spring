package com.qdz.config;

import com.qdz.frameWork.mapping.AnnotationConfiguration;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class QdzSpringApplicationContext {
    //线程安全的map和list
    private static Map<String,Object> concurrentHashMap = new ConcurrentHashMap<>();
    private static List<Class<?>> basePackageMappingToClass  = new CopyOnWriteArrayList<>();

    /**
     * 根据对象实例别名获取实例
     * @param name
     */
    public static Object getBean(String name){
        return concurrentHashMap.get(name);
    }

    public static Object getBean(Class clazz){

        /*concurrentHashMap.entrySet().stream().filter(m->{
            m.getValue().getClass().equals()

        })*/
                return null;
    }



    public static void run(Class<?> clazz,String[] args) {
        //1.获得QdzComponentScan，得到扫描的包名集合
        List<String> packageNames = AnnotationConfiguration.getPackageNames(clazz);
        //2.包名集合获得Class对象集合
        basePackageMappingToClass = AnnotationConfiguration.getClasses(packageNames);
        //3.对象实例化
        concurrentHashMap = AnnotationConfiguration.getObjects(basePackageMappingToClass);
        //4.自动注入
        AnnotationConfiguration.AutoDi(basePackageMappingToClass,concurrentHashMap);
    }

}
