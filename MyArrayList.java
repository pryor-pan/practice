package com.sequence;

import java.util.Arrays;

/**
 * Remarks: 一个顺序表的实现
 * Author:panlai
 * :Date:2021/4/4
 */


public class MyArrayList {              //定义一个顺序表
    //属性一般设为私有，这里设为公有是为了好理解
    private int[] elem;              //是一个存放int类型的数组
    private int usedSize;            //用来记录有效数字的长度
    private int capacity = 10;       //初始的开辟数组的长度

    //构造方法
    public MyArrayList() {
        this.elem = new int[capacity];  //构造方法，定义一个长度为初始值得数组
        this.usedSize = 0;              //因为是初始数组，所以没有存放东西，有效长度为0
    }
    //判断顺序表是不是满的
    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }
    //判断顺序表是不是空的
    private boolean isEmpty(){
        return this.usedSize == 0;
    }
    //检查pos位置是否合法
    private void checkPos(int pos){
        if (pos<0 || pos > this.usedSize){   //插入前，先判断插入的位置是否合法，小于零或者大于有效长度都不合法
            throw new RuntimeException("pos位置不合法！");
        }
    }
    //接口实现
    //1、打印顺序表
    public void display(){
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
    //2、在pos位置插入元素
    public void add(int pos,int data){
        if (isFull()){                  //插入时先判断数组满不满，调用了类私有的isFull()方法
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);    //如果满了，则需要进行二倍扩容，长度变为原来的二倍
        }
        //如果不满，进行插入操作
        checkPos(pos);               //插入前，先判断插入的位置是否合法，小于零或者大于有效长度都不合法

        int i = this.usedSize - 1;      //从有效长度位置开始，
        while (pos <= i) {              //依次向前遍历
            this.elem[i + 1] = this.elem[i];    //往后挪元素
            i = i - 1;
        }
        this.elem[pos] = data;          //挪完后把pos位置更改为所要插入的元素值
        this.usedSize++;
    }
    //3、判定是否包含某个元素
    public boolean contains(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    //4、查找某个元素对应位置
    public int search(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    //5、获取pos位置的元素
    public int getPos(int pos){
        if (isEmpty()){                         //1、首先判断顺序表是否为空
            //return -1;
            throw new RuntimeException("顺序表为空！！");     //手动抛出异常，
        }
        if (pos<0 || pos >= this.usedSize){      //2、其次判断pos的合法性,注意usedSize是长度，总比最高下标多1，所以这里不能取到usedSize
            throw new RuntimeException("pos位置不合法！");
        }

        return this.elem[pos];
    }
    //6、给pos位置的元素设为value
    public void setPos(int pos,int value){
        checkPos(pos);
        this.elem[pos] = value;
    }

    //7、删除第一次出现的关键字key
    public void remove(int toRemove){
        if(this.contains(toRemove)){
            for (int i = this.search(toRemove); i < this.usedSize-1 ; i++) {    //i最多走到usedSize-2的位置。
                this.elem[i] = this.elem[i+1];
            }
            this.usedSize--;
        }
        else{
            throw new RuntimeException("没有要删除的元素！");
        }
    }
    //8、获取顺序表长度
    public int  size(){
        return this.elem.length;
    }
    //9、清空顺序表
    public void clear(){
        this.usedSize = 0;      //直接把有效长度变成0，不影响，因为对表的所有操作都要在有效长度内执行
    }





}
