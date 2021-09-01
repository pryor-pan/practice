package test1;

import java.util.ArrayList;

/**
 * @Name: Main
 * @Description:
 * @Author: panlai
 * @Date: 2021/8/25 14:19
 */

public class Main {

    public static void func(int n){
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i-1] = i;
        }
        boolean[] used = new boolean[n];
        int m = array.length;
        DFS(array,m,used);


    }
    static ArrayList<Integer> list = new ArrayList<>();
    public static void DFS(int[] array,int m,boolean[] used){
        if (m<=0){
            for (int i = 0; i < list.size(); i++) {
                System.out.printf( list.get(i) +" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < array.length ; i++) {
            if(!used[i]){
                list.add(array[i]);
                used[i] = true;
                DFS(array,m-1,used);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        func(n);
    }
}
