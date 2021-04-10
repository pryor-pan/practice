package com.complexity;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * Remarks: 复杂度的学习：复杂度是衡量算法效率的
 *              时间复杂度：（默认的是最坏情况下的时间复杂度）
 *                  计算方法：（大O渐进法）
 *                      1、用常数1取代运行时间中所有的加法常数
 *                      2、在修改后的运行次数函数中，只保留最高阶项
 *                      3、如果最高阶项存在且不是1，则去除与这个项相乘的常数，得到的结果就是大O阶
 *
 *              空间复杂度：是算法在运行过程中临时占用(额外的)存储空间大小的量度
 *                  计算方法：（大O渐进法）
 *
 *
 * Author:panlai
 * :Date:2021/4/3
 */
public class Complexity {
    //问题：下面这个算法的时间复杂度
    void func(int n , int m ){
        int count = 0;
        for (int i = 0; i < n ; i++) {
            count++;                    //执行n次
        }
        for (int i = 0; i < m; i++) {
            count++;                    //执行m次
        }
        System.out.println(count);
    }
    //时间复杂度为m+n；

    //方法：交换数组中两个元素的值
    public static void Swap(int[] arr,int index1,int index2 ){
        int tem = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tem;
    }
    //下面这个冒泡排序，说出最好和最坏情况的时间复杂度: 最好O(n) 最坏O(n^2)  空间复杂度：O(1)boolean是定义了一次，把一个变量定义了n次还是同一个变量，所以是O（）
    void bubbleSort(int[] array){
        for (int end = array.length;end>0;end--){
            boolean flag = true;
            for (int i = 0; i < end; i++) {
                if (array[i-1]>array[i]){
                    Swap(array,i-1,i);
                    flag = false;
                }
            }
            if (flag == true){
                break;
            }
        }
    }

    //下面这个二分查找，说出他的最好和最坏时间复杂度;  最好：O(1)    最坏O(Logn)
    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == value) {
                return mid;
            }
            else if (arr[mid] > value) {
                right = mid -1;
            }
            else if (arr[mid] < value){
                left = mid + 1;
            }
        }
        return -1;
    }
    //计算阶乘（递归）的时间复杂度:  O(n)    空间复杂度：O(n)   因为每次取递归调用自身的时候未执行完成的任务都会被存储起来占用内存
    public int factorial(int n){
        return n<2?n:factorial(n-1);
    }

    //斐波那契（递归）的时间复杂度 : O(2^n)  太复杂了     空间复杂度：O(n)  结论：对于斐波那契：空间复杂度就是这棵树的高度
    public static int fibonacci(int n){
        return n<2?n:fibonacci(n-1)+fibonacci(n-2);
    }
    //斐波那契（非递归）的时间复杂度：O(n)
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


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(array, 5));
    }
}
