package com.testdemo;

import java.util.Scanner;

/**
 * Remarks: 自定义异常实现登录
 *              实现一个简单的控制台版用户登陆程序, 程序启动提示用户输入用户名密码.
 *              如果用户名密码出错, 使用自定义异常的方式来处理
 * Author:panlai
 * :Date:2021/4/24
 */
class MyException extends RuntimeException{
    public MyException(String message){
        super(message);
    }
}
public class LoginTest {

    public static void main(String[] args) {
        String user = "pryor";
        String psw = "123456";
        Scanner sc = new Scanner(System.in);
        String user1 = sc.nextLine();
        String psw1 = sc.nextLine();
        try {

            if (!user1.equals(user)){
                throw new MyException("用户名错误");
            }
            if (!psw.equals(psw1)){
                throw new MyException("密码错误");
            }
        }catch (MyException e){
            e.printStackTrace();
        }
    }
}
