package com.gptlike.stack;

import java.util.Scanner;

/**
 * @description: 数组实现栈测试
 * @auto : mzh
 * @create: 2020-09-27 20:44
 **/
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        String key="";
        boolean loop=true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("s:展示--a:添加--p:取出--q:退出");
            System.out.println("请输入选项:");
            key = scanner.next();
            switch (key){
                case "s":
                    arrayStack.show();
                    break;
                case "a":
                    System.out.println("请输入一个数字：");
                    int i = scanner.nextInt();
                    arrayStack.add(i);
                    break;
                case "p":
                    try {
                        System.out.println("出栈的信息为："+arrayStack.poll());
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }finally {
                        break;
                    }
                case "q":
                    scanner.close();
                    loop=false;
            }
        }
    }
}
