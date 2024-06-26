package main.java.lc.list2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * <p>
 *     Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * </p>
 * <a href = https://leetcode.com/problems/spiral-matrix-ii/>ref</a>
 * <p>
 *     3-->[[1,2,3],[8,9,4],[7,6,5]]
 *     1-->[[1]]
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/8
 **/
public class L59 {
    public static void main(String[] args) {
        System.out.println("Please input the n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[] tmp = IntStream.range(1, n*n+1).toArray();
        int r1 = 0;
        int r2 = n-1;
        int l1 = 0;
        int l2 = n-1;
        int c = 0;
        while (r1 < r2 && l1 < l2) {
            for (int i = l1; i<=l2; i++) {
                res[r1][i] = tmp[c];
                c++;
            }
            for (int i = r1+1; i<= r2; i++) {
                res[i][l2] = tmp[c];
                c++;
            }
            for (int i = l2-1; i>=l1; i--) {
                res[r2][i] = tmp[c];
                c++;
            }
            for (int i = r2-1; i > r1; i--) {
                res[i][l1] = tmp[c];
                c++;
            }
            r1++;
            l1++;
            r2--;
            l2--;
        }
        if (r1 == r2) {
            res[r1][l1] = tmp[c];
        }
        return res;
    }
}
