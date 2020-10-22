package com.gptlike.Queue;

/**
 * @description: 数组实现队列测试
 * @auto : mzh
 * @create: 2020-09-23 23:48
 **/
public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        System.out.println(mq.isEmpty());
        mq.add(2);
        mq.add(3);
        mq.add(4);
        System.out.println(mq.poll());
        System.out.println(mq.poll());
        mq.add(5);
        System.out.println(mq.poll());
        System.out.println(mq.poll());
        System.out.println(mq.isEmpty());
       try {
           System.out.println(mq.poll());
       }catch (RuntimeException e){
           e.getMessage();
           System.out.println(e.getMessage());
       }
    }
}
