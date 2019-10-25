package com.qdz.entity;

import java.util.List;

public class YamlNode {
    //开始
    private Integer startRow;

    //结束
    private Integer endRow;

    //级别
    private Integer level;

    //每一行的子节点
    private List<YamlNode> childNode;

    //这一行是不是注释
    private boolean isNote;

    //节点名称
    private String nodeName;

    //节点值
    private List<String> nodeVlue;

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }

    public List<YamlNode> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<YamlNode> childNode) {
        this.childNode = childNode;
    }

    public boolean getIsNote() {
        return isNote;
    }

    public void setIsNote(boolean note) {
        isNote = note;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public List<String> getNodeVlue() {
        return nodeVlue;
    }

    public void setNodeVlue(List<String> nodeVlue) {
        this.nodeVlue = nodeVlue;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
