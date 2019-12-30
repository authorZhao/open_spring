package com.qdz.entity;

/**
 * @author authorZhao
 * @date 2019/12/23
 */
public class User {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }

    public void sqyHello() {
        System.out.println("我系"+userName);
    }

}
