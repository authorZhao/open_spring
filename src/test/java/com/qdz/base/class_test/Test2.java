package com.qdz.base.class_test;

public class Test2 {

    private String name;
    private Integer age;
    class Classs{
        String name;
        Integer classNum;
        String addr;
        Integer stuNum;
        void sayHello(){
            System.out.println("我系"+Test2.this.getName()+",来自"+classNum);

        }

    }

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

    @Override
    public String toString() {
        return "Test2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class AA{

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.setAge(18);
        test2.setName("张三");
        Test2.Classs classs = test2.new Classs();
        classs.classNum=3;
        classs.addr="asfas ";
        classs.stuNum=58;
        classs.name="李四";
        classs.sayHello();
        System.out.println(test2);
    }

}
