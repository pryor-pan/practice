package com.ClassObj03;

/**
 * Remarks: 构造方法：他的方法名是和他的类名相同的，且没有返回值
 *              构造方法的作用：构造对象用的
 *
 *              构造方法也能够自动生成，alt + inser键，
 *
 *              question：
 *                  同学，this关键字代表对象，这句话是不是正确的？为什么？
 *                      Anwser:不正确，this代表当前对象的引用，不代表该对象
 *                              因为，对象需要通过构造方法来创建，但是在构造方法内部，需要使用this
 *                              所以this不可能代表对象，因为对象要在使用this之后才能被创建，
 *              一个对象的产生分为几步？他是如何产生的？
 *              1、为对象分配内存
 *              2、调用合适的构造方法 -->意味着构造方法不止一个
 *                  当没有提供构造方法的时候，那么编译器会自动提供一个不带参数的构造方法
 *                  当你提供了构造方法，编译器就不会自动生成一个构造方法了，
 * Author:panlai
 * :Date:2021/4/3
 */

class Person{

    private String name;
    private int age;
    private static int count;


    //不带参数的构造方法
    public Person(){
        //this()调用自己的构造方法
        this("caocao",18);     //此处调用了下面那个带参数的构造方法，执行到这里转去执行下面那个带参数的方法了,而且只能写在第一行
        //this("zahnfgei");               this()只能调用一个构造方法
        System.out.println("Person<init>");
    }
    //带两个参数的构造方法（重载）
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person<String int>");
    }
    //只带一个参数的构造方法（重载）
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //this的作用  （要习惯使用this）
    //this():调用自己的构造方法  注意：只能写在构造方法里边，而且，只能写在第一行
    //this.data:调用当前对象的属性
    //this.func():调用当前对象的方法
    public void eat(){
        System.out.println(this.getName());
        System.out.println(this.age);

    }

    /**
     *@Describle: 代码块
     *              （实例/构造）代码块：实例代码块一般用于初始化实例成员变量
     *              静态代码块：静态代码块一般用于初始化化静态成员属性
     *                  静态的内容只会被执行一次，且是最早被执行的！！！！！(如果两个都是静态的，那久按顺序来，谁写在上面谁先执行)
     *                  如果静态方法里面访问了实例成员变量，那么这个实例成员变量是依赖于对象的，但是静态方法不依赖。
     *              本地代码块：制作了解，不会用的
     *@Author: Pryor_Pan
     *@Date: 2021/04/03
     */
    //实例代码块，
    {
        this.name = "zhangfei";
        count = 99;     //可以给静态变量赋值
        System.out.println("实例代码块....");
    }
    //静态代码块
    static {
        //this.name = "zhangfei";   不能访问非静态的数据成员
        count = 99;     //只能访问静态的数据成员
        System.out.println("静态代码块...");
    }
    //静态成员方法
    public static void func(){
        count = 99;     //只能访问静态的数据成员
        //this.name = "caocao";     不能访问非静态的数据成员
    }
    /**
     *@Describle: 匿名对象
     *              匿名只是表示没有名字的对象
     *              没有引用的对象成为匿名对象
     *              匿名对象只能在创建对象时使用
     *              如果一个对象只是使用一次，后面不需要使用了可以考虑使用匿名对象
     *@Author: Pryor_Pan
     *@Date: 2021/04/03
    */


}
public class ClassObj03 {
    public static void main1(String[] args) {
        Person person = new Person();                          //调用不带参数的构造方法
        System.out.println(person);
        Person person1 = new Person("bit",19);      //调用带参数的构造方法
        System.out.println(person1);
    }


    public static void main2(String[] args) {
        Person person1 = new Person();      //静态代码块总是第一个执行，
        System.out.println("==========================");
        Person person2 = new Person();      //第二次执行的时候就看不到静态代码块了，因为静态只会执行一次
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.eat();


        new Person().eat();     //匿名对象只能在创建对象时使用
        new Person().getName(); //而且只能使用一次
    }


}
