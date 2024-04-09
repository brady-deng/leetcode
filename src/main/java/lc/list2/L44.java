package main.java.lc.list2;

import main.java.lc.dp.L44Ans;
import main.java.lc.list2.test.L44Test;

import java.util.Scanner;

/**
 * <p>
 *     Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * </p>
 * <a href = https://leetcode.com/problems/wildcard-matching/description/>ref</a>
 * <p>
 *     "aa"
 * "a"
 * "aa"
 * "*"
 * "cb"
 * "?a"
 * </p>
 * <p>
 *     hard
 * </p>
 *
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/19
 **/
public class L44 {

    public static void main(String[] args) {
        System.out.println("Please input the s:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println("Please input the p:");
        String p = scanner.nextLine();
        System.out.println(new L44().isMatch(s,p));
        System.out.println(new L44Ans().isMatch(s,p));
        System.out.println(new L44Test().isMatch(s,p));
    }

    public boolean isMatch(String s, String p) {
        return match(s,p,0,0);
    }

    public static boolean match(String s, String p, int s1, int p1) {
        if (s1 > s.length()-1 && p1 > p.length()-1) return true;
        else {
            if (
                    (p1 >= p.length() && s1 < s.length())
                    || (s1 >= s.length() && p1 < p.length() && p.charAt(p1) != '*')
            ) return false;
            if (p.charAt(p1) != '?' && p.charAt(p1) != '*') {
                if (p.charAt(p1) != s.charAt(s1)) {
                    return false;
                }
                else {
                    return match(s, p, s1+1, p1+1);
                }
            }
            else if (p.charAt(p1) == '?') {
                return match(s, p, s1+1, p1+1);
            }
            else if (p.charAt(p1) == '*' && p1 == p.length()-1) {
                return true;
            }
            else if (p.charAt(p1) == '*') {
                while (p1 < p.length() && p.charAt(p1) == '*') {
                    p1++;
                }
                if (p1 == p.length()) return true;
                else {
                    for (int i = s1; i < s.length(); i++) {
                        if ((s.charAt(i) == p.charAt(p1) || p.charAt(p1) == '?') && match(s, p, i, p1)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
    }
}
