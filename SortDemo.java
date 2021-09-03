import java.util.Arrays;

/**
 * @Name: SortDemo
 * @Description:
 * @Author: panlai
 * @Date: 2021/8/16 22:10
 */

public class SortDemo {
    //bubbleSort
    public static void bubbleSort(int[] array) {

        boolean flg = false;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flg = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flg) {
                break;
            }
        }
    }


    //insertSort
    public static void insertSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > key) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = key;
        }
    }

    //shellSort
    public static void shellSort(int[] array) {
        int[] gaps = {5, 2, 1};
        for (int i = 0; i < gaps.length; i++) {
            shell(array, gaps[i]);
        }
    }

    //shell排序的子方法，直接插入排序。以gap为一组
    public static void shell(int[] array, int gap) {
        int n = array.length;
        for (int i = gap; i < n; i++) {
            int key = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > key) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = key;
        }
    }

    //selectSort选择排序
    public static void selectSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 4, 8, 4, 63, 1, 58, 4};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
