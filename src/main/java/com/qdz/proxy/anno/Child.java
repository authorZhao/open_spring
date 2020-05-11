package com.qdz.proxy.anno;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author authorZhao
 * @date 2019/12/31
 */
public class Child extends Person {

    private Long weight,aa,dd;
    private Integer classNum,sdf,asdfe,sdfas;
    public String desc;
    private List list;
    Map map;
    protected Set set;

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Long getAa() {
        return aa;
    }

    public void setAa(Long aa) {
        this.aa = aa;
    }

    public Long getDd() {
        return dd;
    }

    public void setDd(Long dd) {
        this.dd = dd;
    }
}
