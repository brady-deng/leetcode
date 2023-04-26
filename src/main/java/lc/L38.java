package main.java.lc;

import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/6
 **/
public class L38 {
    public static void main(String[] args) {
        System.out.println("Please input the n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countAndSay(n));
    }
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        else {
            return tranSay(countAndSay(n-1));
        }
    }
    public static String tranSay(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        char prev = 0;
        int tmp = 0;
        if (chars.length > 1) {
            for (int i = 0; i<chars.length; i++) {
                if (chars[i] == prev) {
                    tmp+=1;
                }
                else {
                    if (tmp != 0) {
                        res.append(tmp);
                        res.append(prev);
                    }
                    prev = chars[i];
                    tmp = 1;
                }
            }
            if (tmp != 0) {
                res.append(tmp);
                res.append(prev);
            }
        }
        else {
            res.append(1);
            res.append(s);
        }
        return res.toString();
    }
}
