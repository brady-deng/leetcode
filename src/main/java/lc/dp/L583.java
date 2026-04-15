package main.java.lc.dp;

import main.java.lc.util.LUtil;

/**
 * 583. 两个字符串的删除操作
中等
相关标签
premium lock icon
相关企业
给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。

每步 可以删除任意一个字符串中的一个字符。

 

示例 1：

输入: word1 = "sea", word2 = "eat"
输出: 2
解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
示例  2:

输入：word1 = "leetcode", word2 = "etco"
输出：4
 

提示：

1 <= word1.length, word2.length <= 500
word1 和 word2 只包含小写英文字母
 */
public class L583 {

    public static void main(String[] args) {
        while (true) {
            String word1 = LUtil.inputString();
            if (word1.isEmpty()) {
                break;
            }
            String word2 = LUtil.inputString();
            System.out.println(new L583().solution(word1, word2));
        }

    }

    public int solution(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[][] dp = new int[c1.length+1][c2.length+1];
        for (int i = 0; i <= c1.length; ++i) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= c2.length; ++i) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[c1.length][c2.length];
    }
    
}
