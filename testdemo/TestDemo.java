package com.testdemo;

/**
 * Remarks: string的练习自测
 * Author:panlai
 * :Date:2021/4/23
 */
public class TestDemo {

    public static String func(String s1,String s2){
        StringBuilder sb = new StringBuilder();
        sb = sb.append(s1);
        sb = sb.append(s2);
        return sb.toString();
    }


    public static void main(String[] args) {
        String string1 = "abc";
        String string2 = "def";
        System.out.println(func(string1, string2));
    }
    public static void main1(String[] args) {
        String string = "abcdef";
//        System.out.println(string.contains("abc"));
        System.out.println(string.substring(0, 3));
    }
}
