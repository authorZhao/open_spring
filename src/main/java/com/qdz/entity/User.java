package com.qdz.entity;

/**
 * @author authorZhao
 * @date 2019/12/23
 */
public class User {

    public User(String userName, Integer age, Long sex) {
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }

    private String userName;

    private Integer age;

    private Long sex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }
}
