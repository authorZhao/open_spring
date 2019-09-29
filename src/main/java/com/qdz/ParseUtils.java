package com.qdz;

import java.io.File;
import java.util.Map;

/**
 * 用来解析配置文件，包括
 * xml、yml、properties
 */
public interface ParseUtils {

    Map<String,Object> readProperties();

    /**
     * 读取配置文件,
     * @param file 文件
     * @return
     */
    Map<String,Object> readProperties(File file);
}
