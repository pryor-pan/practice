/**
 * Remarks:方法的学习part2
 *        1、实参和形参的关系
 *        2、方法的重载
 * Author:panlai
 * :Date:2021/3/26
 */
public class Method02 {
    //方法1：交换两个数的值，
    public static void swap(int x, int y ){
        int tmp = x;
        x = y;
        y = tmp;
    }

    //方法2：分别计算两（三）个整（浮点）数的和
    public static int sum(int a, int b){                        //方法名为sum，参数为 两个 int
        return a+b;
    }
    public static double sum(double a,double b){                //方法名为sum，参数为 两个 double
        return a+b;
    }
    public static double sum(double a,double b,double c){       //方法名为sum，参数为 三个 double
        return a+b+c;
    }

    /**
     *@Describle: 方法的重载(overload):
     *            1、方法名称相同
     *            2、返回值不作要求
     *            3、参数列表不同（参数的个数 或者 参数的类型不同）
     *            4、同一个类当中
     *          面试题：
     *              重载 和 重写 的区别?
     *@Author: Pryor_Pan
     *@Date: 2021/03/26
    */
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        double x = 5.5;
        double y = 4.5;
        double z = 2.0;
        System.out.println(sum(a, b));              //这三条语句虽然调用的方法名都是sum，
        System.out.println(sum(x, y));              //但是由于他们的形参参数类型（个数）不同
        System.out.println(sum(x, y, z));           //所以调用的时候并不会报错。
    }

   /**
    *@Describle: 方法中实参和形参的关系
    *@Author: Pryor_Pan
    *@Date: 2021/03/26
   */
    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        //这是在main中普通的交换a和b的值
//        int tmp = a;
//        a = b;
//        b = tmp;
        //***************
        swap(a,b);                      //这一步只交换了方法中形参的值，实参的值并没有发生改变。此处要想使用该方法交换两个数的值，需要用到类和对象，或者数组。
        System.out.println(a+" " + b);  //output: 10  20
    }
}
