package lc;

import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/8
 **/
public class L58 {
    public static void main(String[] args) {
        System.out.println("Please input the String:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        String[] tmp = s.split(" ");
        if (tmp.length>0) {
            return tmp[tmp.length-1].length();
        }
        else return 0;
    }
}
