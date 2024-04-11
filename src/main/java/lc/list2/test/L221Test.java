package main.java.lc.list2.test;

import main.java.lc.list2.L221;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date
 **/
public class L221Test extends L221 {

    @Override
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int res = 0;
        for (int i = 1; i < matrix.length+1; i++) {
            for (int j = 1; j < matrix[0].length+1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    res = Math.max(res, dp[i][j]);
                }

            }
        }
        return res*res;
    }
}
