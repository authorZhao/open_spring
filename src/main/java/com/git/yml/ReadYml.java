package com.git.yml;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class ReadYml {

    public Yml readYml22(File file) throws FileNotFoundException, UnsupportedEncodingException {
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
        return null;
    }

    public static YmlLinkedList readYml(String path) {
        try {
            return readYmlInputStream(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static YmlLinkedList readYml(File file) {
        try {
            return readYmlInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getvalue(String line, int level) {
        int i = line.indexOf(":");
        if(i==-1)throw new IllegalArgumentException("请检查格式对不对，是不是少了:");
        String value = line.substring(i+1).trim();
        return value;
    }

    private static String getName(String line, int level) {
        int i = line.indexOf(":");
        if(i==-1)throw new IllegalArgumentException("请检查格式对不对，是不是少了:"+"本行记录"+line);
        String name = line.substring(2*level,i);
        return name;

    }

    private static int getLevel(int row,String line) {
        int kong = line.replaceAll("([ ]*).*", "$1").length();
        int i = kong/2;
        int j = kong%2;
        if(j!=0)throw new RuntimeException("第"+row+"行空格数错误");
        return i;

    }

    public static YmlLinkedList readYmlInputStream(InputStream inputStream)  {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
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

            Yml parent = getParent(linkedList,yml);
            //yml.setParent();

            linkedList.add(yml);
            row++;
        }
        return linkedList;
    }

    /**
     * 根据当前节点查询父节点
     * @param linkedList
     * @param yml
     * @return
     */
    private static Yml getParent(YmlLinkedList linkedList, Yml yml) {
        if(yml.getLevel()==1)return null;

        //1.level小1
        //num小于
        return null;

    }

    public static String getValue(YmlLinkedList linkedList,String key){
        return linkedList.get(key);
    }
}
