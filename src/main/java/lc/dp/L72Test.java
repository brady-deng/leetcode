package main.java.lc.dp;

import main.java.lc.util.LUtil;

/**
 * <p>
 *     Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * </p>
 * <a href=https://leetcode.com/problems/edit-distance/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/10
 **/
public class L72Test {


    public static void main(String[] args) {
        while (true) {
            String w1 = LUtil.inputString();
            if (w1.isEmpty()) {
                break;
            }
            String w2 = LUtil.inputString();
            System.out.println(new L72Test().new Solution().minDistance(w1, w2));
        }
    }

    class Solution {
        public int minDistance(String word1, String word2) {
            char[] c1 = word1.toCharArray();
            char[] c2 = word2.toCharArray();
            int[][] dp = new int[c1.length+1][c2.length+1];
            for (int i = 0; i <= c1.length; ++i) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= c2.length; ++j) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= c1.length; ++i) {
                for (int j = 1; j <= c2.length; ++j) {
                    if (c1[i-1] == c2[j-1]) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                }
            }
            return dp[c1.length][c2.length];
        }
    }
}
