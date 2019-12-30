package com.git.array;

public class ArrayUtils {

    /**
     * 数组下标越界检查
     * @param index 数组下标
     * @param size 数组大小
     * @param <X> 运行时异常
     * @return
     */
    public static <X extends RuntimeException> int checkIndex(int index,int size){
        if(index<0||index>size-1)throw new IndexOutOfBoundsException("下标越界");
        return index;
    }

}

