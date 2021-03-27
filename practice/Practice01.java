import com.sun.javaws.IconUtil;

import java.util.Random;
import java.util.Scanner;
import java.*;                      //代表着导入java.util下的所有的包，当然包括上面那俩
//java.lang下的包不用手动导，直接用，eg:Math.sqrt()

/**
 * Remarks: 练习题 part1
 *         IDEA的调试：
 *         1、打断点：让代码走到这一步  停下里，在该行代码左边行数右边左键点击，红色圆点，
 *         2、开始调试：点击甲壳虫
 *
 * Author:panlai
 * :Date:2021/3/22
 */
public class Practice01 {
    /**
     * @Describle:
     * @Author: Pryor_Pan
     * @Date: 2021/03/22
     */
    //题目1：根据年龄，来打印出当前年龄 的人是少年（低于18），青年（19-28），中年（29-55），老年（56以上）
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个年龄（输0退出）：");
            int age = scan.nextInt();
            if (1 <= age && age <= 18) {
                System.out.println(age + "岁是少年！");
            } else if (19 <= age && age <= 28) {
                System.out.println(age + "岁是青年！");
            } else if (29 <= age && age <= 55) {
                System.out.println(age + "岁是中年！");
            } else if (56 <= age) {
                System.out.println(age + "岁是老年！");
            } else if (age == 0) {
                System.out.println("退出程序！");
                break;
            } else {
                System.out.println("输入不合法！！");
            }
        }
    }

    //题目2：判定一个数字是否是素数（只有1和它本身两个公因数）。
    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个整数（输0退出）：");
            int num = scan.nextInt();
            int flg = 1;
            if (num != 0) {
                int i = 2;
                while (i <= (int) Math.sqrt(num)) {        //还能进行优化，只用循环到根号下num处(返回double强转int)，根号需要用到math包，但是他属于java.lang，不用自己导入。
                    if (num % i == 0) {
                        flg = 0;
                        break;
                    }
                    i++;
                }
                switch (flg) {
                    case 1:
                        System.out.println(num + "是一个素数！");
                        break;
                    case 0:
                        System.out.println(num + "不是一个素数！");
                    default:
                        break;
                }
            } else {
                System.out.println("退出程序!");
                break;
            }

        }
    }

    //题目3:打印1-100以内所有的素数。
    public static void main3(String[] args) {
        int i = 1;
        while (i <= 100) {
            int j = 2;
            int flg = 1;                        //定义一个标志来记录，1代表质数，0代表合数。
            while (j <= (int) Math.sqrt(i)) {
                if (i % j == 0) {
                    flg = 0;
                    break;
                }
                j++;
            }
            switch (flg) {
                case 1:
                    System.out.println(i);
                    break;
                default:
                    break;
            }
            i++;
        }
    }

    //题目4：输出1000-2000之间所有的闰年。
    public static void main4(String[] args) {
        int year = 1000;
        while (year <= 2000) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println(year);
            }
            year++;
        }
    }

    //题目5：输出乘法口诀表
    public static void main5(String[] args) {
        int i = 1;
        while (i <= 9) {
            int j = i;
            while (j <= 9) {
                System.out.printf("%d*%d=%2d ", i, j, i * j);
                j++;
            }
            System.out.println();
            i++;
        }
    }

    //题目6：求两个正整数的最大公约数
    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请依次输入两个正整数：");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int min = num1 < num2 ? num1 : num2;

        while (min > 0) {
            if (num1 % min == 0 && num2 % min == 0) {
                System.out.println(num1 + "和" + num2 + "的最大公约数是：" + min);
                break;
            }
            min--;
        }

        //another way！！！辗转相除！！快的一批，
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = b;
        while (a % b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }


    //题目7：计算1-1/2+1/3-1/4+1/5........+1/99-1/100的值。
    public static void main7(String[] args) {
        double i = 1.0;
        double sum = 0;
        while (i <= 100) {
            if (i % 2 != 0) {
                sum += 1 / i;
            } else if (i % 2 == 0) {
                sum -= 1 / i;
            }
            i++;
        }
        System.out.println(sum);
    }

    //题目8：编写程序数一下1到100的所有整数中出现多少个数字9。
    public static void main8(String[] args) {       //如果找一个十进制数字的每一位上是几，只需要进行除10，或者模10，二级制除2，八进制除8
        int i = 0;
        int sum = 0;
        while (i <= 100) {
            if (i % 10 == 9) {
                sum++;
            }
            if (i / 10 == 9) {
                sum++;
            }
            i++;
        }
        System.out.println(sum);
    }

    //***题目9：求出0-999之间的所有水仙花数并输出（水仙花数是指一个三位数，其各位数字的立方和正好等于该数本身，如：153 = 1^3+5^3+3^3）
    public static void main9(String[] args) {
        //未完成水仙花数
        /*int i = 100;
        while (i <= 999) {
            if (((i / 100) ^ 3 + ((i / 10) % 10) ^ 3 + (i % 10) ^ 3) == i) {
                System.out.println(i);
            }
            i++;
        }*/


        //延伸，0-999999之间的类水仙花数（四叶玫瑰数，五角星数，六合数）
        for (int n = 1; n <= 999999; n++) {
            int cont = 0;
            int tep = n;
            while (tep != 0) {            //求一个数字是几位数，cont记录的是位数。
                cont++;
                tep = tep / 10;
            }

            tep = n;
            int sum = 0;
            while (tep != 0) {
                sum += Math.pow(tep % 10, cont);
                tep = tep / 10;
            }
            if (sum == n) {
                System.out.println(sum + " is my result!!");
            }
        }

    }


    //题目10：编写代码模拟输入密码，最多输入三次，密码正确显示：登陆成功！密码错误，可以重新输入，最多三次机会，三次错误退出程序。
    public static void main10(String[] args) {
        Scanner scan = new Scanner(System.in);
        String psd = "password";
        System.out.println("请输入密码（三次机会）：");
        int i = 1;
        while (i <= 3) {
            String key = scan.next();
            if (key.equals(psd)) {
                System.out.println("登陆成功！");
                break;
            } else if (!key.equals(psd)) {
                System.out.println("密码错误，你还有“" + (3 - i) + "”次机会");
            }
            i++;
        }
    }
    //题目11：写一个函数返回参数二进制中1的个数，比如：15 00001111 4个1
    //思路：判断每一位上是不是1，让当前数字和 1 进行“按位与&”操作。与操作：两个都为1时结果才为1。

    public static void main11(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        for (int i = 0; i < 32; i++) {               //这里i <= 32的原因是 int型变量的二进制制占32位。
            if (((n >> i) & 1) == 1) {                   //这里 n>>i 表示的含义是，将n右移i位，因为每次比较的值都是最右边的那一位
                count++;                            //比较完后，就向右移一位，删掉比较过的那一位，
            }
        }
        System.out.println(count + "个1");
    }
    //上面的方法对于比较小的数比如：5  他的二进制：0000 0000 0000 0000 0000 0000 0000 010，
    //只有开始的三次需要进行比较，后面的全部都是0，不需要进行多于的比较了，所以可以作以下优化。
    //思路：由于二级制数有一个特点：n & n-1 每进行一次操作，结果都少一个1，所以，可以根据他进行了几次 & 操作来判断他有几个1.
    public static void main100(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n != 0 ){
             n = n & (n-1);
             count++;
        }
        System.out.println(count + "个1");
    }

    //题目12：获取一个数二进制序列中所有的偶数位和奇数位，分别输出二进制序列。
    //思路：将二进制数跟1 进行 按位与& ，结果是0 那位就是0 ，是1，那位就是1.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 31; i>= 1;i-=2){               //打印奇数位，向右移31位那么判断的就是第一位，从左往右进行判断
            System.out.print(((n >> i)&1) + " ");
        }
        System.out.println("\n");
        for (int i = 30; i>= 0;i-=2){               //打印偶数位
            System.out.print(((n >> i)&1) + " ");
        }
    }

    //题目13：输出一个整数的每一位，
    public static void main13(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            int m = num;
            for (int i = 1; i <= (num + "").length(); i++) {
                m = m % 10;
                System.out.println(m);
                m /= 10;
            }
        }
    }


    //题目14：完成猜数字游戏
    public static void main14(String[] args) {
        Scanner scan = new Scanner(System.in);

        Random random = new Random();                  //随机数类，如果给定了一个时间戳，那么给定的数字都是一样的了
        int key = random.nextInt(100);          //生成一个随机数，：范围[0-100]
        System.out.println("猜数游戏：");
        while (scan.hasNext()) {
            int num = scan.nextInt();
            if (num == key) {
                System.out.println("猜对啦！！！");
                break;
            } else if (num < key) {
                System.out.println("小了！！");
            } else if (num > key) {
                System.out.println("大了！！");
            }
        }
    }


}
