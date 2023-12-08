package main.java.lc.list2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * </p>
 * <a href = https://leetcode.com/problems/spiral-matrix-ii/>ref</a>
 * <p>
 *     3-->[[1,2,3],[8,9,4],[7,6,5]]
 *     1-->[[1]]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/8
 **/
public class L591208 {
    public static void main(String[] args) {
        System.out.println("Please input the n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0;
        int j = n-1;
        int start = 1;
        while (i < j ) {
            for (int o = i; o < j; o++) {
                res[i][o] = start++;
            }
            for (int o = i; o < j; o++) {
                res[o][j] = start++;
            }
            for (int o = j; o > i; o--) {
                res[j][o] = start++;
            }
            for (int o = j; o > i; o--) {
                res[o][i] = start++;
            }
            i++;
            j--;
        }
        if (res[i][j] == 0 && i == j) {
            res[i][j] = start;
        }
        return res;
    }
}
