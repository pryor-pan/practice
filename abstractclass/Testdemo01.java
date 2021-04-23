package com.abstractclass;

/**
 * Remarks: 抽象类
 *              1、抽象方法：如果一个方法被abstract修饰，那么这个方法就是抽象方法，抽象方法可以没有具体的实现。
 *              2、包含抽象方法的类叫做抽象类。
 *              3、抽象类存在的作用就是为了被继承。
 *              注意：
 *              1、抽象类不能被实例化   不能Shape shape = new Shape();
 *              2、类内的数据成员和普通类没有区别，惟一的区别就是他这个类不能被实例化
 *              3、抽象类存在的意义就是用来被继承的。
 *              4、如果一个普通类继承了这个抽象类，那么这个类必须重写抽象类中的抽象方法。而且是所有父类的抽象方法，父类，爷爷类。
 *              5、如果是抽象类继承了抽象类，那么就不用重写抽象方法了，
 *              6、抽象类或者抽象方法一定是不能被final修饰的，因为要实现抽象要重写，final修饰不能被重写，尬住了
 *              7、抽象方法也不能是private的也不能被final修饰，因为抽象方法要被重写，重写不能是private
 *              8、抽象类中也可以包含其他的普通方法。
 *
 *
 *
 * Author:panlai
 * :Date:2021/4/13
 */
abstract class Shape{
    /*public int age;           //类内的数据成员和普通类没有区别，惟一的区别就是他这个类不能被实例化
    private int a;
    public void func();*/
    public abstract void draw();

}
class Cycle extends Shape {
    @Override               //如果一个类继承了这个抽象类，那么这个类必须重写抽象类中的抽象方法。
    public void draw() {
        System.out.println("画一个○");
    }
}
class Rect extends Shape {
    @Override               //父类的draw方法被重写了
    public void draw() {
        System.out.println("画一个♢");
    }
}
abstract class Triangle extends Shape {     //如果是抽象类继承了抽象类，那么就不用重写抽象方法了

}
public class Testdemo01 {
    //方法：根据对象类型画形状
    public static void drawMap(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {
        //Shape shape = new Shape();        //抽象类不能被实例化
        Shape shape1 = new Cycle();         //可以new子类对象
        Shape shape2 = new Rect();
        drawMap(shape1);                    //也能发生向上转型，多态。
        drawMap(shape2);

    }
}
