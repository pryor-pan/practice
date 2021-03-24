import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * Remarks: 逻辑控制程序的学习。
 *          1、顺序结构，逐行执行。
 *          2、分支结构：if...else..   switch...case...
 *          3、
 * Author:panlai
 * :Date:2021/3/22
 */
public class LogicControl {
    /**
     *@Describle: 分支结构
     *@Author: Pryor_Pan
     *@Date: 2021/03/22
    */
    public static void main1(String[] args) {
    //if....else...结构
        int num = 10;
        if (num==10){                         //if()括号里的值必须是一个boolean类型
            System.out.println(num);
        }
        else{
            System.out.println(8);
        }
        //悬垂else:else只会与最近的if结合。所以最好编程的时候不要省略括号
        int x = 20;
        int y = 10;
        if (x == 10)
            if (y == 10)
            System.out.println("aaa");      //运行结果是什么都不打印。
        else
            System.out.println("bbb");

        //小题目：从键盘输入一个年份，判断是否是闰年。
        Scanner scan = new Scanner(System.in);
        //scan.hasNext()从键盘循环读入一个数字，
        // 1、ctrl+d可以正常结束程序，
        // 2、ctrl+c是直接将程序中断
        while(scan.hasNext()){
            int year = scan.nextInt();

            if ((year%4==0 && year%100!=0) || (year%400==0)){       //能被4整除不能被100整除，或者能被400整除。
                System.out.println(year + "年是闰年！");
            }
            else{
                System.out.println(year + "年不是闰年！");
            }
        }
    //switch.... case....结构
        //switch中的参数只能是整数，字符，枚举，字符串
        //switch中不能是复杂的表达式
        //不建议使用switch进行嵌套
        int a = 10;
        switch(a) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("请输入正确的数字！");
                break;
        }
        //面试题：不能做switch参数的类型有哪些?
        //    A: long float double boolean
    }
    /**
     *@Describle: 循环结构
     *@Author: Pryor_Pan
     *@Date: 2021/03/22
    */
    public static void main2(String[] args) {
        int a = 10;
        while(a != 10){                         //while循环中只能放布尔表达式。
            System.out.println("执行内容");
        }
        //计算5的阶乘:5!=5*4*3*2*1.
        int num = 5;
        int  i = 1;                             //break只能用于跳出循环和switch
        int ret = 1;                            //continue用于跳过本轮循环。紧接着执行下一趟循环。
        while(i <= num){
            ret *= i;
            i++;
        }
        System.out.println(ret);

        //进阶：求5的阶乘的和
        int s=0;
        for (int n=1;n<=5;n++){
            int j = 1;
            int ret1 = 1;
            while(j<=n){
                ret1 *= j;
                j++;
            }
            s += ret1;
        }
        System.out.println("5的阶乘额和是：" + s);

    }
    //for循环求n的阶乘的和
    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入要求的数：");
        int num = scan.nextInt();                   //从键盘获取要求的数的阶乘数。

        int sum = 0;                                //用来记录阶乘和
        for (int i = 1 ; i <= num ; i++ ){
            int ret = 1;                            //用来记录n的阶乘
            for (int j = 1 ; j <= i ; j++){
                ret *=j;
            }
            sum += ret;
        }
        System.out.println(num + "的阶乘和是：" + sum);
    }
    //do  .....while()  用的极少
    public static void main4(String[] args) {        //先执行一次，然后再根据条件决定是否继续执行
        int num = 0;
        do {
            System.out.println("hello");
        }while (num != 0);

    }
    /**
     *@Describle:  输入和输出
     *
     *@Author: Pryor_Pan
     *@Date: 2021/03/23
    */
    public static void main5(String[] args) {
        //输出:
        String msg = "hello world!";
        System.out.println(msg);                    //输出一个字符串，带换行
        System.out.print(msg);                      //输出一个字符串，不带换行
        System.out.printf("%x",msg);                //格式化输出，参考c语言格式，%d,%.2f

        //输入：一般没人用sys.in.read();都用Scanner;使用前要导包，java.util.Scanner;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = sc.nextLine();
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();
        System.out.println("请输入你的工资：");
        float salary = sc.nextFloat();
        System.out.println("你的信息如下：");
        System.out.println("姓名:" + name + "年龄："+ age + "工资：" + salary );
        sc.close();                                 //使用完后最好调用关闭方法。

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        //while()里的条件必须是boolean类型，故从键盘取得到数字后，返回true。
        while (sc.hasNextInt()){                    //会循环不停地让你输入，想要结束的话ctrl+c中断，或者ctrl+d正常结束。
            int num = sc.nextInt();
            System.out.println(num);
        }
    }


}
