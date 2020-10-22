package com.gptlike.stack;

/**
 * @description: 数组实现栈
 * @auto : mzh
 * @create: 2020-09-27 20:33
 * 栈是先入后出的，所以在遍历时应注意从栈顶开始遍历！！！！！！！！！！！！！！！！！！
 **/
public class ArrayStack {
    //栈的最大容量
    private int maxSize;
    //栈顶
    private int top;
    //数组，存放栈数据
    private int[] stack;
    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack=new int[maxSize];
        this.top=-1;
    }

    /**
     * 入栈方法
     * @param data--需要入栈的数据
     */
    public void add(int data){
        //判断栈是否已满
        if(isFull()){
            System.out.println("栈已满，无法添加数据");
            return;
        }
        top++;
        stack[top]=data;
    }

    /**
     * 出栈方法
     * @return-数据
     */
    public int poll(){
        //判断栈是否为空
        if(isEmpty()){
            throw new RuntimeException("栈为空，没有数据！！！");
        }
        int value=stack[top];
        top--;
        return value;
    }

    /**
     * 遍历栈，用于显示
     */
    public void show(){
        //判断栈是否为空
        if(isEmpty()){
            System.out.println("栈为空！！");
            return;
        }
        //开始遍历-需要从栈顶显示数据
        for (int i=top;i>-1;i--){
            System.out.println(stack[i]);
        }
    }
    //判断栈满
    public boolean isFull(){
        return top==maxSize-1;
    }
    //判断栈是否为空
    public  boolean isEmpty(){
        return top==-1;
    }
}
