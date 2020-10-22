package com.gptlike.linkedList;

/**
 * @description: 约瑟夫问题
 * 约瑟夫问题为：设编号为1,2,3,4,5...n的n个人围坐一圈，约定编号为k（1<=k<=n）的人开始报数，数到m的那个人出列，依次类推，直到所有人都出列为止，由此产生一个出队编号的序列
 * 用环形链表来解决此问题
 * 构建环形链表思路：
 *     1.先创建一个节点，first指向该节点
 *     2.后面创建的节点，直接加入到链表当中
 * 遍历环形链表思路：
 *     1.创建辅助节点curBoy,指向first节点
 *     2.通过指针后移开始遍历，当curBoy的next是first时，遍历结束.
 *
 * @auto : mzh
 * @create: 2020-09-26 22:29
 **/
public class Josephu {
    public static void main(String[] args) {
        //创建循环链表
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        //添加5个小孩
        list.add(5);
        //遍历显示
        list.show();
        list.countBoy(1,2,5);
    }
}

/**
 * 创建环形链表
 * 注意遍历时，先输出当前小孩的信息再判断
 */
class CircleSingleLinkedList{
    //创建first节点
    private Boy first;

    public CircleSingleLinkedList() {
        this.first = null;
    }

    /**
     * 添加小孩个数
     * @param nums--初始有几个小孩，题目中的n个小孩
     */
    public void add(int nums){
        //nums验证
        if(nums<1){
            System.out.println("您输入的小孩数量有误！！！");
            return;
        }
        //创建辅助指针,用于遍历创建小孩
        Boy curBoy=null;
        //遍历创建小孩
        for (int i=1;i<=nums;i++){
            //创建小孩
            Boy boy=new Boy(i);
            //判断是否为第一个小孩,第一个小孩需要自己成环形链表
            if(i==1){
                //第一个节点就是第一个小孩
                first=boy;
                //设置第一个节点的下一个节点为首节点
                boy.setNext(first);
                //辅助变量指向第一个节点
                curBoy=first;
            }else {
                //不是第一个小孩,直接添加到链表中
                //先让辅助节点的下一个节点指向当前小孩
                curBoy.setNext(boy);
                //再让当前小孩的下一个节点指向第一个节点
                boy.setNext(first);
                //移动辅助节点用于遍历
                curBoy=boy;
            }
        }
    }

    /**
     * 小孩出圈
     * @param k--第几个小孩开始报数
     * @param m--数到几出圈
     * @param nums--一共多少个小孩
     */
    public void countBoy(int k,int m,int nums){
        //参数的判断-- 链表有数据
        if(first==null||k<0||k>nums||m<0){
            System.out.println("参数有误！！");
            return;
        }
        //创建辅助指针，用于小孩出圈
        Boy helper=null;
        //先移动first到需要报数的小孩
        for (int i=0;i<k-1;i++){
            first=first.getNext();
        }
        helper=first;
        //移动helper到first后,用于删除(小孩出圈)
        while (true){
            if(helper.getNext()==first)break;
            helper=helper.getNext();
        }
        //遍历
        while (true){
            //当只剩一个小孩则出队完毕，输出最后一个小孩  24153
            if(first.getNext()==first){
                System.out.printf("最后留在圈里的是编号为 %d 的小孩",first.getNo());
                break;
            }
            //报数移动指针，因为自己也报数，所以次数为m-1
            for (int i=0;i<m-1;i++){
                first=first.getNext();
                helper=helper.getNext();
            }
            //小孩出圈
            System.out.printf("编号为 %d 的小孩",first.getNo());
            helper.setNext(first.getNext());
            first=first.getNext();
        }
    }
    /**
     * 遍历循环链表
     */
    public void show(){
        //判断链表是否为空
        if(first==null){
            System.out.println("链表为空！没有小孩！");
            return;
        }
        //创建辅助节点用于遍历
        Boy curBoy=first;
        while (true){
            //打印信息
            System.out.printf("编号为 %d 的小孩\n",curBoy.getNo());
            //当辅助节点的下一个节点为first，则遍历完成
            if(curBoy.getNext()==first)break;
            //指针后移
            curBoy=curBoy.getNext();
        }
    }

}
/**
 * 环形链表节点-相当于一个小孩
 */
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}