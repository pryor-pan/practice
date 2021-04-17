package com.classobj04.Classextends;

/**
 * Remarks: 继承 是 is a 的关系
 *              1、在java中，只存在单继承，子类只能继承一个父类
 *              2、子类继承了父类所有方法和属性(构造方法除外)，包括私有的属性，但是私有的属性在子类中无法被访问
 *              3、在子类构造的时候，要先帮助父类进行构造
 *              4、访问权限限定符：
 *                      public：所有的地方都能访问，不同包之中的非子类
 *                      private：只有在同一个类中才能访问
 *                    * protected：可以再不同的包中的子类中访问  （主要体现在继承上 ）
 *                      什么都不写default：默认访问权限：包访问权限，只能在同一个包中访问
 *              5、面试题：请说出this关键字和super关键字的区别：
 *                         this代表当前对象的引用
 *                            this()：调用本类其他的构造方法，
 *                             this.data()：访问当前类中的成员属性
 *                             this.func()：调用本类的其他的成员方法
 *
 *                         super：代表父类对象的引用
 *                             super()：调用父类的构造方法
 *                             super.data()：访问父类的成员属性
 *                             super.func()：访问父类的成员方法
 *              6、继承可以多层继承，父类的父类，爷爷类。但是一般情况下，不希望超过三层的继承，否则老板找你谈话。
 *
 * Author:panlai
 * :Date:2021/4/12
 */
class Animal{               //父类
    protected String name;

    public Animal(String name){         //父类的构造方法
        this.name = name;
    }

    public void eat(){
        System.out.println(this.name + "::eat()");
    }
    private   void sleep(){
        System.out.println(this.name + "::sleep()");
    }
}

class Cat extends Animal{           //子类继承了父类
    public Cat(String name){        //在子类构造的时候，要先帮助父类进行构造
        super(name);                //（显示调用）必须放在构造方法的第一行
    }
/*    public  String name;
    public void eat(){
        System.out.println("cat:::eat()" );
    }*/
}
class ChineseGardenCat extends Cat{
    public ChineseGardenCat(String name){
        super(name);            //这里调用父类cat的构造方法，然后父类cat又调用cat的父类animal的构造方法
    }
}

class Bird extends Animal{
    public Bird(String name ){
        super(name);
    }

    public void sleep(){
        System.out.println(this.name + "::sleep()");
    }

}


public class Classextends {
    public static void main(String[] args) {
        Cat cat = new Cat("mimi");
        cat.eat();                  //通过子类可以访问父类中的对象
        //cat.sleep();              //子类无法访问父类的私有方法

        Bird bird = new Bird("bage");
        bird.sleep();


        ChineseGardenCat chineseGardenCat = new ChineseGardenCat("HAHA");
        chineseGardenCat.eat();     //三层继承
    }

}
