package lc.list2;

import lc.list2.test.L378Test;
import lc.util.LUtil;

/**
 * <p>
 *     Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * You must find a solution with a memory complexity better than O(n2).
 * </p>
 * <a href=https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 * Example 2:
 *
 * Input: matrix = [[-5]], k = 1
 * Output: -5
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240216
 **/
public class L378 {



    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getCount(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }

    private int getCount(int[][] matrix, int mid) {
        int count = 0;
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[][] matrix = LUtil.inputArray2();
        int num = LUtil.inputNum();
        System.out.println(new L378Test().kthSmallest(matrix, num));
    }


}
