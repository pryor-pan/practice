package com.linklist;

/**
 * Remarks: 单链表的实现
 * Author:panlai
 * :Date:2021/4/5
 */
//定义节点类型
class Node{
    public int data; //0
    public Node next;//null

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class MyLinkedList {
    public Node head;   //保存单链表的头结点的引用  null


    //单链表的方法
    //1、头插法
    public void addFirst(int data){
        Node node = new Node(data);
        //第一次插入
        if (this.head == null) {        //说明是第一次插入节点
            this.head = node;
            return ;
        }
        node.next = this.head;
        head = node;
    }
    //2、尾插法     关键：找尾巴
    public void addLast(int data){
        Node node = new Node(data);
        //第一次插入                     //第一次插入对于头插和尾插都一样。
        if (this.head == null){
            this.head = node;
            return;
        }
        //非第一次插入
        Node cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }
    //3、任意位置插入，第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        Node node = new Node(data);
        if(index == 0){                     //index等于0
            addFirst(data);                 //相当于头插
        }
        if (index == this.size()){          //index等于最后一个位置
            addLast(data);                  //相当于尾插
        }
        Node cur = searchIndex(index);             //定义一个cur为index的前面那个节点，因为要往3号插要在2号操作。
        node.next = cur.next;
        cur.next = node;
    }
    //方法：返回下标为index的前一个节点的地址。
    public Node searchIndex(int index){
        Node cur = this.head;
        while(index -1 != 0){
           cur = cur.next;
           index--;
        }
        return cur;
    }
    //4、查找关键字key，是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while(cur != null){
            if (cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //5、删除第一次出现关键字为key的节点       删除第5个节点要找到第4个节点
    public void remove(int key){
        //key的值为第一个节点
        if (this.head.data == key){         //说明要删的节点是第一个结点
            this.head = this.head.next;
        }
        //key的值不是第一个节点
        Node prev = searchPrev(key);
        if(prev == null){
            System.out.println("没有找到这个节点！1");
            return ;
        }
        Node del = prev.next;
        prev.next = del.next;
    }
    //方法：找到要删除的节点的前驱
    private Node searchPrev(int key){
        Node prev = this.head;
        while(prev.next != null){
            if (prev.next.data == key){
                return prev;
            }
            else{
                prev = prev.next;
            }
        }
        return null;
    }
    //6、删除所有值为key的节点
    public void removeAllkey(int key){
        Node prev  = this.head;         //prev为头结点
        Node cur = this.head.next;      //cur为第二个节点，后续也是要删除的节点
        while (cur != null){
            if (cur.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }
            else
            {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key){     //循环执行完后判断头结点的值是不是key，是则删除
            this.head = this.head.next;
        }

    }
    //7、得到单链表的长度
    public int size(){
        Node cur = this.head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }
    //8、打印单链表
    public void display(){
        Node cur = this.head;
        while (cur!=null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
    //9、清空单链表       //释放内存的，在jvm中如果一个对象没有引用，他就会被回收，
    public void clear(){
        this.head = null;
    }




}
