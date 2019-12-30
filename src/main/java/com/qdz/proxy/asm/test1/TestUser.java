package com.qdz.proxy.asm.test1;

/**
 * @author authorZhao
 * @date 2019/12/30
 */
public class TestUser {
    public static void main(String[] args) {
        try {
            Class uClass = UserImplUtils.getClass("com.qdz.proxy.asm.test1.UserImpl2", User.class);
            User user = (User)uClass.getConstructors()[0].newInstance();
            user.setName("渣渣辉");
            user.setAge(385);
            System.out.println("带噶好，我系"+user.getName()+",我今天"+user.getAge()+"岁");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
