package main.java.lc.dp;

import java.util.Scanner;

/**
 * <p>
 *     Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where s and t are divided into n and m
 * substrings
 *  respectively, such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 * </p>
 * <a href = https://leetcode.com/problems/interleaving-string/>ref</a>
 * <p>
 *     "aabcc"
 * "dbbca"
 * "aadbbcbcac"
 * --> true
 *
 * "aabcc"
 * "dbbca"
 * "aadbbbaccc"
 * --> false
 *
 *
 * ""
 * ""
 * ""
 * --> true
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/12
 **/
public class L97 {
    public static void main(String[] args) {
        System.out.println("Please input the s1:");
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        System.out.println("Please input the s2:");
        String s2 = scanner.nextLine();
        System.out.println("Please input the target string:");
        String tar = scanner.nextLine();
//        System.out.println(isInterleave(s1,s2, tar));
        System.out.println(L97Ans.isInterleave(s1,s2, tar));

    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        return myIsInterLeave(s1, s2, s3) || myIsInterLeave(s2,s1,s3);
    }

    public static boolean myIsInterLeave(String s1, String s2, String s3) {
        if ("".equals(s1) && "".equals(s2) && "".equals(s3)) {
            return true;
        }
        else if ("".equals(s1)) {
            return s2.equals(s3);
        }
        else if ("".equals(s2)) {
            return s1.equals(s3);
        }
        else {
            int start = 0;
            if (s1.charAt(start) == s3.charAt(start)) {
                while (start < s1.length() && start < s3.length() && s1.charAt(start) == s3.charAt(start)) {
                    start++;
                    boolean tmp = myIsInterLeave(s2, s1.substring(start), s3.substring(start));
                    if (tmp) return tmp;
                }
            }
            return false;
        }
    }
}
