package main.java.lc.string;

import java.util.Scanner;

/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring
 * <p>case="(()"
 * ")()())"
 * ""</p>
 * <a href=https://leetcode.com/problems/longest-valid-parentheses/>https://leetcode.com/problems/longest-valid-parentheses/</a>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/5
 **/
public class L32 {
    public static void main(String[] args) {
        System.out.println("Please input the parentheses:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int res = 0;
        res = getLong(s, 0, s.length(), res);
        return 2*res;
    }

    public static int getLong(String s, int l, int r, int pre) {
        int countL = 0;
        int res = 0;
        for (int i = l; i<r; i++) {
            if (s.charAt(i) == '(') {
                if (countL < r-i-1) {
                    countL+=1;
                }
                else {
                    countL = 1;
                    pre = Math.max(pre, res);
                    res = 0;
                }
            }
            else if (s.charAt(i) == ')') {
                countL-=1;
                if (countL >= 0) {
                    res+=1;
                }
            }
            if (countL < 0) {
                l = i+1;
                if (res > pre) pre = res;
                pre = getLong(s, l, r, pre);
            }
        }
        return Math.max(res, pre);

    }

}
