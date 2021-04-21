package com.classobj04.Polymorphic;

import com.sun.org.apache.xerces.internal.dom.AttrNSImpl;

/**
 * Remarks: 多态
 *          1、向上转型
 *          2、发生向上转型的时机：直接赋值，传参，返回值
 *
 * Author:panlai
 * :Date:2021/4/12
 */
class Animal{               //父类
    protected String name;

    public Animal(String name){         //父类的构造方法
        this.name = name;
        System.out.println("animal(string)");
    }

    public void eat(){
        System.out.println(this.name + "正在吃!");
    }

}

class Cat extends Animal {          //cat继承于animal
    public int count = 99;
                                     //继承关系中，父类中所有的东西都不用重复写了，
    public Cat(String name){
        super(name);
        System.out.println("cat（string）");
    }
    public void eat(){          //重写了父类的方法
        System.out.println(this.name + "的示范法cat::eat()");
    }
}

class Bird extends Animal {
    public Bird(String name ){
        super(name);
    }

    public void fly(){
        System.out.println(this.name + "::fly()");
    }

}
public class Polymorphic {
    /**
     *@Describle: 向上转型
     *@Author: Pryor_Pan
     *@Date: 2021/04/12
    */
    public static void main1(String[] args) {
        Animal animal = new Animal("豆豆");
        Cat cat = new Cat("咪咪");
    }
    //向上转型 直接赋值  向上转型之后，父类引用只能访问父类自己的方法或属性，
    public static void main2(String[] args) {
        Animal animal = new Cat("咪咪");  //向上转型：将子类对象赋值给父类引用
        animal.eat();                          //父类引用可以访问父类属性和方法
        //animal.count;                        //父类引用不能访问子类属性和方法
    }
    //向上转型 传参
    public static void main3(String[] args) {
        Cat cat = new Cat("mimi");
        func(cat);              //传的值是cat，但方法是父类对象，就向上转型了
    }
    public static  void func(Animal animal){
        animal.eat();
    }
    //向上转型 返回值
    public static void main4(String[] args) {
        Animal animal = func();             //调用返回值为父类的方法，也会发生向上转型
    }
    public static Animal func(){
        /*Cat cat = new Cat("咪咪");
        return cat;*/
        return new Cat("咪咪");
    }
    /**
     *@Describle: 多态
     *              重写override：
     *                  在不同的类中(继承关系中)，方法名相同，参数列表相同，返回值相同（如果返回值构成协变类型，也可以发生重写），
     *                  关于重写的注意事项：
     *                          1、需要重写的方法是不能被final修饰的，被final修饰后，他就是密封方法了，不能被修改
     *                          2、被重写的方法，的访问限定修饰符不能是私有的
     *                          3、子类的被重写的方法，子类的访问修饰限定要大于父类的访问修饰限定
     *                          4、被static修饰的方法是不能被重写的。
     *              重载overload：
     *                  在同一个类中：方法名相同 参数列表不同：参数个数类型，返回值不作要求
     *             * 运行时绑定(运行时绑定)：
     *                  父类引用 引用子类对象，同时通过父类引用调用同名的覆盖方法，此时就会发生运行时绑定
     *                  编译的时候还是原来的对象编译，运行时就变了
     *               发生动态绑定的条件：
     *                      1、一定要发生向上转型（父类引用引用子类对象）
     *                      2、父类和子类有同名的重写/覆盖//复写方法
     *                      3、最后 通过父类引用来调用父类和子类的这个同名的覆盖方法，此时就会发生动态绑定，也叫运行时绑定。
     *            坑：在构造对象的时候调用重写的方法时也会发生运行时绑定，在构造方法当中可以发生动态绑定。
     *@Author: Pryor_Pan
     *@Date: 2021/04/12
    */
    public static void main5(String[] args) {
        Animal animal = new Cat("豆豆");
        animal.eat();           //父类引用引用了同名的福海方法，发生运行时绑定
    }
    /**
     *@Describle: 向下转型
     *              注意：向下转型非常不安全，很少会使用想法转型
     *@Author: Pryor_Pan
     *@Date: 2021/04/12
    */
    public static void main6(String[] args) {
        Animal animal = new Bird("八哥");
        animal.eat();
        //向下转型--->父类的引用 赋值给了子类 ，进行强转们就是向下转型
        Bird  bird = (Bird) animal;        //强转
        bird.fly();
    }
    /**
     *@Describle: 不安全的向下转型
     *@Author: Pryor_Pan
     *@Date: 2021/04/12
    */
    public static void main(String[] args) {
        Animal animal = new Cat("，咪咪");
        //不安全的向下转型
        Bird bird = (Bird)animal;       //强转了，把猫强转为bird，运行时会发生类型转换异常
        bird.fly();

        //正确的处理方式
        if (animal instanceof Bird){    //A instanceof B 判断A是不是B的一个实例
            Bird bird1 = (Bird)animal;
            bird1.fly();
        }

    }


}
