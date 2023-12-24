package main.java.lc.list2;

/**
 * <p>
 *     Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 * </p>
 * <a href=https://leetcode.com/problems/minimum-path-sum/description/>ref</a>
 * <p>
 *     Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/10
 **/
public class L64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                res[0][j] = grid[0][0];
            } else {
                res[0][j] = res[0][j-1]+grid[0][j];
            }
        }
        for (int i = 1; i < m; i++) {
            res[i][0] = res[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i-1][j]+grid[i][j], res[i][j-1]+grid[i][j]);
            }
        }
        return res[m-1][n-1];
    }
}
