package com.gptlike.sort;

import java.util.Arrays;

/**
 * @description: 选择排序
 * 思想：进行N-1趟排序。
 * 每一趟开始时，默认最小值为首位，然后进行循环比较，最小值和之后的每一位进行比较，如果后一位大于最小值则重新确定最小值和最小值的下标
 * 每一趟结束时，对最小值的下标进行判断，当发生变化时，则进行交换。
 * @auto : mzh
 * @create: 2020-10-21 20:52
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,-1,5,4};
        System.out.println(Arrays.toString(arr));
        sort(arr);
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void sort(int[] arr){
        //一共进行N-1趟，每一趟的最小值默认为每一趟的第一个
        for (int i=0;i<arr.length-1;i++){
            //定义最小值和最小值的下标用于交换
            int min=arr[i];
            int minIndex=i;
            //开始循环比较 第二个和前一个进行比较
            for (int j=i+1;j<arr.length-1;j++){
                //最小值之后的每一个数和最小值进行比较
                if(min>arr[j]){
                    //后一个数大于前一个数，重新定义最小值
                    min=arr[j];
                    minIndex=j;
                }
            }
            //循环完毕判断最小值是否发生变化
            if(minIndex!=i){
                //最小值发生变化，交换最小值
                //先将之前定义的最小值->真正的最小值
                //真正的最小值=定义的最小值
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
            System.out.println("第"+(i+1)+"趟排序的结果:"+ Arrays.toString(arr));
        }
    }
}
