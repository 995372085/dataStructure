package com.gptlike.linkedList;

/**
 * @description: 双向链表
 * @auto : mzh
 * @create: 2020-09-25 21:28
 **/
public class DoubleLinkedList {
    //头结点6
    public DoubleNode head;
    //初始化头结点
    public DoubleLinkedList() {
        this.head = new DoubleNode();
    }
    /**
     * 添加
     * 默认添加到链表最后
     * 思路：通过遍历找到最后一个节点
     * temp.pre-temp+doubleNode
     */
    public void add(DoubleNode doubleNode){
        //创建辅助节点用于遍历
        DoubleNode temp=head;
        //开始遍历
        while (true){
            //判断是否是最后一个节点
            if(temp.next==null)break;
            //后移
            temp=temp.next;
        }
        //现在的temp已经是最后一个节点了
        temp.next=doubleNode;
        doubleNode.pre=temp;
    }
    /**
     * 删除节点
     * 与单链表不同 单链表的temp是需要删除节点的上一个节点
     * 双链表的temp是需要删除的节点
     * 正常节点     temp.pre-temp-temp.next
     * 最后一个节点  temp.pre-temp
     */
    public void delete(int no){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空！！！");
            return;
        }
        //创建辅助节点
        DoubleNode temp=head.next;
        //创建标识符判断是否找到需要删除的节点
        boolean flag=false;
        //开始遍历
        while (true){
            //判断是否为最后一个
            if(temp==null)break;
            //no相同则temp为需要删除的节点
            if(temp.no==no){
                flag=true;
                break;
            }
            //后移
            temp=temp.next;
        }
        if(flag){
            //找到节点
            temp.pre.next=temp.next;
            //判断是否为最后一个节点
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else {
            //未找到
            System.out.println("未找到需要删除的节点");
        }
    }
    /**
     * 修改
     * 遍历链表，通过id相同找到需要修改的节点
     * 找到需要修改的节点，进行修改数据
     */
    public void update(DoubleNode doubleNode){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空!!!");
            return;
        }
        //创建辅助节点
        DoubleNode temp= head.next;
        //创建标识符用于判断是否找到
        boolean flag=false;
        while (true){
            //判断是否为最后节点
            if(temp==null) break;
            //条件判断
            if(temp.no==doubleNode.no){
                flag=true;
                break;
            }
            //后移
            temp=temp.next;
        }
        if(flag){
            //找到--修改节点
            temp.name=doubleNode.name;
            temp.nickName=doubleNode.nickName;
        }else {
            //没找到
            System.out.println("没有找到需要修改的节点！！！");
        }
    }
    /**
     * 遍历双向链表
     */
    public void show(){
        //判断双链表是否为空
        if(head.next==null){
            System.out.println("链表为空哦！！！");
            return;
        }
        //创建辅助节点
        DoubleNode temp=head.next;
        while (true){
            //判断是否为最后一个节点
            if(temp==null)break;
            System.out.println(temp);
            temp=temp.next;
        }
    }
}
/**
 * @description: 双链表节点
 * @auto : mzh
 * @create: 2020-09-25 21:29
 **/
class DoubleNode{
    public int no;
    public String name;
    public String nickName;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode() {
    }

    public DoubleNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
