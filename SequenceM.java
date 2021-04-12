package com.sequence;

/**
 * Remarks: 顺序表
 *              顺序表是用一段物理地址连续的存储单元依次存储数据元素的线性结构，
 *              一般情况下采用 数组 存储，在数祖上完成数据的增删改查
 *          顺序表可分为：
 *                  静态顺序表：使用定长度的数组存储   适用于确定知道需要存多少数据的场景
 *                  动态顺序表：使用动态开辟的数组存储
 *          顺序表的空间利用率低
 *
 *
 *          数据结构：数据 + 结构 组织数据的方式
 *          如何学好数据结构：
 *              1、多写代码
 *              2、多思考，多画图
 *              3、多做数据结构的习题
 *              目的：
 *              1、提高代码量
 *              2、练习类和对象
 *              3、提高思考问题的方式。
 *              注意事项：数据结构的代码；逻辑性很强。
 * Author:panlai
 * :Date:2021/4/3
 */
public class SequenceM {

    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        //往顺序表里添加元素 ，
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.add(i,i);
        }
        arrayList.display();                                //打印顺序表，现在表是满的
        arrayList.add(10,11);                     //尝试往满的表里插入元素，看是否会扩容
        arrayList.display();                                //打印顺序表观察是否进行了扩容
        System.out.println("===========包含和查找============");
        System.out.println(arrayList.contains(7));          //判断是否包含7
        System.out.println(arrayList.search(7));     //找7，返回下标
        System.out.println("===============删除===============");
        arrayList.remove(0);
        arrayList.display();
        System.out.println("===============清空===============");
        arrayList.clear();
        arrayList.display();
        System.out.println("===============插入===============");
        arrayList.add(0,5);
        arrayList.add(1,4);
        arrayList.add(2,3);
        arrayList.add(3,2);
        arrayList.display();
        System.out.println("=======获取/设置pos值为value=======");
        System.out.println(arrayList.getPos(1));
        arrayList.setPos(1,10);
        arrayList.display();

    }


}
