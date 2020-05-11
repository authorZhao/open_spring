package com.qdz.exception;

/**
 * @author authorZhao
 * @date 2020/1/7
 */
public class SysException extends RuntimeException {

    public static final SysException SYS_EXCEPTION = new SysException("asdf");

    public SysException() {
        throw new IndexOutOfBoundsException();
    }

    public SysException(String aaa) {
        throw new IndexOutOfBoundsException();
    }


}

class  a{

    public static void main(String[] args) {
        System.out.println(SysException.SYS_EXCEPTION);
    }

}


