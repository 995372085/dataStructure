package com.gptlike.linkedList;

/**
 * @description: 循环链表节点
 * @auto : mzh
 * @create: 2020-09-26 21:38
 **/
public class LoopNode {
    private int data;
    private LoopNode next;

    /**
     * 构造器
     * 下一个节点指向自己
     * @param data
     */
    public LoopNode(int data) {
        this.data=data;
        this.next=this;
    }

    /**
     * 获取节点的数据
     * @return
     */
    public int getData(){
        return this.data;
    }

    /**
     * 添加节点
     * 找到
     * @param node
     */
    public void add(LoopNode node){
        //取出下一个节点，作为下下个节点
        LoopNode nextNode=this.next;
        //新节点作为下一个节点
        this.next=node;
        //新节点的下一个节点作为下下个节点
        node.next=nextNode;
    }

    /**
     * 删除下一个节点
     */
    public void delete(){
        //取出下下个节点
        LoopNode nextNode=this.next.next;
        //下个节点为下下个节点
        this.next=nextNode;
    }
    public LoopNode getNextNode(){
        return this.next;
    }

    public static void main(String[] args) {
        LoopNode node1 = new LoopNode(1);
        LoopNode node2 = new LoopNode(2);
        LoopNode node3 = new LoopNode(3);
        LoopNode node4 = new LoopNode(4);
        node1.add(node2);
        node1.add(node3);
        node1.add(node4);
        System.out.println(node1.getNextNode().getData());
        System.out.println(node2.getNextNode().getData());
        System.out.println(node3.getNextNode().getData());
        System.out.println(node4.getNextNode().getData());
    }
}
//1-3-2-1