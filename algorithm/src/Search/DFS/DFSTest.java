package Search.DFS;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Name: DFSTest
 * @Description:        深度优先搜索：
 *                      1.处理边界，出口条件
 *                      2.当下这一步需要做的事情
 *                      3.
 * @Author: panlai
 * @Date: 2021/8/18 22:36
 */





public class DFSTest {

    /**
     *      题目描述，输入n个不同字符 0<n<100 ,输入一个0<m<n,
     *      从n个字符当中取m个的所有排列，并打印出来。
     */
    //定义一个list用于存储每一组的值字符，
    static ArrayList<Character> list2 = new ArrayList<>();
    public static void DFS(char[] chars,int m,boolean[] used){
    //当m<=0时，说明已经找到了一组排列，立即输出。
        if (m<=0){
            for (int i = 0; i < list2.size(); i++) {
                System.out.printf( list2.get(i) +" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < chars.length ; i++) {
            if(!used[i]){
                list2.add(chars[i]);
                used[i] = true;
                DFS(chars,m-1,used);
                //走到这里，说明已经遇到return，说明已经返回了一组排列了，如果后边还有元素，
                //就把list的最后一个删掉。腾出位置给下一个字符放。
                list2.remove(list2.size()-1);
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = sc.next().charAt(0);
        }
        int m = sc.nextInt();
        boolean[] used = new boolean[n];
        DFS(chars,m,used);
    }


    /**
     * 题目描述：有n张牌  n个盒子，，把n张牌放入n个盒子中，问有多少种方法，尝试打印每种结果
     */

    static ArrayList<Character> list = new ArrayList<>();
    public static void DFS1(char[] nums,int n,boolean[] used){
        if (n <= 0){
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                list.add(nums[i]);
                used[i] = true;
                DFS1(nums,n-1,used);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }


    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] nums = new char[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.next().charAt(0);
        }
        boolean[] used = new boolean[n];
        DFS1(nums,n,used);


    }



}
