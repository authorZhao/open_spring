package com.qdz.frameWork.mapping;


import com.qdz.frameWork.annotation.QdzAutowired;
import com.qdz.frameWork.annotation.QdzComponentScan;
import com.qdz.frameWork.annotation.QdzController;
import com.qdz.frameWork.annotation.QdzService;
import com.qdz.frameWork.exception.AnnotationNotExistException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class AnnotationConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(AnnotationConfiguration.class);
    private static final List<Class<? extends Annotation>> lists = new ArrayList<>();
    static {
        lists.add(QdzController.class);
        lists.add(QdzService.class);
    }

    /**
     * 获得扫描的包名集合
     * @param clazz 启动类的Class对象
     * @return 所需扫描的包名集合
     */
    public static List<String> getPackageNames(Class<?> clazz) {
        List<String> propertyList = new CopyOnWriteArrayList<>();
        if(!clazz.isAnnotationPresent(QdzComponentScan.class))throw new AnnotationNotExistException(clazz.getName() +"类的QdzComponentScan注解不存在");
        QdzComponentScan qdzComponentScan = clazz.getAnnotation(QdzComponentScan.class);
        String[] annoScans = qdzComponentScan.value();
        if(annoScans==null||annoScans.length<=0)throw new AnnotationNotExistException(clazz.getName() +"类的QdzComponentScan注解不存在");
        for (String s:annoScans) {propertyList.add(s);}
        logger.info("扫描解析完毕");
        return propertyList;
    }

    /**
     * 根据扫描的包名集合获得Class对象集合
     * @param packageNames 包名集合
     * @return Class对象集合
     */
    public static List<Class<?>> getClasses(List<String> packageNames){
        logger.info("正在获取Class对象");
        List<Class<?>> classList = new CopyOnWriteArrayList<>();
        packageNames.stream().forEach(o->{
            String path  = o.replace(".","/");
            URL url = AnnotationConfiguration.class.getClassLoader().getResource(path);
            if(url!=null){
                File file =new File(url.getPath());
                setClassList(classList,file,o);
            }else{
                Class<?> clazz = null;
                try {
                    clazz = Class.forName(o);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                classList.add(clazz);
            }
        });
        if(classList==null||classList.size()<=0)throw new AnnotationNotExistException("扫描的包不存在");
        logger.info("扫描完毕");
        return classList.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 实例化对象
     * @param classList
     * @param file
     * @param packageName
     */
    private static void setClassList(List<Class<?>> classList, File file,String packageName) {
        if(file.isDirectory()){
            for (File f:file.listFiles()) {
                setClassList(classList,f,packageName+"."+f.getName());
            }
        }else{
            Class<?> clazz = null;
            try {
                if(packageName.endsWith(".class")) {
                    clazz = Class.forName(packageName.substring(0, packageName.lastIndexOf(".")));
                    classList.add(clazz);
                }else {
                    String path = file.getName();
                    String pathName = packageName + "." + path.substring(0, path.lastIndexOf("."));
                    clazz = Class.forName(pathName);
                    classList.add(clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Class对象实例化
     * @param classList
     * @return map
     */
    public static Map<String,Object> getObjects(List<Class<?>> classList){
        Map<String,Object> concurrentHashMap = new ConcurrentHashMap<>();
        classList.stream().forEach(o->{
            setConcurrentHashMap(concurrentHashMap,o);
        });
        return concurrentHashMap;
    }

    /**
     *
     * @param concurrentHashMap 线程安全的map
     * @param clazz Class对象
     */
    private static void setConcurrentHashMap(Map<String, Object> concurrentHashMap, Class<?> clazz) {
        lists.stream().forEach(o->{
            Object obj = null;
            String name = "";
            //判断有没有注解
            if(clazz.isAnnotationPresent(o)){
                Object annoObj = clazz.getAnnotation(o);
                try {
                    Method method = o.getMethod("value");
                    obj = clazz.getDeclaredConstructor().newInstance();
                    name = (String)method.invoke(annoObj);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                if(StringUtils.isBlank(name)){
                    String key = clazz.getName().substring(clazz.getName().lastIndexOf(".")+1);
                    name = (new StringBuilder()).append(Character.toLowerCase(key.charAt(0))).append(key.substring(1)).toString();
                    logger.info("key==  "+name);
                }
                if(obj!=null)concurrentHashMap.put(name,obj);
                logger.info(clazz.getName()+"装配完毕");
            }
        });

    }

    /**
     * 自动注入
     * @param basePackageMappingToClass
     * @param concurrentHashMap
     */
    public static void AutoDi(List<Class<?>> basePackageMappingToClass, Map<String, Object> concurrentHashMap) {
        if(concurrentHashMap.isEmpty())return;
        for (Map.Entry<String,Object> entry:concurrentHashMap.entrySet()) {
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field f:fields ) {
                if(!f.isAnnotationPresent(QdzAutowired.class))continue;
                QdzAutowired qdzAutowired = f.getAnnotation(QdzAutowired.class);
                String beanName = qdzAutowired.value();
                if(StringUtils.isBlank(beanName)){
                    String key = f.getType().getName().substring(f.getType().getName().lastIndexOf(".")+1);
                    beanName = (new StringBuilder()).append(Character.toLowerCase(key.charAt(0))).append(key.substring(1)).toString();
                }
                if(!f.canAccess(entry.getValue())){
                    f.setAccessible(true);
                }
                try {
                    Object obj1 = entry.getValue();
                    Object obj2 = concurrentHashMap.get(beanName);
                    /*if(obj2==null){//根据名称找不到，直接在根据类型找
                        obj2 = getBean(f.getType());
                    }*/
                    f.set(obj1,obj2);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }

    }

}
