package com.gptlike.linkedList;

/**
 * @description: 双向链表测试
 * @auto : mzh
 * @create: 2020-09-25 21:40
 **/
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleNode doubleNode1 = new DoubleNode(1, "张三", "三三三");
        DoubleNode doubleNode2 = new DoubleNode(2, "李四", "sssss");
        DoubleNode doubleNode3 = new DoubleNode(3, "王五", "wwwww");
        DoubleNode doubleNode33 = new DoubleNode(3, "王五五", "呜呜呜呜呜");
        DoubleNode doubleNode4 = new DoubleNode(4, "赵六", "lllll");
        doubleLinkedList.add(doubleNode1);
        doubleLinkedList.add(doubleNode2);
        doubleLinkedList.add(doubleNode3);
        doubleLinkedList.show();
        System.out.println("****************修改*****************");
        doubleLinkedList.update(doubleNode33);
        doubleLinkedList.show();
        System.out.println("****************删除*****************");
        doubleLinkedList.delete(3);
        doubleLinkedList.show();

    }
}
