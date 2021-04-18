package com.classobj04.Classextends;

/**
 * Remarks:
 * Author:panlai
 * :Date:2021/4/17
 */


class Base{
    public int a = 1;
}

class Deriev extends Base{
    public  int a = 2;
    public  int b = 3;


    public int getFather(){
        return super.a;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Deriev deriev = new Deriev();
        System.out.println(deriev.a);
        System.out.println("========================");
        Base base = new Base();             //向上转型了
        System.out.println(base.a);
        System.out.println("=======================");
        Deriev deriev1 = new Deriev();
        System.out.println(deriev1.getFather());    //调用一个super方法去取父类的变量。

    }

}
