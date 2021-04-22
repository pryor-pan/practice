package com.classobj04.Polymorphic;

/**
 * Remarks: 多态02
 *             1、父类的引用  引用子类对象
 *             2、父类和子类有同名的覆盖方法
 *             3、通过父类引用代用这个重写方法的时候。  多态，调用一个方法会发生多种不同的形态
 *             4、
 * Author:panlai
 * :Date:2021/4/13
 */

class Shape{
    public void draw(){

    }
}
class Cycle extends Shape{
    @Override               //父类的draw方法被重写了
    public void draw() {
        System.out.println("画一个○");
    }
}
class React extends Shape{
    @Override               //父类的draw方法被重写了
    public void draw() {
        System.out.println("画一个♢");
    }
}
class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("画一个△");
    }
}
public class Polymorphic02 {
    //方法：根据对象来画形状
    public static void drawMap(Shape shape){    //这里传参的是父类
        shape.draw();                   //内部也不知道引用的是哪个对象 shape引用谁就调用谁
    }
    public static void main(String[] args) {
        Shape shape1 = new Cycle();
        Shape shape2 = new React();
        Shape shape3 = new Triangle();
        drawMap(shape1);
        drawMap(shape2);
        drawMap(shape3);

    }
}
