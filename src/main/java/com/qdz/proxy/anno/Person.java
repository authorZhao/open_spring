package com.qdz.proxy.anno;

/**
 * @author authorZhao
 * @date 2019/12/31
 */
public class Person {

    public String name;
    public Integer age;
    public Long heigh;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getHeigh() {
        return heigh;
    }

    public void setHeigh(Long heigh) {
        this.heigh = heigh;
    }
}
