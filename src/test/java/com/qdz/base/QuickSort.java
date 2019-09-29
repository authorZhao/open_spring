package com.qdz.base;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = getRandomInt(10);
        System.out.println(Arrays.toString(arr));
        long t1 = System.currentTimeMillis();


        quickSort(0,arr.length-1,arr);
        int i = 8;
        System.out.println(i--);
        long t2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println("总共耗时"+(t2-t1));
    }

    private static void quickSort(int begin, int end, int[] arr) {

        if(begin>=end)return;

        int mid = arr[begin];
        int low = begin;
        int hight = end;

        while(low<hight){
            while(arr[hight] > mid){

                --hight;
            }
            arr[low] = arr[hight];

            while(arr[low] <= mid){
                ++low;
            }
            arr[hight] = arr[low];
        }
        System.out.println(Arrays.toString(arr));
        arr[low] = mid;
        System.out.println(Arrays.toString(arr));
        quickSort( begin, low-1,arr);
        quickSort(low+1, end,arr);


    }


    private static int[] getRandomInt(int i) {
        Random random = new Random();
        int[] arr = new int[i];
        for (int j = 0; j < arr.length ; j++) {
            arr[j] = random.nextInt(1000);
        }
        return arr;
    }


}
