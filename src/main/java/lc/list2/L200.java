package main.java.lc.list2;

/**
 * <p>
 *     Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 * </p>
 * <a href=https://leetcode.com/problems/number-of-islands/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/10
 **/
public class L200 {

    public void searchAdjencent(char[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = 'X';
        }
        searchAdjencent(grid, m, n, i-1, j);
        searchAdjencent(grid, m, n, i+1, j);
        searchAdjencent(grid, m, n, i, j-1);
        searchAdjencent(grid, m, n, i, j+1);
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    searchAdjencent(grid, m, n, i, j);
                    res++;
                }
            }
        }
        return res;
    }

}
