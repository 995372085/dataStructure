package com.gptlike.linkedList;

/**
 * @description: 单链表
 * @auto : mzh
 * @create: 2020-09-24 21:10
 **/
public class SingleLinkedList {
    //创建单链表的头结点 头结点不存储数据
    public Node head;

    //创建构造器，初始化头结点
    public SingleLinkedList() {
        this.head = new Node();
    }

    /**
     * 向单链表中添加节点--添加到单链表的最后一个
     * 思路：遍历单链表，找到最后一个节点，最后一个节点的指针指向添加的节点
     * 头结点不变，创建辅助节点用于遍历，辅助节点相当于指针，通过一直后移来实现遍历
     *
     * @param node
     */
    public void add(Node node) {
        //创建辅助节点用于遍历
        Node temp = head;
        while (true) {
            //判断是否为最后一个节点
            if (temp.next == null) break;
            //指针后移
            temp = temp.next;
        }
        //当前节点是最后一个节点
        temp.next = node;
    }

    /**
     * temp-新节点-temp.next
     * 有序添加节点（按照节点的数据-no）
     * 思路：遍历单链表查找位置，根据辅助节点temp遍历
     * 当temp下一个节点的no>插入节点的no，则temp节点的位置应该是新节点
     * 新节点.next=temp.next;
     * temp.next=新节点
     * 找到位置后，则让新节点
     *
     * @param node
     */
    public void addByOrder(Node node) {
        //创建辅助节点
        Node temp = head;
        //创建标识符，用于判断是否有重复  默认不重复
        boolean flag = false;
        while (true) {
            //判断是否为最后一个
            if (temp.next == null) break;
            //寻找位置
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            //辅助节点后移
            temp = temp.next;
        }
        //通过判断标志来决定是否插入
        if (flag) {
            System.out.println("已重复" + node.no);
        } else {
            //插入  temp-node-temp.next
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 修改单链表的某个节点，根据新节点的某个数据进行比较
     * 遍历单链表，当no相同时则修改节点
     * @param node
     */
    public void update(Node node){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空~无法修改");
        }
        //创建辅助节点进行遍历
        Node temp=head.next;
        //创建标识符用于判断是否找到
        boolean flag=false;
        while (true){
            //判断链表是否遍历完毕
            if(temp==null)break;
            //判断no 当no相同时则temp就是将要修改的节点
            if(temp.no==node.no){
                flag=true;
                break;
            }
            //接着遍历
            temp=temp.next;
        }
        //判断是否找到
        if(flag){
            temp.name=node.name;
            temp.nickName=node.nickName;
        }else {
            System.out.println("链表中没有你修改的数据");
        }
    }

    /**
     * 删除单链表的节点
     * temp-删除的节点-删除的节点.next
     * @param no
     */
    public void delete(int no){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空~无法删除");
            return;
        }
        //创建辅助节点
        Node temp=head;
        //创建标识符用于判断节点是否找到
        boolean flag=false;
        while (true){
            //判断遍历是否完成
            if(temp.next==null)break;
            //判断no是否相同
            if(temp.next.no==no){
                //此节点为需要删除的节点的前一个节点
                flag=true;
                break;
            }
            //继续遍历
            temp=temp.next;
        }
        if(flag){
            //找到了需要删除的节点 为temp的下一个节点
            //temp-删除-删除.next
            temp.next=temp.next.next;

        }else {
            System.out.println("没有需要删除的节点");
        }
    }
    /**
     * 遍历单链表
     * 通过辅助节点进行遍历
     */
    public void show() {
        //先判断单链表是否为空
        if (head.next == null) {
            System.out.println("单链表为空！！！");
            return;
        }
        //创建辅助节点用于遍历 因为不是空链表 所以辅助指针指向第一个节点
        Node temp = head.next;
        while (true) {
            //判断链表是否遍历完毕
            if (temp == null) break;
            //打印当前节点
            System.out.println(temp);
            //指针后移
            temp = temp.next;
        }
    }
}
/**
 * @description: 单链表的节点
 * @auto : mzh
 * @create: 2020-09-24 21:43
 **/
class Node{
    public int no;
    public String name;
    public String nickName;
    public Node next;

    public Node() {
    }

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}