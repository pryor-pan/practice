package Homework;

/**
 * Remarks: 编写一个类Calculator，有两个属性num1，num2，这两个数据的值，不能再定义的同时初始化
 *          最后实现加减乘除四种运算，
 * Author:panlai
 * :Date:2021/4/3
 */
public class Calculator {
    private double num1;
    private double num2;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double sum() {
        return this.num1 + this.num2;
    }

    public double sub() {
        return this.num1 - this.num2;
    }

    public double mult() {
        return this.num1 * this.num2;
    }

    public double div() {
        return this.num1 / this.num2;
    }

}
