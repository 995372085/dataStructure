package com.gptlike.Queue;

import java.util.Scanner;

/**
 * @description: 数组模拟的队列测试
 * 测试结果：用数组模拟队列，缺陷数组使用一次就无法再用，不能复用！！！！
 * @auto : mzh
 * @create: 2020-09-23 21:51
 **/
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        //用于检测用户输入
        Scanner scanner = new Scanner(System.in);
        //获取用户输入的数据
        char key=' ';
        //接收条件 -默认死循环
        boolean loop=true;
        while (loop){
            System.out.println("s(展示队列数据)\na(添加数据)\ng(获取数据)\nh(获取队列第一个数据)\nq(退出系统)");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.show();
                    break;
                case 'a':
                    System.out.println("请输入需要添加的数据：");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g':
                    try {
                        System.out.println("从队列中获取的数据为-----"+arrayQueue.getQueue());
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }finally {
                        break;
                    }
                case 'h':
                    try {
                        System.out.println("队列的第一个数据是-----"+arrayQueue.headQueue());
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }finally {
                        break;
                    }
                case 'q':
                    scanner.close();
                    loop=false;
            }
        }
        System.out.println("程序已退出！！！");
    }
}
