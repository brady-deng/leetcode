package main.java.lc.list2;

/**
 * <p>
 *     You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 * </p>
 * <a href=https://leetcode.com/problems/rotate-image/description/>ref</a>
 * <p>
 *     Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/10
 **/
public class L48 {
    class Solution {
        public void rotate(int[][] matrix) {
            int n=matrix.length;

            // take transpose of matrix
            for(int i=0;i<n;i++) {
                for (int j = i + 1; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            //Reverse rows of the matrix
            for(int i=0;i<n;i++)
            {
                int low=0,high=n-1;
                while(low<high)
                {
                    int temp=matrix[i][low];
                    matrix[i][low]=matrix[i][high];
                    matrix[i][high]=temp;

                    low++;  high--;
                }
            }
        }
    }
}
