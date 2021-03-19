/**
 * Remarks:数据类型学习day2（引用数据类型）
 * Author:panlai
 * :Date:2021/3/17
 */
public class Datatype2 {

    /**
     *@Describle: 字符串数据类型   String
     *@Author: Pryor_Pan
     *@Date: 2021/03/17
    */
    /*public static void main(String[] args) {
        int a = 10;
        String str = "\"hello\"";           //如果需要输出“hello”  需要使用转义符\
        String result = str + a;            //字符串拼接上任何一种数据类型，结果最终都是字符串类型。
        System.out.println(str);
        System.out.println(result);

    }*/

    /**
     *@Describle: 常量  （使用时一定要记得进行初始化）
     *            1、字面常量：int，char double型的常量 10 hello 12.3
     *            2、被final修饰的常量。
     *@Author: Pryor_Pan
     *@Date: 2021/03/17
    */
    /*public static void main(String[] args) {

        final int MAXNUM = 999;             //常量只能被初始化一次。并且在运行时不能被修改

        System.out.println(MAXNUM);
    }*/

    /**
     *@Describle: 类型转换
     *            1、隐式类型转换：把一个小类型数据给大类型。
     *            2、显式类型转换：把一个大类型给小类型，需要进行强制类型转换。
     *@Author: Pryor_Pan
     *@Date: 2021/03/17
    */
    public static void main(String[] args) {
        int a = 10;
        long b = a;                         //此时不会报错；因为进行了隐式转换，将int型转换为long型。
        System.out.println(b);              //当要将long类型的值赋值给int型时，就会报错，因为会丢失精度。

        //int和String之间的相互转换：
        //int转String
        int num = 10;
        //方法一
        String str1 = num + "";             //给后面加一个空串
        //方法二
        String str2 = String.valueOf(num);  //调用valueOf（）
        System.out.println(str1);
        System.out.println(str2);
        //String转int
        String str = "100";
        int num1 = Integer.parseInt(str);   //调用包装类.parseInt（）
        System.out.println(num1);





    }

}
