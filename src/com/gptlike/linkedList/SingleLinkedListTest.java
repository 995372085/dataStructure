package com.gptlike.linkedList;

/**
 * @description: 单链表测试
 * @auto : mzh
 * @create: 2020-09-24 21:30
 **/
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node node1 = new Node(1, "张三", "爸爸");
        Node node4 = new Node(4, "赵六", "女儿");
        Node node3 = new Node(3, "王五", "儿子");
//        Node node2 = new Node(2, "李四", "妈妈");
        Node node5 = new Node(4, "赵六六", "女儿儿");
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.show();
        System.out.println("*************************************");
        singleLinkedList.update(node5);
        singleLinkedList.delete(4);
        singleLinkedList.show();
    }
}
