package com.ClassObj02;

/**
 * Remarks: 封装
 *              用private来修饰 属性 或者 方法
 *          为什么要进行封装呢？
 *              封装后只能在类内来使用该属性或者方法，
 *
 *          在无特殊要求的情况下，类的属性请设计成私有的，要体现出封装
 * Author:panlai
 * :Date:2021/4/1
 */

class Student{
    //private修饰限定只能在类当中访问
    private String Myname;
    public int age;


    public String getMyname() {
        return Myname;
    }

    public void setMyname(String myname) {
        Myname = myname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //定义一个公开的接口来取私有的属性  ideal自动生成get和set方法：alt+insert键
    /*public String getName(){
        return Myname;
    }
    //定义一个公开的接口来修改对象的私有属性
    public void setName(String Myname){   //这里的参数不能写Myname，因为局部参数优先，系统不会修改私有属性，而是修改方法本身的局部变量，2=2；
       // Myname = name;                  //想解决上面的问题，可以使用this.Myname = Myname。this的作用是，当前对象的引用。
        this.Myname = Myname;
    }*/
    public void func1(){
        System.out.println("func1");
    }
    public  void show(){
        System.out.println("我叫" + Myname + "，今年" + age + " 岁");
    }
    //重写了 Object类的toString()方法
    //Object 是所有类的父类
    @Override       //注解，这个注解是表示这个方法是重写的
    public String toString() {
        return "Student{" +
                "Myname='" + Myname + '\'' +
                ", age=" + age +
                '}';
    }
}
//以上，是类的实现着写的代码，

//以下是类的调用者
public class ClassObj02 {

    public static void main(String[] args) {
        Student stu = new Student();
        stu.setMyname("pryor");
        String name = stu.getMyname();
        System.out.println(name);
        //如果没有重写toString方法，返回的是对象stu的哈希地址
        System.out.println(stu);           //这里为什么会调用toString方法呢？因为print底层就是调用的toString，


    }
}
