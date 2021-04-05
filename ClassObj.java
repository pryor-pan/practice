package com.ClassObj01;

/**
 * Remarks: 类和对象的学习
 *              1、什么是类？
 *                  类是一种自定义类型，是一种模板，通过一个类可以产生多个对象，（月饼模子）
 *                  一个类可以产生多个对象
 *              2、什么是对象？
 *                  对象是一个实体，将类的一个实体化，月饼！
 *              3、什么是面向对象？
 *                  找对象，创对象，使用对象
 *              4、
 *
 *              question:
 *              OP(面向对象)语言的三大特征：继承、封装、多态
 *
 * Author:panlai
 * :Date:2021/4/1
 */
/**
 *@Describle: 类的定义
 *               类包含两部分，一个是成员属性，一个是成员方法
 *               访问修饰限定符，
 *                      public：公有的
 *                      private：私有的
 *                      protected：受保护的
 *                      什么都不写：默认权限->包访问权限
 *
 *
 *
 *@Author: Pryor_Pan
 *@Date: 2021/04/01
*/
class Person{
//字段,成员变量（定义在类内方法外的变量） filed 可以初始化也可以不初始化。
    //实例成员变量：在对象里边
    //实例成员变量没有初始化，默认值为对应的0值，引用类型默认为mull，简单类型默认为0，
    //float为0，double为0.00，char类型默认为：'\u0000',boolean为false
    public String name = "pryor";
    public int age;
    //静态成员变量  如不初始化，和实例成员变量一样默认为对应的0值
    public static int size = 10;


//方法；行为；method
    public void eat(){
        int a = 10;             //在方法内定义的变量叫局部变量
        System.out.println("eat");

        sleep();                       //在实例方法内部可以访问静态方法
    }
    public  void show(){
        System.out.println("我叫" + name + "，今年" + age + " 岁");
    }
    public static void sleep(){       //在静态方法内部，不能够访问非静态的数据成员
        //System.out.println(name);   //报错
        System.out.println("sleep");
    }


}

public class ClassObj {
    public static void main0(String[] args) {
        //实例化对象
        Person per = new Person();           //通过关键字实例化一个对象，new一个对象
        //如何访问对象当中的实例成员变量？
        //操作符：点号.  使用方法：对象的引用 点号 成员变量
        System.out.println(per.name);
        System.out.println(per.age);

    }
    public static void main1(String[] args) {
        //实例化多个对象，一个类可以创建多个对象
        Person person1 = new Person();      //每new一个对象，都会在堆上开辟一部分空间来存放他的实例成员变量，但是静态成员变量只有一份
        Person person2 = new Person();
        Person person3 = new Person();
    }

    public static void main(String[] args) {
        //如何访问静态的数据成员？
        Person per = new Person();
        System.out.println(per.name);
        System.out.println(per.size);           //直接访问静态成员变量会报黄色警告，因为静态成员变量不属于对象，他存在方法区中，他属于Person类
        System.out.println(Person.size);        //如需要访问静态成员变量，不需要对象，直接类名 点号 静态成员变量

        //实例方法的调用
        per.eat();                              //成员方法的调用也是用对象来调用，但他不属于这个对象
        //静态成员方法的调用，也是直接用类名访问，不需要对象
        Person.sleep();
        per.show();

    }

}
