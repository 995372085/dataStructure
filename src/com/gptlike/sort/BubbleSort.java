package com.gptlike.sort;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * 思想：每一趟找到数组中最大的元素放到最后
 *       一共进行N-1趟
 * @auto : mzh
 * @create: 2020-10-21 11:38
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,-1,5,4};
        System.out.println(Arrays.toString(arr));
        Bubble(arr);
    }
    public static void Bubble(int[] arr){
        //定义辅助变量
        int temp=0;
        boolean flag=false;
        //一共进行n-1趟
        for (int i=0;i<arr.length-1;i++){
            //从第一个开始，第一个和第二个比较一直到已经确定的最大数，第一趟最后一个，第二趟确定倒数第二个
            for (int j=0;j<arr.length-1-i;j++){
                //进行比较，后面数比前面数大则进行交换
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            System.out.println("第"+(i+1)+"趟冒泡排序的结果:"+ Arrays.toString(arr));
            //冒泡的优化，如果一趟进行下来没有进行交换则说明数据有序
            if(!flag){
                break;
            }else {
                flag=false;
            }
        }
    }
}
