package com.qdz.yml;


import com.git.yml.ReadYml;
import com.git.yml.YmlLinkedList;
import org.junit.Test;

import java.io.IOException;

public class ParseYmlTest3 {

    @Test
    public void test1() throws IOException {
        String path = "D:\\idea\\workspace2\\test\\open_spring\\src\\main\\resources\\application.yml";
        YmlLinkedList ymls = ReadYml.readYml(path);
        String value = ReadYml.getValue(ymls, "spring.datasource.username");
        System.out.println(value);


    }

}
