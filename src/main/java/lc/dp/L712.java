
package main.java.lc.dp;

import main.java.lc.util.LUtil;

/**
 * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。

 

示例 1:

输入: s1 = "sea", s2 = "eat"
输出: 231
解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
在 "eat" 中删除 "t" 并将 116 加入总和。
结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
示例 2:

输入: s1 = "delete", s2 = "leet"
输出: 403
解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 

提示:

1 <= s1.length, s2.length <= 1000
s1 和 s2 由小写英文字母组成
 */

public class L712 {

    public static void main(String[] args) {
        while (true) {
            String w1 = LUtil.inputString();
            if (w1.isEmpty()) {
                break;
            }
            String w2 = LUtil.inputString();
            System.out.println(new L712().solution(w1, w2));
        }
    }

    public int solution(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[][] dp = new int[c1.length+1][c2.length+1];
        for (int i = 1; i <= c1.length; ++i) {
            dp[i][0] = dp[i-1][0]+(int) c1[i-1];
        }
        for (int j = 1; j <= c2.length; j++) {
            dp[0][j] = dp[0][j-1]+(int) c2[j-1];
        }
        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j]+(int) c1[i-1], dp[i][j-1] + (int) c2[j-1]);
                }
            }
        }
        return dp[c1.length][c2.length];
    }
}