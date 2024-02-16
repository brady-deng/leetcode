package main.java.lc.list;

import main.java.lc.util.LUtil;

/**
 * <p>
 *     An alphabetical continuous string is a string consisting of consecutive letters in the alphabet. In other words, it is any substring of the string "abcdefghijklmnopqrstuvwxyz".
 *
 * For example, "abc" is an alphabetical continuous string, while "acb" and "za" are not.
 * Given a string s consisting of lowercase letters only, return the length of the longest alphabetical continuous substring.
 * </p>
 * <a href=https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: s = "abacaba"
 * Output: 2
 * Explanation: There are 4 distinct continuous substrings: "a", "b", "c" and "ab".
 * "ab" is the longest continuous substring.
 * Example 2:
 *
 * Input: s = "abcde"
 * Output: 5
 * Explanation: "abcde" is the longest continuous substring.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240208
 **/
public class L2414 {

    public static void main(String[] args) {
        String s = LUtil.inputString();
        System.out.println(new L2414().longestContinuousSubstring(s));
    }

    public int longestContinuousSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] prev = new int[s.length()];
        for (int i = 1; i < chars.length; i++) {
            prev[i] = chars[i] - chars[i-1];
        }
        int i = 0;
        int start = 0;
        int end = 0;
        int res = 1;
        while (i < prev.length) {
            if (prev[i] == 1) {
                start = i;
                end = i;
                while (end < prev.length && prev[end] == 1) {
                    end++;
                }
                i = end;
                res = Math.max(end-start+1, res);
            } else {
                i++;
            }

        }
        return res;
    }
}
