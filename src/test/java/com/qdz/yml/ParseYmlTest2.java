package com.qdz.yml;


import com.git.array.MyLinkedList;
import com.git.yml.Yml;
import com.git.yml.YmlLinkedList;
import com.qdz.ArrayUtils;
import com.qdz.entity.YamlNode;
import org.apache.commons.lang3.StringUtils;
import org.ho.yaml.Yaml;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseYmlTest2 {

    @Test
    public void test1() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("application.yml");
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        int row = 0;
        YmlLinkedList linkedList = new YmlLinkedList();
        while (true) {
            try {
                if (!((line = in.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (StringUtils.isBlank(line)) continue;
            String aa = line.trim();
            if (aa.startsWith("#")) continue;
            buffer.append(line);
            Yml yml = new Yml();

            yml.setNum(row);
            int level = getLevel(row, line);
            yml.setLevel(level);
            yml.setName(getName(line, level));
            yml.setValue(getvalue(line, level));
            linkedList.add(yml);
            row++;
        }
        System.out.println(linkedList);
        String s = linkedList.get("mybatis-plus.mapper-locations");
        System.out.println(s);
    }

    private String getvalue(String line, int level) {
        int i = line.indexOf(":");
        if(i==-1)throw new IllegalArgumentException("请检查格式对不对，是不是少了:");
        String value = line.substring(i+1).trim();
        return value;
    }

    private String getName(String line, int level) {
        int i = line.indexOf(":");
        if(i==-1)throw new IllegalArgumentException("请检查格式对不对，是不是少了:"+"本行记录"+line);
        String name = line.substring(2*level,i);
        return name;

    }

    private void setYml(Yml root, int row, String line) {
        int level = getLevel(row,line);

        String[] split = line.split(":");
        String name = line.substring(0,line.indexOf(":"));
        if(split.length!=2)

            if(root.getLevel()<level){
                List<Yml> child = root.getChild();
                if(child==null)child=new ArrayList<>();



            }

    }

    private int getLevel(int row,String line) {
        int kong = line.replaceAll("([ ]*).*", "$1").length();
        int i = kong/2;
        int j = kong%2;
        if(j!=0)throw new RuntimeException("第"+row+"行空格数错误");
        return i;

    }

    @Test
    public void test2(){
       /* String str="";
        System.out.println(str.replaceAll("([ ]*).*", "$1").length());
        String line = "asd:asdf:asdf ";
        String name = line.substring(0,line.indexOf(":"));
        System.out.println(name);*/

        String name1 = "name:";
        String name2 = "name: asd: ";
        String name3 = " name: asd: ";
        String name4 = "  name: asd: asd";
        System.out.println(getName(name1,getLevel(0,name1)));
        System.out.println(getName(name2,getLevel(0,name2)));
        System.out.println(getName(name4,getLevel(0,name4)));
        System.out.println(getvalue(name4,getLevel(0,name4)));
        System.out.println(getName(name3,getLevel(0,name3)));

    }
}
