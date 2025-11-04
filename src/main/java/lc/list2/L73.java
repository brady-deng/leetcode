package lc.list2;

import java.util.Arrays;
import java.util.Scanner;


/**
 * <p>
 *     Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 * </p>
 * <a href=https://leetcode.com/problems/set-matrix-zeroes/>ref</a>
 * <p>
 *     [[1,1,1],[1,0,1],[1,1,1]] --> [[1,0,1],[0,0,0],[1,0,1]]
 * [[0,1,2,0],[3,4,5,2],[1,3,1,5]] --> [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * </p>
 * <p>
 *     Medium
 * </p>
 */
public class L73 {
    public static void main(String[] args) {
        System.out.println("Please input the m:");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println("Please input the n:");
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        scanner.nextLine();
        for (int i = 0; i<m; i++) {
            System.out.println("Please input the matrix:");
            matrix[i] = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }
        setZeroes(matrix);
        System.out.println(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        boolean[][] isZero = new boolean[matrix.length][matrix[0].length];
        for (int i = 0 ; i< matrix.length;i++) {
            for (int j = 0; j< matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                    isZero[i][j] = true;
                }
                else {
                    isZero[i][j] = false;
                }
            }
        }
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j< matrix[0].length; j++) {
                if (isZero[i][j]) {
                    setZeroesOnRowCol(matrix, i, j);
                }
            }
        }
    }

    public static void setZeroesOnRowCol(int[][] matrix, int i, int j) {
        int r = i;
        int c = j;
        while (i > -1) {
            matrix[i][c] = 0;
            i--;
        }
        i = r;
        while (i < matrix.length) {
            matrix[i][c] = 0;
            i++;
        }
        while (j > -1) {
            matrix[r][j] = 0;
            j--;
        }
        j = c;
        while (j < matrix[0].length) {
            matrix[r][j] = 0;
            j++;
        }
    }
}
