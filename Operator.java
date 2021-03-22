import com.sun.org.apache.xpath.internal.objects.XString;
import org.w3c.dom.ls.LSInput;

import java.util.Scanner;


/**
 * Remarks:运算符的学习。
 * Author:panlai
 * :Date:2021/3/19
 */
public class Operator {
    /**
     *@Describle: 除号/和模%
     *@Author: Pryor_Pan
     *@Date: 2021/03/19
    */
    /*public static void main(String[] args) {

        *//*System.out.println(5/2);
        System.out.println(5.0/2);
        System.out.println((float)5/2);     //将5强转后再除以2
        System.out.println((float)(5/2));   //将5/2的结果进行强转为float*//*


        System.out.println(10%3);
        System.out.println(-10%3);
        System.out.println(10%-3);
        System.out.println(-10%-3);

        System.out.println(5/0);            //报错，0不能再除数位置

    }*/
    /**
     *@Describle: 复合运算符  +=  -= *= /=
     *@Author: Pryor_Pan
     *@Date: 2021/03/20
    */
    /*public static void main(String[] args) {
        int a = 10;
        int b = 20;
         a += b;
        System.out.println(a);              //-= *= /= 同理。
    }*/
    /**
     *@Describle:  自增自减运算符  ++  --
     *@Author: Pryor_Pan
     *@Date: 2021/03/20
    */
    /*public static void main(String[] args) {
        int a = 10;
        int b = ++a;                        //a = a + 1; b = a;
        System.out.println(b);              //前置自增返回值是自增之后的值
        int c = a++;                        //c = a; a = a + 1
        System.out.println(c);              //后置自增返回值是自增之前的值

        //注意有坑！！！！
        int i = 10;
        i = i++;
        System.out.println(i);
    }*/
    /**
     *@Describle: 关系运算符  == != < > <= >=
     *            运算结果结果都是true或者false
     *@Author: Pryor_Pan
     *@Date: 2021/03/20
    */
    /*public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a==b);
        System.out.println(a!=b);
        System.out.println(a<b);
        System.out.println(a>b);
        System.out.println(a<=b);
        System.out.println(a>=b);

        //上面这些输出结果都是true或者false
    }*/
    /**
     *@Describle: 逻辑运算符  && || !
     *            运算结果是boolean (true or false)
     *            逻辑或和逻辑与遵循短路求值原则：
     *            1、对于逻辑与：一旦表达式1为真，就没有必要判断表达式2了
     *            2、对于逻辑或：一旦表达式1为假，就没有必要判断表达式2了
     *@Author: Pryor_Pan
     *@Date: 2021/03/20
    */
    /*public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;
        System.out.println(a < b && b < c);     //逻辑与，两真才为真
        System.out.println(a < b || b > c);     //逻辑或，有真就为真
        //短路求值规则
        System.out.println(10 > 20 && 10 / 0 == 0 );        //原本应该报算术异常，但由于表达式1已经为假，所以没有判断表达式2，所以就不会报错了
        //&和|（按位与（有0为0，其余为1）  按位或（有1为1，其余为0））
        //如果操作数为boolean的时候，也表示逻辑运算，但是和&&以及||相比，不支持短路求值原则。
        System.out.println(10 > 20 & 10 / 0 == 0);          //程序抛出算术异常
        System.out.println(10 > 20 | 10 / 0 == 0);          //程序抛出算术异常

        //^按位异或（不一样的，进行或，一样的就是0）
        //~按位取反（将二进制按位取反）

        boolean flg = true;
        System.out.println(!flg);               //java中!运算符只能作用于boolean类型上
        System.out.println(!(a < b));

    }*/
    /**
     *@Describle: 移位运算符（了解）  << >> >>>
     *            都是按照二进制位来运算
     *            <<:左移，最左侧位不要了，最右侧补0，（左移相当于乘法）
     *            >>:右移：最右侧位不要了，最左侧补符号位.（右移相当于除法）
     *            >>>: 无符号右移：最右侧不要了，最左侧补0.（没有无符号左移）
     *            位运算的速度是大于 * 和 / 的
     *@Author: Pryor_Pan
     *@Date: 2021/03/21
    */
    /*public static void main(String[] args) {

        int a = 0x10;
        //左移
        System.out.printf("%x\n", a << 1);  //%x表示以16进制打印
        //右移
        System.out.printf("%x\n", a >> 1);
        int b = 0xffff0000;
        System.out.printf("%x\n", b >> 1);
        //无符号右移
        int c = 0xffffffff;
        System.out.printf("%x\n", c >>> 1);

    }*/
    /**
     *@Describle: 条件运算符（三目运算符）
     *            表达式1 ? 表达式2 : 表达式3
     *            表达式1为true，整个式子的值为表达式2，表达式1为false，整个式子的值为表达式3
     *@Author: Pryor_Pan
     *@Date: 2021/03/21
    */
    /*public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int max = a > b ? a : b;
        System.out.println(max);
    }*/
    //运算符的优先级：乘除大于加减，不知道的直接加括号。

    /**
     *@Describle:  scanner组件用法
     *             1.首先要进行导包  import java。util.Scanner；
     *@Author: Pryor_Pan
     *@Date: 2021/03/22
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        int a = scan.nextInt();             //从键盘读取一个整数；
        System.out.println(a);
        //从键盘读取一个字符串时，nextLine（）和next（）的区别
        String str1 = scan.nextLine();      //nextline（）可以输入空格，
        System.out.println(str1);

        String str2 = scan.next();          //next（）遇到空格会直接结束
        System.out.println(str2);



    }

}
