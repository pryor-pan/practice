package testexam;

import java.util.*;


/**
 * Remarks:
 * Author:panlai
 * :Date:2021/4/27
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            boolean flg = true;
            for (int j = 0; j < sb.length(); j++) {
                if (str.charAt(i) == sb.charAt(j)){
                    flg = false;
                    break;
                }
            }
            if (flg){
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
