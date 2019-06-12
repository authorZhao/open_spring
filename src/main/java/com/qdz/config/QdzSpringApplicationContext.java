package com.qdz.config;

import com.qdz.frameWork.annotation.QdzAutowired;
import com.qdz.frameWork.annotation.QdzController;
import com.qdz.frameWork.mapping.AnnotationConfiguration;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class QdzSpringApplicationContext {
    private static Map<String,Object> concurrentHashMap = new ConcurrentHashMap<>();
    private static List<Class<?>> basePackageMappingToClass  = new CopyOnWriteArrayList<>();

    /**
     * 根据对象实例别名获取实例
     * @param name
     */
    public static Object getBean(String name){
        return concurrentHashMap.get(name);
    }

    public static void main(String[] args) {
        QdzSpringApplicationContext applicationContext = new QdzSpringApplicationContext();
    }
    public static void run(Class<?> clazz,String[] args) {
        //1.获得QdzComponentScan，得到扫描的包名集合
        List<String> packageNames = AnnotationConfiguration.getPackageNames(clazz);
        basePackageMappingToClass = AnnotationConfiguration.getClasses(packageNames);
        concurrentHashMap = AnnotationConfiguration.getObjects(basePackageMappingToClass);
        //自动注入
        AnnotationConfiguration.AutoDi(basePackageMappingToClass,concurrentHashMap);
    }



}
