package com.qdz.entity;

import java.io.Serializable;
import java.util.List;

public class StringNode implements Serializable {

    private String value;
    private Integer rowNum;
    private List<Integer> childRowNum;
    private Integer ParetnRowNum;
    private Integer level;



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public List<Integer> getChildRowNum() {
        return childRowNum;
    }

    public void setChildRowNum(List<Integer> childRowNum) {
        this.childRowNum = childRowNum;
    }

    public Integer getParetnRowNum() {
        return ParetnRowNum;
    }

    public void setParetnRowNum(Integer paretnRowNum) {
        ParetnRowNum = paretnRowNum;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "StringNode{" +
                "value='" + value + '\'' +
                ", rowNum=" + rowNum +
                ", childRowNum=" + childRowNum +
                ", ParetnRowNum=" + ParetnRowNum +
                ", level=" + level +
                '}';
    }
}
