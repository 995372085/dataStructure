package com.gptlike.Queue;

/**
 * 队列-是一个有序列表，可以用数组或者链表实现，遵循先入先出的原则。
 * 用数组模拟队列，缺陷数组使用一次就无法再用，不能复用！！！！
 * @description: 数组实现队列
 * @auto : mzh
 * @create: 2020-09-23 21:30
 **/
public class ArrayQueue {
    private int maxSize;//队列的最大容量
    private int front;//队列第一个元素的前一个元素的下标
    private int rear;//队列最后一个元素的下标
    private int[] arr;//用于存储队列数据

    /**
     * 队列的构造方法-初始化队列
     * @param maxQueueSize-队列的最大容量
     */
    public ArrayQueue(int maxQueueSize){
        this.maxSize=maxQueueSize;
        this.arr=new int[maxQueueSize];
        this.front=-1;
        this.rear=-1;
    }

    /**
     * 向队列中添加数据
     * @param data-数据
     */
    public void addQueue(int data){
        //判断队列是否已满
        if(isFull()){
            System.out.println("队列已满！！无法添加！！");
        }
        //尾指针后移
        arr[++rear]=data;
    }

    /**
     * 从队列中获取数据
     * @return
     */
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空！！无法取出数据！！！");
        }
        //头指针后移,获取数据
        int result=arr[++front];
        arr[front]=0;
        return result;
    }
    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        if(front==rear)return true;
        return false;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull(){
        if(rear==maxSize-1)return true;
        return false;
    }

    /**
     * 展示队列的元素-遍历队列
     */
    public void show(){
        //判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空！！！");
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\t",i,arr[i]);
        }
        System.out.println();
    }

    /**
     * 展示队列的头元素
     * @return
     */
    public int headQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空！没有第一个元素！");
        }
        //取出第一个元素
        return arr[front+1];
    }
}
