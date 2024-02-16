package main.java.lc.list2;

import main.java.lc.util.LUtil;

/**
 * <p>
 *     You are given an m x n integer matrix mat and an integer target.
 *
 * Choose one integer from each row in the matrix such that the absolute difference between target and the sum of the chosen elements is minimized.
 *
 * Return the minimum absolute difference.
 *
 * The absolute difference between two numbers a and b is the absolute value of a - b.
 * </p>
 * <a href=https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/description/>ref</a>
 * <p>
 *     Input: mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
 * Output: 0
 * Explanation: One possible choice is to:
 * - Choose 1 from the first row.
 * - Choose 5 from the second row.
 * - Choose 7 from the third row.
 * The sum of the chosen elements is 13, which equals the target, so the absolute difference is 0.
 * </p>
 * <p>
 *     Input: mat = [[1],[2],[3]], target = 100
 * Output: 94
 * Explanation: The best possible choice is to:
 * - Choose 1 from the first row.
 * - Choose 2 from the second row.
 * - Choose 3 from the third row.
 * The sum of the chosen elements is 6, and the absolute difference is 94.
 * </p>
 * <p>
 *     Input: mat = [[1,2,9,8,7]], target = 6
 * Output: 1
 * Explanation: The best choice is to choose 7 from the first row.
 * The absolute difference is 1.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240214
 **/
public class L1981 {

    public static void main(String[] args) {
        int[][] mat = LUtil.inputArray2();
        int target = LUtil.inputNum();
        System.out.println(new L1981().minimizeTheDifference(mat, target));
        System.out.println(new L1981Ans().minimizeTheDifference(mat, target));
    }

    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        int reminder = Integer.MAX_VALUE;
        if (m == 1) {
            for (int j = 0; j < n; j++) {
                int tmp = Math.abs(target - mat[0][j]);
                if (tmp < reminder) {
                    reminder = tmp;
                }
            }
        } else if (n == 1) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum+=mat[i][0];
            }
            reminder = Math.abs(target - sum);
        } else {
            int[] tmp = new int[(int)Math.pow(m, n)];
            sumReminder(mat, 0, 0, 0, tmp);
            for (int i = 0; i < m*n; i++) {
                int t = Math.abs(tmp[i] - target);
                if (t < reminder) {
                    reminder = t;
                }
            }
        }
        return reminder;
    }

    public void sumReminder(int[][] mat, int i, int sum, int ind, int[] res) {
        if (i == mat.length) {
            res[ind] = sum;
            return;
        }
        for (int j = 0; j < mat[0].length; j++) {
            sum += mat[i][j];
            sumReminder(mat, i+1, sum, ind*mat[0].length+j, res);
            sum -= mat[i][j];
        }
    }
}
