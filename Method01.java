import java.util.Scanner;

/**
 * Remarks: 方法的学习part1
 *          1、java方法 对应 c语言的函数。
 *          2、方法就是一个代码片段，可以看做是一个功能。
 *          3、能够模块化的组织代码。让代码能够被重复使用，简化开发。
 *          4、main（）也是一个方法
 *          方法的书写规范：
 *          public static 返回值（int char void等） 方法名称 （形式参数列表）｛
 *          ｝
 *          方法名：采用“小驼峰”形式
 *          加public static的原因：因为当前所有的方法写完后，会在main方法中调用，因为main方法是public static的。
 *          返回值：可有可无，看具体业务需求。
 *                 如果有返回值 那么返回值的类型需要和方法的返回值类型匹配，
 *          形式参数列表：形参->>实参的一份拷贝。
 *          方法体｛｝：具体方法的实现。
 *          return : 代表着方法（函数）的结束，一旦return，下面的代码都不执行了。
 *
 *          下面用一个方法：求两个数的最大值来解释方法的定义和书写。
 *
 *          java中只有按值传递，引用->值
 * Author:panlai
 * :Date:2021/3/26
 */
public class Method01 {
    //方法：求两个数的最大值
    public static int maxNum(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }
    //方法：求三个数的最大值
    public static int maxThreeNum(int num1, int num2, int num3) {
        return maxNum(maxNum(num1, num2), num3);          //函数的重复调用，在一个函数里可以调用另一个函数。
    }
    //方法：实现两个整数相加
    public static int numAdd(int num1,int num2){
        return num1+num2;
    }
    //方法：计算n的阶乘和(可优化)
    public static int factor(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {            //产生1-n
         //**************************************
         //  int ret = 1;                         //
         //  for (int j = 1; j <= i; j++) {       //这部分的功能是求一个数字的阶乘，
         //       ret *= j;                       //所以可以单独封装成一个方法。
         //  }                                    //
         //**************************************
            sum +=fac(i);
        }
        return sum;
    }

    //方法5的延伸：求一个数字的阶乘
    public  static int fac(int num){
        int ret = 1;
        for (int i = 1; i <= num; i++) {
            ret *= i;
        }
        return ret;
    }



//main方法在这！！！！
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n1 = sc.nextInt();              //n1,n2,n3在方法内，称之为局部变量，在内存中存在栈上，
//        int n2 = sc.nextInt();
//        int n3 = sc.nextInt();
//        System.out.println(maxNum(n1, n2));
//        System.out.println(maxThreeNum(n1, n2, n3));        //如果函数有返回值就可以直接写在sout里
//        System.out.println(numAdd(n1, n2));
        System.out.println(factor(5));

    }



}
