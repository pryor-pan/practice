package com.classobj04.Combination;

/**
 * Remarks:     组合  a part of    has a的关系
 *          组合也是一种表示类之间关系 的方式，也能达到代码重用的效果
 *          组合并没有特殊的关键字，仅仅是将一个类的实例作为另一个类的字段，
 * Author:panlai
 * :Date:2021/4/12
 */
class Money{

}


class Student{
    public  Money money = new Money();      //student和money也是组合的关系。
    private int id;
    private String name;
}
class Teacher{
    private int id;
    private String name;
}

class School{           //学校包含了老师和学生，他们是has a 的关系
    public Student[] students;
    public Teacher[] teachers;
}
public class Combination {
}
