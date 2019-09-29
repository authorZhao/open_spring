package com.qdz.yml;


import org.apache.commons.io.FileUtils;
import org.ho.yaml.Yaml;
import org.junit.Test;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class ParseYmlTest {

    @Test
    public void test1() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("application.yml");
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while (true){
            try {
                if (!((line = in.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            buffer.append(line);
        }
        //logger.info("正在解析模板文件"+buffer.toString());
        String ss =  buffer.toString();
        System.out.println(ss);

    /*    Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println(properties);*/
    }


    @Test
    public void test2(){
        Yaml yaml = new Yaml();// 这个需要的jar为:org.yaml.snakeyaml

        //MailConfig 这个是这个主函数所在的类的类名
        InputStream resourceAsStream = ParseYmlTest.class.getClassLoader()
                .getResourceAsStream("application.yml");

        //加载流,获取yaml文件中的配置数据，然后转换为Map，
        Map obj = (Map) yaml.load(resourceAsStream);
        System.out.println(obj);
    }

    @Test
    public void test3() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("application.yml");
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        //logger.info("正在解析模板文件"+buffer.toString());
        String ss =  new String(bytes);
        System.out.println(ss);

    }

}
