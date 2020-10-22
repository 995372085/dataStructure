package com.gptlike.stack;

/**
 * @description: 用栈解决计算器问题，计算一个表达式-字符串（3+5*6-5）
 * 思路：需要两个栈，一个存放数字一个存放运算符---方法：判断是否是运算符
 * 需要一个指针来扫描表达式---------------变量index
 * 数字直接入栈，运算符需要判断优先级------方法：判断优先级--------->>>>>>>>>升级：判断下一位是否为数字，数字则累计，不是则入栈
 * 1）优先级大于栈中的运算符，则直接入栈---方法：获取栈顶数据（不是出栈，只是显示栈顶数据）
 * 2)优先级小于栈中的运算符，则取出两个数字和一个运算法进行运算，注意！！！出栈顺序-----方法：计算两个数
 * 从栈中取出数据进行运算
 * @auto : mzh
 * @create: 2020-09-27 21:47
 * 3 30 11
 * +  -  *
 **/
public class Calculator {
    public static void main(String[] args) {
        //获取表达式 7*2*2-5+1-5+3-4
        String expression="70*20-10*20";
        //创建指针用于扫描
        int index=0;
        //创建符号栈和数字栈
        CalculatorStack numStack=new CalculatorStack(10);
        CalculatorStack operatorStack=new CalculatorStack(10);
        //创建返回结果
        int num1=0;
        int num2=0;
        int operator=0;
        int res=0;
        //创建标识符，用于拼接
        String keepNum="";
        while (true){
            //设置出口
            if(index==expression.length())break;
            //开始扫描
            char charAt = expression.substring(index, index + 1).charAt(0);
            //判断是否为运算符
            if(numStack.isOperator(charAt)){
                //判断是栈是否为空
                if(!operatorStack.isEmpty()){
                    //不为空判断优先级  优先级大于栈中的优先级
                    if(operatorStack.priority(charAt)>operatorStack.priority(operatorStack.peek())){
                        //直接入栈
                        operatorStack.push(charAt);
                    }else {
                        //优先级低
                        // 1.取出两个数和运算符进行运算
                        // 2.结果放入数栈
                        // 3.运算符入栈
                        num1=numStack.poll();
                        num2=numStack.poll();
                        operator=operatorStack.poll();
                        res=operatorStack.count(num1,num2,operator);
                        numStack.push(res);
                        operatorStack.push(charAt);
                    }
                }else {
                    //为空直接入栈
                    operatorStack.push(charAt);
                }
            }else {
                keepNum+=charAt;
               //判断是否为最后一位
                if(index==expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //不是最后一位  判断下一位是否为数字
                    if(numStack.isOperator(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum="";
                    }
                }
               /* //为数字则直接入栈  char->int
                numStack.push(charAt-48);*/
            }
            index++;
        }
        //扫描完成-取数据进行计算--最后留在栈中的为结果
        while (true){
            if(operatorStack.isEmpty())break;
            num1=numStack.poll();
            num2=numStack.poll();
            operator=operatorStack.poll();
            res=operatorStack.count(num1,num2,operator);
            numStack.push(res);
        }
        System.out.println();
        System.out.println("运算结果为："+numStack.peek());
    }
}

/**
 * 创建栈
 */
class CalculatorStack {
    private int top;
    private int maxSize;
    private int[] data;

    public CalculatorStack(int maxSize) {
        this.top = -1;
        this.data = new int[maxSize];
        this.maxSize = maxSize;
    }

    /**
     * 根据运算符进行计算
     * 注意！！！！！！！！！！！！！
     * 运算顺序，第二个出栈的为首位
     * @param num1---栈中取出的第一个数
     * @param num2---栈中取出的第而个数
     * @param operator---栈中取出的运算符
     * @return
     */
    public int count(int num1,int num2,int operator){
        //判断运算符
        switch (operator){
            case '+':
                return num2+num1;
            case '-':
                return num2-num1;
            case '*':
                return num2*num1;
            case '/':
                return num2/num1;
            default:
                break;
        }
        return 0;
    }
    /**
     * 判断优先级
     * 根据符号的优先级返回不同的数字
     * 优先级越高数字越大
     * @param i-越大优先级越高 i=-1说明运算符无效
     * @return
     */
    public int priority(int i){
        if(i=='*'||i=='/'){
            return 1;
        }else if(i=='+'||i=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 判断是否为运算符
     * @return
     */
    public boolean isOperator(int i) {
        return i=='+'||i=='-'||i=='*'||i=='/';
    }

    //入栈
    public void push(int a) {
        if (isFull()) return;
        top++;
        data[top] = a;
    }

    //出栈
    public int poll() {
        if (isEmpty()) throw new RuntimeException("栈为空，不可取数据！");
        int val = data[top];
        top--;
        return val;
    }

    //获取栈顶数据
    public int peek() {
        return data[top];
    }

    //判断是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //判断是否满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    //遍历
    public void show(){
        //判断是否为空
        if(isEmpty())return;
        for(int i=top;i>-1;i--){
            System.out.printf("数据为：%d\t",data[i]);
        }
    }
    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}
