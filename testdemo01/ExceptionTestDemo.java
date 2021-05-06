package com.exception.testdemo01;

/**
 * Remarks: 异常，Exception
 *          编译时异常(受查异常)：在编译的时候就知道发生了错误。
 *          运行时异常(非受查异常)：程序在运行期间发生的错误。
 *              算术异常：ArithmeticException
 *              数组越界异常：ArrayIndexOutOfBoundsException:
 *              空指针异常：NullPointerException
 *          防御式编程：
 *              错误在代码中是可观的，所以要在程序出现问题时，及时通知程序猿，有两种方式：
 *                  LBYL:Look Before You Leap。在操作之前就做充分检查。
 *                  EAFP: It's Easier to Ask Forgiveness than Permission.
 *                        事后获取原谅比事前获取许可更容易,也就是“先操作，遇到问题在处理”
 *          父类的异常不要放在最前头。
 *          finally 是相对于try   catch  来说是最后执行的。
 *          如果finally中有return，那么最后返回的是finally中的。尽管try中有return了。
 *              所以尽量不要咋finally中写return；
 *          throws：声明异常.
 *
 *
 *
 * Author:panlai
 * :Date:2021/4/24
 */
public class ExceptionTestDemo {


    public static void main(String[] args) {
        int[] array  = {1,2,3};
        //System.out.println(array[100]);     //运行时异常：数组越界


        try {
            int a = 10;
            int b = 0;
            System.out.println(a/b);
            System.out.println("没有捕获异常");       //一旦发生异常，直接就处理异常。下面就算有异常也捕获不到了。
            String str = null;
            System.out.println(str.length());       //
        }catch (ArithmeticException e){             //可以在括号中用|来分隔处理多个异常.
            e.printStackTrace();                //打印异常信息,但是程序依然会执行。常用于处理多个异常
            System.out.println("0不能做分母");
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("空指针异常!");
        }finally {

        }
        System.out.println("如果你看到这段文字说明异常被处理了");
    }
}
