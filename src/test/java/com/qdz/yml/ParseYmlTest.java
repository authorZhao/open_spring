package com.qdz.yml;


import com.qdz.ArrayUtils;
import com.qdz.entity.YamlNode;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.ho.yaml.Yaml;
import org.junit.Test;

import java.io.*;
import java.util.*;

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
        // 35表示#
        int i=0;
        if(bytes[i]==35){
            int aa = ArrayUtils.getIndex2(i,13,10,bytes);
            if(aa!=-1)i = aa+2;
        }
        // \r\n
        if(bytes[i]==13&&bytes[i+1]==10){
            i+=2;
        }
        // 第一个key i-  aa-1
        int aa = ArrayUtils.getIndex3(i,58,13,10,bytes);
        byte[] firstKey = new byte[aa-i];
        System.arraycopy(bytes,i,firstKey,0,firstKey.length);
        String sss = new String(firstKey);

        YamlNode rootNode = new YamlNode();
        int asd = ArrayUtils.getLineNum(bytes);

        System.out.println(sss);
        //找出第一个 58,13,10

        String ss =  new String(bytes);
        System.out.println(ss);

    }


    @Test
    public void test6() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("application.yml");
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
        StringBuffer buffer = new StringBuffer();
        List<String> stringList = new ArrayList<>();
        String line = "";
        while (true){
            try {
                if (!((line = in.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringList.add(line);
        }
        //logger.info("正在解析模板文件"+buffer.toString());
        String ss =  buffer.toString();
        System.out.println(stringList);




        YamlNode rootNode = new YamlNode();
        rootNode.setIsNote(false);
        rootNode.setNodeName("root");
        rootNode.setStartRow(0);
        rootNode.setEndRow(stringList.size());
        rootNode.setNodeVlue(stringList);
        rootNode.setLevel(0);


        List<YamlNode> childNode = new ArrayList<>();
        int j = 0;
        //expandChildNode(rootNode);

        for (int i = 0; i < stringList.size(); i++) {
            if(StringUtils.isNotBlank(stringList.get(i))&&stringList.get(i).charAt(0)!=32){

                YamlNode yamlNode = new YamlNode();
                if(stringList.get(i).startsWith("#")){
                    yamlNode.setIsNote(true);
                }else{
                    yamlNode.setIsNote(false);
                }
                yamlNode.setStartRow(i);
                yamlNode.setNodeName(stringList.get(i));
                childNode.add(yamlNode);
            }
        }
        rootNode.setChildNode(childNode);
        System.out.println(rootNode);
    /*    Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println(properties);*/
    }

    private void expandChildNode(YamlNode rootNode) {
        List<String> value =  rootNode.getNodeVlue();

        for (int i = 0; i < value.size(); i++) {
            YamlNode node = new YamlNode();
            String row = value.get(i);
            node.setNodeName(row);
            node.setStartRow(i);
            if(row.startsWith("#")){
                node.setIsNote(true);
            }else{
                node.setIsNote(false);
            }
            setNodeLevel(node);
            if(node.getLevel()==null||node.getLevel()!=1)continue;
            setNodeParent(rootNode,node,value,i);

        }


        //rootNode.setChildNode(childNode);
    }

    private void setNodeParent(YamlNode rootNode, YamlNode node, List<String> value, int i) {


        if(node.getLevel()==1){
            List<YamlNode> yamlNodeList = rootNode.getChildNode();
            if(yamlNodeList==null)yamlNodeList = new ArrayList<>();
            yamlNodeList.add(node);
            rootNode.setChildNode(yamlNodeList);
        }else{
           // setNodeLevel();




        }


    }


    private void setNodeLevel(YamlNode node) {
        String name = node.getNodeName();
        int j = 0;
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i)==' '){
                j++;
            }else{
                return;
            }
        }
        if(j%2==0){
            node.setLevel(j/2);
        }else {
            node.setLevel(null);
        }
    }


}
