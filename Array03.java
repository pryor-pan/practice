import java.util.Arrays;

/**
 * Remarks: 二维数组的学习
 *              Java当中：二维数组就是一个一维数组中的每一个元素都是一个一维数组。
 *              数组是引用类型。默认值为mull，
 * Author:panlai
 * :Date:2021/4/1
 */
public class Array03 {
    /**
     *@Describle: 二维数组的定义方式：
     *@Author: Pryor_Pan
     *@Date: 2021/04/01
    */
    public static void main1(String[] args) {
        //定义一个二维数组， (中括号中不允许出现数字)
        int[][] array = {{1,2,3},{4,5,6}};
        int[][] array2 = new int[][]{{1,2,3},{4,5,6}};
        //这样定义时，中括号里可以有数字，表示他是一个2行3列的数组
        int[][] array3 = new int[2][3];
    }
    /**
     *@Describle:  数组的遍历（规则数组）
     *@Author: Pryor_Pan
     *@Date: 2021/04/01 
    */
    public static void main2(String[] args) {
        int[][] array = {{1,2,3},{4,5,6}};
        //对于上面两行三列的二维数组，遍历数组打印所有的元素，（其中2和3分别表示数组的行数和列数）
        for (int i = 0; i < 2 ; i++) {              //外层的for循环表示打印某一行元素
            for (int j = 0; j < 3; j++) {           //内层的for循环表示打印某一行的某一个一个元素
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        //对于任意一个二维数组，遍历他                           //因为二维数组相当于一维数组存了n个一维数组，
        for (int i = 0; i < array.length; i++) {            //这里的array.length表示的是二维数组的行数
            for (int j = 0; j < array[i].length; j++) {     //这里的array[i].length表示的是二维数组的列数
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        //想要打印一个数组
        System.out.println(Arrays.toString(array));         //此时，用toString方法只能打印第一层数组的地址
        System.out.println(Arrays.deepToString(array));     //想要打印二维数组应该用deepToString

        //通过for...each..打印二维数组
        for (int[] tmp: array) {
            for ( int x : tmp ) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    /**
     *@Describle:  不规则数组
     *@Author: Pryor_Pan
     *@Date: 2021/04/01
    */
    public static void main(String[] args) {
        //Java当中，定义不规则的数组的时候，数组的行必须指定，列，不可以自动推导的
        int[][] array = new int[2][];
        array[0] = new int[3];              //对于两行的数组，可以分别指定第几行有几个元素，这里表示下标为0的行有3个元素
        array[1] = new int[2];              //这里表示，下标为1的行有2个元素，由于没有给初始值，他们默认都为0；（简单类型默认值为0）

    }
}
