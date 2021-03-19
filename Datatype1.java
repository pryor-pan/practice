/**
 * Remarks:数据类型学习day1（基本数据类型）
 *         1、在给一个数据赋值的时候，一定注意不能超过他的范围。
 *
 * Author:panlai
 * :Date:2021/3/17
 */
public class Datatype1 {
    /**
     *@Describle: 长整形
     *            long  8个字节
     *@Author: Pryor_Pan
     *@Date: 2021/03/17
    */
    /*public static void main(String[] args) {
        long a = 10L;
        System.out.println(a);
        System.out.println("long型最大值："+ Long.MAX_VALUE);
        System.out.println("long型最小值："+ Long.MIN_VALUE);

        int b = 10;
        int c = 30;
        System.out.println(b+c);
        System.out.println("hello"+ b + c);//任何类型的数据进行拼接，输出结果都是字符型.输出：hello1030
        System.out.println("hello"+ (b + c));//加括号可以解决 输出：hello40

    }

    //网易面试题：main方法里的(String[] args)代表什么含义？A：他是一个运行时参数，使用cmd运行代码额外输入内容会被循环打印。
    public static void main(String[] args) {
        for (int i = 0;i < args.length; i++){
            System.out.println(args[i]);
        }
        System.out.println("lough");
    }*/


    /**
     *@Describle: 双精度 浮点型
     *            double  8个字节
     *@Author: Pryor_Pan
     *@Date: 2021/03/17
    */
    /*public static void main(String[] args) {
        double a = 12.5;
        System.out.println(a);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

    }*/
    /**
     *@Describle: 单精度  浮点型
     *            float   4个字节
     *@Author: Pryor_Pan
     *@Date: 2021/03/17
    */
   /* public static void main(String[] args) {

        float f = 12.3f;                    //如果这样赋值：float f = 12.3;会报错，
        System.out.println(f);              //因为Java中不允许吧double类型直接赋值给float类型(精度不同)。
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
    }*/

    /**
     *@Describle: 字符数据类型
     *            char  2个字节   0~65535
     *@Author: Pryor_Pan
     *@Date: 2021/03/17
    */
    /*public static void main(String[] args) {
        char ch = 'a';
        System.out.println(ch);

        char ch2 = '潘';
        System.out.println(ch2);

        char ch3 = 97;                      //Unicode字符集(比ASC2)表示的范围更广了。其中包括汉子。
        System.out.println(ch3);
    }*/

    /**
     *@Describle: 字节  （可以表示数值）
     *            byte  1个字节   -128~127
     *@Author: Pryor_Pan
     *@Date: 2021/03/17
    */
    /*public static void main(String[] args) {

        byte b = 12;
        byte c = 21;
        byte d = (byte)(b+c);               //少于4个字节的数据类型，运算的时候会发生类型的提升。
        System.out.println(d);              //比如这里，如果不加（byte）强转为byte类型则会自动提升为int型。
        System.out.println(b+" "+c);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);

        int d = Byte.MAX_VALUE+1;           //此处发生了类型的提升：byte-->>int
        System.out.println(d);

        byte e = 127;                       //byte类型的最大值是127；赋值130会报错。
        System.out.println(e);

    }*/

    /**
     *@Describle:  短整型  （可以表示负数）
     *             short  2个字节   -32768~32767
     *@Author: Pryor_Pan
     *@Date: 2021/03/17
    */
    /*public static void main(String[] args) {

        short sh = 12;
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);

    }*/

    /**
     *@Describle: 布尔类型
     *            1、boolean   Java中布尔类型没有明确的字节
     *            2、Java当中  布尔类型只有两个取值：true和false
     *            3、java当中  没有所谓的  0为假  非0为真。只有true为真 false为假
     *@Author: Pryor_Pan
     *@Date: 2021/03/17
    */
    public static void main(String[] args) {
        boolean flg = true;
        System.out.println(flg);

        if(true){                           //其中的true不能替换为1.
            System.out.println("hello!!");
        }
    }


}
