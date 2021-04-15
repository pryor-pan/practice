package com.doulinklist;

/**
 * Remarks: 双向链表
 *              每一个节点有三个域，
 *
 * Author:panlai
 * :Date:2021/4/11
 */
class Node {
    public int data;
    public Node prev;       //前驱信息
    public Node next;       //后继信息

    public Node(int data){
        this.data = data;
    }
}

public class MyDoulinklist {
    public Node head;       //用来标记链表的头
    public Node tail;       //用来标记链表的尾
    //头插法  分第一次插和非第一次插
    public void addFirst(int data){
        Node node = new Node(data);
        //第一次插
        if (this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            //非第一次插
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    //尾插法  同样要分是不是第一次插
    public void addLast(int data){
        Node node = new Node(data);
        //第一次插
        if (this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            //非第一次插
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        checkIndex(index);
        Node node = new Node(data);
        if (index == 0){                //index等于0，相当于头插
            addFirst(data);
            return;
        }
        if (index == this.size()){      //index等于长度，相当于尾插
            addLast(data);
            return;
        }
        if (this.head == null){         //第一次插入
            this.head = node;
            this.tail = node;
        }else{
            Node cur = searchIndex(index);
            node.next = cur;
            node.prev = cur.prev;
            cur.prev.next = node;
            cur.prev = node;
        }
    }
    //方法：查找index的合法性
    private  void checkIndex(int index){
        if (index < 0 || index > size()){
            throw new RuntimeException("index不合法！");
        }
    }
    //方法：找到下标为index的节点
    private Node searchIndex(int index){
        Node cur = this.head;
        while (index != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while (cur != null){
            if (cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        Node cur = this.head;
        while (cur != null ){
            if (cur.data == key){
                if (cur == this.head){
                    this.head = this.head.next; //删除的是头结点
                    this.head.prev = null;
                    return;                     //删掉就return；
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next!= null){       //删除的是中间节点
                        cur.next.prev = cur.prev;
                        return;
                    }else{                      //删除的是尾巴节点
                        this.tail = cur.prev;
                        return;
                    }
                }
            }
            cur = cur.next;
        }
    }
    //方法 :

    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node cur = this.head;
        while (cur != null ){
            if (cur.data == key){
                if (cur == this.head){
                    this.head = this.head.next; //删除的是头结点
                    if (this.head!= null){      //如果链表删除后全部为空了。
                        this.head.prev = null;
                    }

                }else {
                    cur.prev.next = cur.next;
                    if (cur.next!= null){       //删除的是中间节点
                        cur.next.prev = cur.prev;
                    }else{                      //删除的是尾巴节点
                        this.tail = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
    //得到单链表的长度
    public int size(){
        Node cur = this.head;
        int count = 0;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }
    //打印双向链表
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //请空链表  不能像单链表那样直接让头节点为空，因为还有后置指向他，必须一个一个节点释放。
    public void clear(){
        while (this.head != null){
            Node cur = this.head.next;
            this.head.prev = null;
            this.head.next = null;
            head = cur;
        }
        this.tail = null;       //执行完后包括head在内的所有节点都为空了，
                                // 但是最后一个空节点还有tail在引用他，所以要将tail也置为空。
    }



}
