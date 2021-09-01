package test;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 传入num1数字字符串与num2数字字符串，返回两个字符串数字的乘积。
     * @param num1 string字符串 数字字符串1
     * @param num2 string字符串 数字字符串2
     * @return string字符串
     */
    public String multiply (String num1, String num2) {
        // write code here
        boolean flg1 = true;
        String n1,n2;
        if(num1.charAt(0) == '-'){
            flg1 = false;
            n1 = num1.replace("-","");
        }
        boolean flg2 = true;
        if(num2.charAt(0) == '-'){
            flg2 = false;
            n2 = num2.replace("-","");
        }
        long a = Long.parseLong(num1);
        long b = Long.parseLong(num2);
        long c = a * b;
        StringBuffer sb;
        if (flg1&&flg2 || !flg1 && !flg2){
            sb = new StringBuffer();
            sb.append(c);
        }else {
            sb = new StringBuffer("-");
            sb.append(c);
        }
        String result = sb.toString();
        String ans = num1 + " x " + num2 + " = " + result;
        return ans;

    }
}