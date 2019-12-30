package com.git.yml;

import java.util.Iterator;
import java.util.List;

public class Yml {

    private Integer num;
    private String name;
    private List<Yml> child;
    private String value;
    private Integer level;
    private Yml parent;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Yml> getChild() {
        return child;
    }

    public void setChild(List<Yml> child) {
        this.child = child;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Yml getParent() {
        return parent;
    }

    public void setParent(Yml parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Yml{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", child=" + child +
                ", value='" + value + '\'' +
                ", level=" + level +
                ", parent=" + parent +
                '}';
    }
}
