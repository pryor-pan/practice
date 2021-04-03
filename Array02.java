import java.util.Arrays;

/**
 * Remarks: 数组的学习 part2
 *         Arrays工具类的学习：
 *         1、Arrays.toString();     //将数组中的数据以字符串的形式进行输出，
 *         2、Arrays。copyOf();      //将数组拷贝的拷贝返回，
 *         3、Arrays.binarySearch(); //二分查找，找数组中的某个元素，返回下标
 *         4、
 *
 *
 * Author:panlai
 * :Date:2021/3/30
 */
public class Array02 {

    /**
     *@Describle: 拷贝数组，（有四种方式）将数组1里的内容拷贝到数组2中
     *          1、for循环
     *          2、Arrays。copyOf()；工具类方法
     *          3、System.arraycopy();本地方法  比第二种更快，因为他是一个本地方法，底层使用c/c++写的。
     *          4、array.clone(); 克隆， 产生了这个对象的一个副本  这个方法是Object的克隆方法，
     *          Object：是所有类的父类，祖先
     *
     *          上面的4种拷贝方式从本质上看都是“浅拷贝”
     *          浅拷贝：
     *          如果数组中存放的是引用类型(比如存放的是地址)，修改拷贝后数组2中的
     *          元素，数组1中的元素也会随之改变。这样的拷贝叫做“浅拷贝”
     *
     *          深拷贝：
     *          如果数组中存放的是简单类型，修改拷贝后的数组2中的元素值
     *          数组1中的元素不会发生改变，这样的拷贝叫做“深拷贝”
     *
     *
     *@Author: Pryor_Pan
     *@Date: 2021/03/31
    */
    //方法1：拷贝数组（一般方式）  返回值是一个数组；
    public static int[] copyArray(int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }
//main1方法在这里！！！！！
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        //方法1：for循环拷贝数组
        System.out.println(Arrays.toString(copyArray(array)));  //打印数组
        //方法2：Arrays工具类：Arrays.copyOf();方法直接拷贝   //用法；前面的参数是要拷贝的数组名，后面的参数是新的数组要求多长。返回的是一个新对象。
        System.out.println(Arrays.toString(Arrays.copyOf(array, array.length)));
        //方法3：System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);  将指定源数组中的数组从指定位置复制到目标数组的指定位置。
                      //5个参数含义：  源数组   开始拷贝的位置    目的地数组   要拷到哪个位置   拷贝多长
        int[] array2 = new int[array.length];
        System.arraycopy(array,0,array2,0,array.length);    //从数组1的0号位置拷到数组2的0号位置，拷贝的长度等于数组1的长度。
        System.out.println(Arrays.toString(array2));
        //方法4：克隆，
        int[] array3 = array.clone();
        System.out.println(Arrays.toString(array3));
    }
    /**
     *@Describle: 数组的一些应用
     *          1、找最大元素
     *          2、查找数组中某个元素
     *@Author: Pryor_Pan
     *@Date: 2021/03/31
    */
    //方法：找数组中的最大元素
    public static int findMaxNum(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }
    //方法：找数组中指定的元素  一个一个按顺序找 返回的是元素下标
    public static int findNum(int[] arr,int key){
        for (int i = 0;i<arr.length;i++){
            if (arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    //方法：二分查找 找数组中指定的元素 二分查找：折半查找：给定一个有序的序列，才能使用二分查找，
    public static int binarySearch(int[] arr, int key){
        int left = 0;
        int right = arr.length-1;
        while(left <= right ){              //当left>right的时候说明数组走完了也没有找到
            int min = (left + right)/2;     //这里的除2操作可以替换成>>>1右移1位，因为右移更快，且右移相当于除法
            if (key == arr[min]){
                return min;
            }
            else if (key<arr[min]){
                right = min-1;
            }
            else if (key>arr[min]){
                left = min + 1;
            }
        }
        return -1;
    }


//main2方法在这里！！！
    public static void main2(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(findMaxNum(array));      //找最大元素

        System.out.println("下标是：" + findNum(array, 6));      //找元素6，找到返回下标，找不到返回-1

        System.out.println("下标是：" + binarySearch(array, 10)); //调用二分查找

        System.out.println(Arrays.binarySearch(array, 8));      //Arrays工具类有二分查找的方法，参数类型是数组和元素值。

    }
    /**
     *@Describle: Arrays工具类中的常用方法介绍
     *          1、Arrays.toString();               //将数组中的数据以字符串的形式进行输出，
     *          2、Arrays。copyOf();                //将数组拷贝的拷贝返回，
     *             Arrays.copyOfRange(array, 1,5);
     *          3、Arrays.binarySearch();           //二分查找，找数组中的某个元素，返回下标
     *          4、Arrays.equals();                 //判断两个数组内容是否相同
     *          5、Arrays.fill();                   //填充数组，用第二个参数值填充数组。也可以局部填充，用fromindex和toindex
     *          6、Arrays.sort();                   //将数组中的元素按升序排列
     *
     *
     *
     *
     *
     *@Author: Pryor_Pan
     *@Date: 2021/03/31
    */
    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        //[fromindex,toindex) 左闭右开的形式，从2下标开始找，找到6，第7号下标不找
        System.out.println(Arrays.binarySearch(array, 2, 7, 5));        //从第2号下标找到第7号下标，

        int[] array2 = Arrays.copyOfRange(array, 1,5);                              //拷贝，从1号下标拷贝到5号下标，不包括5号下标
        System.out.println(Arrays.toString(array2));

        System.out.println(Arrays.equals(array, array2));                                   //判断两个数组内容是否相同，相同返回true，否则false

        int[] array3 = new int[10];
        Arrays.fill(array3,8);                          //填充数组，用第二个参数值填充数组。也可以局部填充，用fromindex和toindex
        System.out.println(Arrays.toString(array3));

        int[] array4 = {2,4,3,1,8,6,5,9,7};
        Arrays.sort(array4);                                //将数组中的元素按升序排列
        System.out.println(Arrays.toString(array4));

    }
    /**
     *@Describle: 判断一个数组是否是升序的
     *@Author: Pryor_Pan
     *@Date: 2021/03/31
    */
    //方法：判断一个数组是否是升序的，是 返回true，不是 返回fslse
    public static boolean isUp(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void main4(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        int[] array2 = {5,4,3,9,1,3,4};

        System.out.println(isUp(array));
        System.out.println(isUp(array2));
    }
    /**
     *@Describle: 冒泡排序：两两比较，大的往后换
     *            数组逆置：
     *
     *
     *@Author: Pryor_Pan
     *@Date: 2021/03/31
    */
    //方法：冒泡排序 (不足，需要优化：假如才比较了两趟，已经有序了，后面就不用再进行排序了，解决思路：在每一趟后进行判断，如果有序，就不判断了)
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int key = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = key;
                }
            }
        }
    }
    //方法：优化后的冒泡排序,
    public static void bubbbleSortPlus(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;                   //在判断开始时定义一个flag，初始值为false，表示没有交换
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int key = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = key;
                    flag = true;                    //如果发生了交换，将flag置为true
                }
            }
            if (flag == false){                     //进行一次判断，如果flag为false表示没有发生交换，则直接跳出循环
                break;
            }
        }
    }
    //方法：数组逆置  思路：左右两个标记，交换两个值，标记分别向后向前移
    public static void reverse(int[] arr){
        int left = 0 ;
        int right = arr.length-1;
        while(left<=right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
    //方法：将数组中的偶数法放到数组的前半部分，奇数放到后半部分
    public static void swap(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while (left < right){
            while(left<right && arr[left]%2 == 0){
                //偶数
                left++;
            }
            //left遇到奇数了
            while(left < right && arr[right] % 2 != 0 ){
                //奇数
                right--;
            }

            //right遇到偶数了；
            if(left<right){             //这个判断不能少，因为程序走到这里时，不一定是因为两个都停了，也有可能是两者相遇了
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {2,5,8,3,56,1,1,3,36,5,4,21,4,6,32};

        bubbleSort(array);
        System.out.println(Arrays.toString(array));

        reverse(array);
        System.out.println(Arrays.toString(array));

        int[] array2 = {1,3,5,7,9};
        swap(array2);
        System.out.println(Arrays.toString(array2));
    }
}
