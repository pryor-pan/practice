package com.classobj04.Finalkey;

/**
 * Remarks: final关键字
 *              被final关键字所修饰的属性和变量无法被修改
 *              被final修饰的类无法被继承   这样的类叫做密封类。
 *              被final修饰的变量无法被修改  叫做常量
 *              被final修饰的方法叫做密封方法。也不能被修改，
 *
 *
 * Author:panlai
 * :Date:2021/4/12
 */
final class Person{         //被final修饰的类无法被继承   这样的类叫做密封类。
    protected String name;
    protected int age;

    protected void sleep(){
        System.out.println(this.name + "sleep()");
    }

}
//class Chinese extends Person{}        //一个类被final修饰就无法被继承了

public class Finalkey {
    public static void main(String[] args) {
        final int a = 10;               //被final修饰的变量叫做常量。
        //a = 20;                       //被final修饰的变量无法被修改
    }
}
