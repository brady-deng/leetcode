package lc.list2.test;

import lc.list2.L44;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date
 **/
public class L44Test extends L44 {

    @Override
    public boolean isMatch(String s, String p) {
        char[] s1 = s.toCharArray();
        char[] s2 = p.toCharArray();
        boolean[][] dp = new boolean[s1.length+1][s2.length+1];
        dp[0][0] = true;
        for (int j = 1; j < s2.length+1; j++) {
            dp[0][j] = (s2[j-1] == '*' && dp[0][j-1]);
        }
        for (int j = 1; j < s2.length+1; j++) {
            for (int i = 1; i < s1.length+1; i++) {
                recurDP(s1, s2, dp, i, j);
            }
        }
        return dp[s1.length][s2.length];
    }

    public void recurDP(char[] s1, char[] s2, boolean[][] dp, int i, int j) {
        dp[i][j] = (((s1[i-1] == s2[j-1] || s2[j-1] == '?') && dp[i-1][j-1])
                || (s2[j-1] == '*' && (dp[i-1][j] || dp[i][j-1])));
    }
}
