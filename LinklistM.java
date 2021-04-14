package com.linklist;

/**
 * Remarks: 单链表
 *             由   数值域 + 下一个节点的引用
 *             单链表由节点组成的，
 *             不带头结点的单项非循环链表，
 *             带头结点的单项非循环链表，专门有一个节点指向第一个节点，他不属于链表
 *
 *
 *
 *
 *
 *          questtion：顺序表和链表有什么区别？
 *                     顺序表的空间利用率低
 * Author:panlai
 * :Date:2021/4/5
 */
public class LinklistM {
    public static void main(String[] args) {
        MyLinkedList  linkedList = new MyLinkedList();
        System.out.println("===============头插==============");
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);         //头插
        }
        linkedList.display();
        System.out.println("\n===============尾插==============");
        for (int i = 0; i < 5 ; i++) {
            linkedList.addLast(i);          //尾插
        }
        linkedList.display();
        System.out.println("\n===========判断key在不在==========");
        System.out.println(linkedList.contains(4));
        System.out.println(linkedList.contains(10));
        System.out.println("===========返回单链表长度==========");
        System.out.println(linkedList.size());
        System.out.println("===========在任意位置插入==========");
        linkedList.addIndex(3,10);
        linkedList.display();
        System.out.println("\n========删除值为key的节点 ========");
        linkedList.remove(10);
        linkedList.display();
        System.out.println("\n=====删除所有值为key的节点 ========");
        linkedList.removeAllkey(0);
        linkedList.display();
        System.out.println("\n=============清空链表============");
        linkedList.clear();
        linkedList.display();
    }
}
