package com.gptlike.Queue;

/**
 * @description: 数组实现链表----复制数组，不需要设置队列最大值
 * @auto : mzh
 * @create: 2020-09-23 23:31
 **/
public class MyQueue {
    //创建数组--用于存储队列数据
    private int[] arr;

    /**
     * 构造器
     */
    public MyQueue(){
        this.arr=new int[0];
    }

    /**
     * 添加数据到队列中
     * @param data
     */
    public void add(int data){
        //创建新数组，长度为旧数组的长度+1，新数据存储在最后一位
        int[] newArr=new int[arr.length+1];
        //遍历旧数组，将旧数组的数据转移到新数组
        for(int i=0;i<arr.length;i++){
            newArr[i]=arr[i];
        }
        //存放加入的数据
        newArr[arr.length]=data;
        //交换数组
        arr=newArr;
    }

    /**
     * 从队列中取出数据
     * @return
     */
    public int poll(){
        //判断队列是否为空
        if(isEmpty())throw new RuntimeException("队列为空！不能取出数据！");
        //旧数组的第一个数据被取出
        int data=arr[0];
        //创建新数组，数组长度为旧数组的长度-1，
        int[] newArr=new int[arr.length-1];
        //遍历旧数组，将旧数组的数据转移到新数组
        for(int i=0;i<newArr.length;i++){
            newArr[i]=arr[i+1];
        }
        //交换数组
        arr=newArr;
        return data;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return arr.length==0;
    }
}
