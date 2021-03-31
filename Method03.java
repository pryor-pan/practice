/**
 * Remarks: 方法的学习part3
 *          1、方法的递归：一个方法在执行的过程中调用自身，就称之为“递归”  (我调我自己)
 *                      他是一个把一个大问题化解小的问题，因为，大问题的处理方式和小问题的处理方式是一样的，比如：求n的阶乘，那么求4的阶乘和求3的阶乘的方法是一样的
 *
 *                  1)、要调用自己本身
 *                  2)、要有一个趋近于终止的条件
 *                  3)、推导出递归的公式（重要）
 * Author:panlai
 * :Date:2021/3/26
 */
public class Method03 {
    //方法1：求一个数的阶乘（递归）
    public static int fac(int n) {
        //如果没有这个终止条件，就会一直递归下去，最终就把栈挤爆了。一个栈一般就1M~2M大小。报错：StackOverflowError
        if (n == 1) {
            return 1;
        }
        return n * fac(n - 1);
    }
    //方法2：按顺序打印一个数字的每一位,
    public static void func1(int n) {
        //首先终止条件:如果是一个数字，那不用执行递归，直接输出。
        if (n > 9) {
            func1(n / 10);                  //当不是个位数的时候，除以10，尝试把它变成个位数，因为只有个位数才能被输出
        }
        System.out.print(n % 10 + " ");
    }
    //方法3：求1+2+3+4+.....+n
    public static int addNum(int n){
        if (n == 1){
           return 1;
        }
        return n+addNum(n-1);
    }
    //方法4：输入一个整数，返回各位数字之和例如：输入：1729，返回：1+7+2+9
    public static int func2(int n){
        if(n<10){
            return n;
        }
        return n%10 + func2(n/10);
    }
    //方法5：用递归求斐波那契数列第n项，第n项等于前两项的和.
    // 这是一个双路递归，了不得了，每次递归要找两个前置项，又要找前四项，又要找前八项，又要找前十六项，子子孙孙无穷尽也。
    public static int fabonaci1(int n){
        if (n == 1 || n == 2){
            return 1;
        }
        return fabonaci1(n-1)+fabonaci1(n-2);         //所以，一般不建议用递归实现斐波那契数列，，用迭代（循环）
    }
    //方法5.1：用循环求斐波那契数列第n项（非递归）
    public static int fabonaci2(int n){
        int f1 = 1;
        int f2 = 1;
        int f3 = 1;             //f3的初始值设为1的原因是因为当n等于1的时候直接是f3的初始值。
        for(int i = 3 ;i<=n ; i++){
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    /**
     *@Describle: 方法的递归
     *            1、函数的调用是要在 栈 上开辟内存的，给这个函数开辟 栈帧
     *            2、思考递归时：横向思考：不要试图走进递归的代码,展开代码。你脑子不好，绕不开的。所以只要知道推导公式尤其重要(n!=n*（n-1）);
     *@Author: Pryor_Pan
     *@Date: 2021/03/26
    */
    public static void main(String[] args) {
        System.out.println(fac(5));
        func1(123);
        System.out.println(addNum(5));
        System.out.println(func2(1729));
        System.out.println(fabonaci1(7));
        System.out.println(fabonaci2(7));
    }
}
