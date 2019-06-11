package com.qdz.frameWork.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author authorZhao
 */
public class QdzFileUtil {
    public static final Logger logger = LoggerFactory.getLogger(QdzFileUtil.class);
    /**
     * 路径直接生成文件
     * @param path f:/aaa/ccc/a.txt
     *             /asd/cdv/ass
     * @return 文件
     */
    public static File getFile(String path){
        path = pathFormat(path);
        String[] str = path.split("/");
        String index = str[str.length-1];
        String dirPath = path.substring(0,path.lastIndexOf(index));
        File dir = new File(dirPath);
        if(!dir.exists())dir.mkdirs();
        File file = new File(dirPath+"/"+index);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!file.isFile())throw new RuntimeException("this is not a file");
        logger.info("文件正在生成，路径为：    "+ file.getPath());
        return file;
    }

    /**
     * 通过文件后缀获取文件类型
     * @param path
     * @return txt等
     */
    public static String getFileType(String path){
        return path.substring(path.lastIndexOf(".")+1);
    }

    /**
     * 格式化路径
     * @param path a\\c\\c//v///v
     * @return a/c/c/v/v
     */
    public static String pathFormat(String path) {
        path = path.replaceAll("\\\\", "/");
        if(path.contains("//")) {
            path = path.replaceAll("//", "/");
            return pathFormat(path);
        }else {
            return path;
        }
    }

    /**
     * 通过文件路径获得文件名，不含后缀
     * @param path f:////asdf\\asd\\asdf//a.txt
     * @return a
     */
    public static String getFileName(String path){
        path = pathFormat(path);
        path = path.substring(path.lastIndexOf("/")+1);
        return path.substring(0,path.lastIndexOf("."));
    }



    public static void main(String... args){

        File file = getFile("f:////asdf\\asd\\asd");
        System.out.println(file.isFile());
        System.out.println(file.getName());

    }

}




