package com.qdz.base.class_test;

class Test1 {
        //30，20，10。
        public int num = 10;
        class Inner {
            public int num = 20;
            public void show() {
                int num = 30;
                System.out.println(num);    //填入合适的代码
                System.out.println(this.num);
                System.out.println(Test1.this.num);
            }
        }


}

class InnerClassTest {
    public static void main(String[] args) {
        Test1.Inner oi = new Test1().new Inner();
        oi.show();
    }
}

interface Inter {
    void show();
}
class Outer {
    //补齐代码
    static Inter method(){
        return () -> System.out.println("HelloWorld");
    }

}
class OuterDemo {
    public static void main(String[] args) {
        Outer.method().show();
    }
}

 class BwfOuterClass {

    private int x = 1;

    private int y = 2;

    private class BwfInnerClass{

        private int x = 3;

        public void print(){

            System.out.println("x+y="+(x+y) );

        }

    }

    public static void main(String[] args) {

        new BwfOuterClass().new BwfInnerClass().print();

    }

}
