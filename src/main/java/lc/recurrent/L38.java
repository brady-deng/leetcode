package main.java.lc.recurrent;

import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/6
 * <p>The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 *
 * For example, the saying and conversion for digit string "3322251":
 *
 *
 * Given a positive integer n, return the nth term of the count-and-say sequence.</p>
 *
 * <a href=https://leetcode.com/problems/count-and-say/></a>
 *
 * <p>1
 * 4</p>
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
