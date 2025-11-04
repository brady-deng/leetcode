package lc.list2;

import lc.list2.test.L221Test;
import lc.util.LUtil;

/**
 * <p>
 *     Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * </p>
 * <a href=https://leetcode.com/problems/maximal-square/description/>ref</a>
 * <p>
 *     Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * Input: matrix = [["0"]]
 * Output: 0
 * </p>
 * <p>
 *     Medium
 * </p>
 *
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/10
 **/
public class L221 {

    public static void main(String[] args) {
        char[][] array = LUtil.inputCharArray();
        System.out.println(new L221Test().maximalSquare(array));
    }

    public int maxSquare(char[][] matrix, int m, int n, int i, int j) {
        int res = 0;
        while (true) {
            for (int a = i; a < i+res+1; a++) {
                for (int b = j; b < j+res+1; b++) {
                    if (a >= m || b >= n) {
                        return res;
                    }
                    if (matrix[a][b] != '1') {
                        return res;
                    }
                }
            }
            res++;
        }
    }

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<m; i++) {
            for (int j =0; j<n; j++) {
                if ((m-i) > res && (n-j) > res) {
                    int tmp = maxSquare(matrix, m, n, i, j);
                    res = Math.max(tmp, res);
                }
            }
        }
        return res*res;
    }
}
