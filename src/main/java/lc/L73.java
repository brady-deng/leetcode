package main.java.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
