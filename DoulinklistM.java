package com.doulinklist;

/**
 * Remarks: 双向链表的测试类
 * Author:panlai
 * :Date:2021/4/11
 */
public class DoulinklistM {
    public static void main(String[] args) {
        MyDoulinklist myDoulinklist = new MyDoulinklist();
        myDoulinklist.addFirst(2);
        myDoulinklist.addFirst(2);
        myDoulinklist.addFirst(2);
        System.out.println("==============头插法==============");
        myDoulinklist.addFirst(2);
        myDoulinklist.display();                //打印双向链表

        System.out.println("==============尾插法==============");
        myDoulinklist.addLast(2);          //尾插法
        myDoulinklist.display();
        System.out.println("==============任意位置插入==============");
        myDoulinklist.addIndex(2,2);
        myDoulinklist.display();
        System.out.println("==============查找是否包含==============");
        System.out.println(myDoulinklist.contains(3));
        System.out.println("==============删除第一次值为key的节点==============");
        myDoulinklist.remove(2);
        myDoulinklist.display();
        System.out.println("==============删除所有值为key的节点==============");
        myDoulinklist.removeAllKey(2);
        myDoulinklist.display();
        System.out.println("==============返回链表长度==============");
        System.out.println(myDoulinklist.size());


    }
}
