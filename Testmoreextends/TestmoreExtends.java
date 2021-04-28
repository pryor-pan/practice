package com.interfacetest.Testmoreextends;

/**
 * Remarks: 多继承
 *              如果把run方法swimming方法fly方法都写在animal类中是不合适的，因为一旦有子类继承了他
 *              那么animal类中的这些方法也会被继承过去，但是对于cat来说他只会run，swimming和fly他用不上，
 *              所以在类外定义几个接口，谁需要重写。
 * Author:panlai
 * :Date:2021/4/13
 */
//动物类
class Animal{
    protected  String name;
    public Animal(String name){
        this.name = name;
    }
}
//猫类
//1、一个类可以继承一个普通类/抽象类，并且可以同时实现多个接口 注意：extends和implements的位置不能换
class Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }
    @Override
    public void run() {                 //实现时要重写原来的方法
        System.out.println(this.name + "正在用四条腿跑");
    }
}
//鱼类
class Fish extends Animal implements ISwimming {
    public Fish(String name) {
        super(name);
    }
    @Override
    public void swim() {
        System.out.println(this.name + "正在用尾巴游泳");
    }
}
//青蛙类
class Frog extends Animal implements IRunning, ISwimming {          //青蛙可以游泳也可以跑，所以可以实现两个接口
    public Frog(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name + "正在往前跳");
    }
    @Override
    public void swim() {
        System.out.println(this.name + "正在蹬腿游泳");
    }
}
//鸭子类
class Duck extends Animal implements IRunning, ISwimming, IFlying {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name + "正在用翅膀飞");
    }

    @Override
    public void run() {
        System.out.println(this.name + "正在用两条腿跑");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "正在漂在水上");
    }
}
class Robot implements IRunning{
    @Override
    public void run() {
        System.out.println("我是机器人，我在用腿跑");
    }
}

public class TestmoreExtends {
    //方法：根据对象调用run接口方法
    public static void walk(IRunning iRunning){
        iRunning.run();
    }
    //方法：根据对象调用swimming接口方法
    public static void lswim(ISwimming iSwimming){
        iSwimming.swim();
    }

    public static void main(String[] args) {
        IRunning iRunning = new Robot();
        walk(iRunning);
        IRunning iRunning1 = new Frog("青青");
        walk(iRunning1);
        ISwimming iSwimming = new Frog("青青二号");
        lswim(iSwimming);

    }
}
