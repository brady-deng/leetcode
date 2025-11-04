package lc.list2;

/**
 * <p>
 *     Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 *
 * </p>
 * <a href=https://leetcode.com/problems/set-matrix-zeroes/description/>ref</a>
 * <p>
 *     Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/10
 **/
public class L731210 {
    public void replaceZeros(int[][] matrix,boolean[][] flag, int m, int n, int i, int j) {
        for (int a = 0; a < n; a++) {
            flag[i][a] = true;
        }
        for (int a = 0; a < m; a++) {
            flag[a][j] = true;
        }
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    replaceZeros(matrix, flag, m, n, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flag[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
