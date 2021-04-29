package com.testdemo;

/**
 * Remarks:
 * Author:panlai
 * :Date:2021/4/24
 */
public class TestDemo02 {
    public static String func(int n, String str){

        int i = 0;
        int j = n;
        while(i<j){
            char tmp = str.charAt(i);
            str.replace(str.charAt(i),str.charAt(j));
            str.replace(str.charAt(j),tmp);
            i++;
            j--;
        }
        i = n-1;
        j = str.length()-1;
        while(j<j){
            char tmp = str.charAt(i);
            str.replace(str.charAt(i),str.charAt(j));
            str.replace(str.charAt(j),tmp);
            i++;
            j--;
        }
        i = 0;
        j = str.length()-1;
        while(j<j){
            char tmp = str.charAt(i);
            str.replace(str.charAt(i),str.charAt(j));
            str.replace(str.charAt(j),tmp);
            i++;
            j--;
        }
        return str;

    }

    public static void main(String[] args) {
        String str = "abcdefg";
        int n = 3;
        System.out.println(func(n,str));
    }
}
