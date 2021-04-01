import java.util.Arrays;

/**
 * Remarks: 数组的学习（数组是引用类型）
 *         1、数组是存放相同数据类型的集合，内存是连续的
 *         2、Java中数组存在堆上，
 *         new ： 实例化一个对象，定义一个数组，其实就是定义一个对象，
 * Author:panlai
 * :Date:2021/3/27
 */
public class Array01 {
    /**
     *@Describle: 数组的定义和遍历
     *@Author: Pryor_Pan
     *@Date: 2021/03/30
    */
    public static void main1(String[] args) {
        int[] array = {1,2,3,4};                    //该写法与下面那条写法本质上是一样的，
        int[] array2 = new int[]{11,22,33,44};
        int[] array3 = new int[4];                  //此时array数组里存放着4个0；
        System.out.println(array);                  //栈上的地址是拿不到的，堆上的地址可以打印，但不是真是的，但是可以当做是真是的，因为他是唯一的（经过了哈希处理）

        //遍历一个数组
        for (int  i = 0; i<array.length;i++){       //i不能等于array.length,否则会下标越界
            System.out.print(array[i]);
        }
        System.out.println("*****************************");
        //for...each... 打印数组.(与for的区别是不需要索引值i，适用于单纯遍历整个数组)
        for (int val : array) {
            System.out.print( val + " ");
        }
    }
    /**
     *@Describle: 下标越界
     *@Author: Pryor_Pan
     *@Date: 2021/03/30
    */
    public static void main2(String[] args) {
        //数组下标越界，由于数组长度总共只有3，想访问第100个元素的时候系统找不到，就会抛出下标越界异常
        int [] arr = {1,2,3};
        System.out.println(arr[100]);
    }
    /**
     *@Describle: 数组作为参数进行传递：
     *          数组作为参数进行传递的时候，传过去的是数组的地址，
     *@Author: Pryor_Pan
     *@Date: 2021/03/30
    */
    //方法：打印一个数组
    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
    //方法：通过数组实现两个数字的交换，前面的方法直接调用方法因为修改的是形参的值，实参并不发生改变，所以可以用数组实现
    public static void swap(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }

    public static void main3(String[] args) {
        int[] array = {1, 2, 3, 4};
        printArray(array);
        System.out.println();

        int[] arr2 = {10, 20};
        System.out.println(arr2[0] + " " + arr2[1]);
        swap(arr2);                                     //调用方法
        System.out.println(arr2[0] + " " + arr2[1]);
        //调用内部方法直接打印数组
        String ret = Arrays.toString(array);            //Arrays操作数组的工具类，需要导包，util包,toString是将数组以字符串形式输出
        System.out.println(ret);                        //定义一个ret来接收返回的String类型结果。
    }
    /**
     *@Describle: 数组的初始化
     *@Author: Pryor_Pan
     *@Date: 2021/03/30
    */
    public static void main4(String[] args) {
        int a = 0;                          //其他变量在定义的时候要附一个初始值，不知道赋值什么就赋值0
        System.out.println(a);
        int[] array = null;                 //数组中的初值可以赋值null，表示array引用的是一个空对象。/null与地址无关，仅代表一个空对象
        System.out.println(array[0]);       //运行后抛出空指针异常，因为根本就没有对象，没有0下标让你访问
    }
    //运行时常量池，在jdk1.7开始都被放到堆中了，


    /**
     *@Describle: Arrays数组工具类
     *@Author: Pryor_Pan
     *@Date: 2021/03/30
    */
    //方法：将数组中的值变为原来的二倍返回
    public static int[] func(int[] arr) {
        int[] tmp = new int[arr.length];       //重新开辟一部分空间用来存储翻倍后的数组
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = 2 * arr[i];
        }
        return tmp;
    }
    public static void main5(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] ret = func(array);                //定义一个数组用来接收新的数组
        System.out.println(Arrays.toString(ret));       //Arrays叫做，操作数组的工具类，
        //对array2进行排序
        int[] array2 = {2, 5, 4, 1, 20, 15, 3, 8};
        Arrays.sort(array);                             //工具类方法，将数组按从小到大进行排序
        System.out.println(Arrays.toString(array));

        //还有很多工具类方法的使用,去看帮助手册吧！！！
    }
    /**
     *@Describle:  课堂练习 (能实现，但不是最佳)
     *                  自己实现一个数组转字符串的功能，
     *                  不使用Arrays工具类的toString方法
     *@Author: Pryor_Pan
     *@Date: 2021/03/30
    */
    public static String myToString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i <arr.length-1){
                str = str + Integer.toString(arr[i]) + ",";
            }
            else{
                str = str + Integer.toString(arr[i]) + "]";
            }
        }
        return str;
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 3, 12, 8};
        System.out.println(myToString(array));
    }
}
