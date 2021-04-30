package com.stringtestdemo.string01;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Remarks: String part1
 *              双引号 引起来的叫做字符串常量
 *              同样的字符串，在常量池中只能存一个
 *              如果有那么返回现在的地址给引用，如果没有，则存放进去，并且返回引用。
 *
 *              equals方法最好是  已知的.equals(未知的)，避免空指针异常。
 *              inter方法  （入池方法）
 *              inter方法inter方法就是查看常量池有没有当前的对象，如果有直接把地址给前面的对象
 *
 *              需要对字符串进行拼接的时候不能用String，可以用Stringbuffer 和 Stringbuilder
 * Author:panlai
 * :Date:2021/4/15
 */
public class StringTestdemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "abc";
        //想要修改abc为gbc需要用到 反射
        Class cl = String.class;
        // 获取 String 类中的 value 字段. 这个 value 和 String 源码中的 value 是匹配的.
        Field valueField = cl.getDeclaredField("value");
        // 将这个字段的访问属性设为 true
        valueField.setAccessible(true);
        // 把 str 中的 value 属性获取到.
        char[] value = (char[])valueField.get(str);
        // 修改 value 的值
        value[0] = 'h';
        System.out.println(str);

    }

    public static void main5(String[] args) {
        String str1 = "abc";            //每次拼接都会产生一个新的对象，不会再原有的基础上进行修改。
        str1 = str1 + "def";            //这拼接的过程中产生了很多的临时对象，在字符串常量池中，而且是被final修饰的。
        str1 = str1 + "hello";          //原因：value的指向不能发生改变，因为value是被final修饰的。
        System.out.println(str1);
    }


    public static  void change(String str ,char[] array){
        str = "hahahah!!";
        array[0] = 'G';

    }
    public static void main4(String[] args) {
        String str = "hello";
        char[] array = {'a','b','c'};
        System.out.println(str);
        System.out.println(Arrays.toString(array));
        System.out.println("=======================");
        change(str,array);
        System.out.println(str);
        System.out.println(Arrays.toString(array));
    }

    public static void main3(String[] args) {
        String str1 = "hello";
        String str2 = "hel" + "lo";
        System.out.println(str1==str2);           //结果为true

        String str3 = new String("hel") + "lo";
        System.out.println(str1 == str3);         //结果为false

        String str4 = new String("hello");
        System.out.println(str1 == str4);       //结果为false

        //入池方法 inter
        String str5 = new String("hello").intern();     //inter方法就是查看常量池有没有当前的对象，如果有直接把地址给前面的对象
        System.out.println(str1 == str5);       //结果为true



        byte a = 10;
        byte b = 20;
        //byte c = a + b;     //报错是因为进行了类型提升，如果a和b加了final就不会报错了。因为编译的时候就知道他是30了
    }



    public static void main2(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1==str2);             //结果为false,因为str2保存的是引用类型的地址
        String str3 = "hello";
        System.out.println(str1==str3);             //结果为true
    }

    public static void main1(String[] args) {
        String str = "hello";
        System.out.println(str);
        String str2 = "abcdef";
        System.out.println();

        char[] val = {'a','b','b','d','e','f','g','h'};
        String str3 = new String(val);
        System.out.println(str3);
    }

}
