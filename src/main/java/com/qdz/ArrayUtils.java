package com.qdz;

import java.util.Arrays;

public class ArrayUtils {

    /**
     * 在byte数组里面找出连续两个数字
     * @param i
     * @param j
     * @param bytes
     * @return
     */
    public static int getIndex2(int start,int i, int j, byte[] bytes){
        for (int k = start; k < bytes.length; k++) {
            if(i==bytes[k]){
                if(j==bytes[k+1])return k;
            }
        }
        return -1;
    }

    public static int getIndex3(int start,int i, int j, int h ,byte[] bytes){
        for (int k = start; k < bytes.length; k++) {
            if(i==bytes[k]){
                if(j==bytes[k+1]){
                    if(h==bytes[k+2])return k;
                }
            }
        }
        return -1;
    }

    public static int getLineNum(byte[] bytes){
        int count = 0,i=13,j=10;
        for (int k = 0; k < bytes.length; k++) {
            if(i==bytes[k]){
                if(j==bytes[k+1]){
                    count++;
                }
            }else{
                continue;
            }
        }
        return count;
    }

    /**
     * byte数组分割
     * @param bytes
     * @return
     */
    byte[][] averageBytes(byte[] bytes){
        int start = 0;
        int i = 13, j = 0;
        int line = getLineNum(bytes);
        byte[][] bytes1 = new byte[line][];




        for (int k = 0; k <bytes1.length ; k++) {
            for (int l = 0; l < bytes1[k].length; l++) {
                byte[] bytes2 = new byte[1000];



                //bytes1[k][l] = n
            }
        }




        return null;
    }
}
