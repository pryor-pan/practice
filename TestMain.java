package Homework;

/**
 * Remarks: main方法所在的测试类
 * Author:panlai
 * :Date:2021/4/3
 */
public class TestMain {
    public static void main(String[] args) {
        Calculator  calculator = new Calculator();
        calculator.setNum1(5);
        calculator.setNum2(6);

        System.out.println(calculator.sum());
        System.out.println(calculator.sub());
        System.out.println(calculator.mult());
        System.out.println(calculator.div());


    }

}
