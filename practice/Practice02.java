import java.util.Scanner;

/**
 * Remarks: 练习题 part2
 * Author:panlai
 * :Date:2021/3/27
 */
public class Practice02 {


    public static void move(char pos1, char pos2) {
        System.out.print(pos1 + " -> " + pos2 + " ");
    }
    /**
     *@Describle: 方法：汉诺塔
     *          n  盘子的个数
     *          pos1 起始位置
     *          pos2 中途位置
     *          pos3 目的地位置
     *@Author: Pryor_Pan
     *@Date: 2021/03/27
    */
    public static  void hanoi(int n ,char pos1,char pos2,char pos3){
        //终止条件，只有一个盘子，
        if (n ==1 ){
            move(pos1,pos3);                       //直接从A柱子移到C柱子
        }
        else{
            hanoi(n-1,pos1,pos3,pos2);          //将n-1个盘子从A经过C移到B
            move(pos1,pos3);                       //将第n个盘子从A移到C
            hanoi(n-1,pos2,pos1,pos3);          //将n-1个盘子从B经过A移到C
        }
    }

    /**
     *@Describle: 问题1；求解汉诺塔问题（递归）
     *@Author: Pryor_Pan
     *@Date: 2021/03/27
    */
    public static void main1(String[] args) {
        //一个盘子 a>c                              2^-1
        //两个盘子 a>b b>c b>c                      2^2-1
        //三个盘子 a>c a>b c<b a>c b>c a>c          2^3-1
        //n个盘子 ........................          2^n-1
        //64个盘子：电脑要移301年，，人：......愚公！！
        hanoi(1,'A','B','C');
        System.out.println();
        hanoi(2,'A','B','C');
        System.out.println();
        hanoi(3,'A','B','C');
        System.out.println();
    }

        //方法： 青蛙跳台阶（递归）
    public  static int jumpFloor(int n){
        if (n == 1|| n == 0){
            return 1;
        }
        else if (n<=2){
            return 2;
        }
        else{
            return jumpFloor(n-1)+jumpFloor(n-2);
        }
    }
    /**
     *@Describle: 青蛙跳台阶问题：
     *                  一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     *                  求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *@Author: Pryor_Pan
     *@Date: 2021/03/27
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            int n = sc.nextInt();
            System.out.println(n+ "个台阶共有 " + jumpFloor(n) + "种跳法" );
        }

    }

}
