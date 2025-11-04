package lc.list2;

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
public class L5912082 {
    public static void main(String[] args) {
        System.out.println("Please input the m:");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println("Please input the n:");
        int n = scanner.nextInt();
        System.out.println("Please input the start:");
        int start = scanner.nextInt();
        Arrays.stream(generateMatrix(m, n, start)).forEach(item->{
            for (int s : item) {
                System.out.print(s);
                System.out.print(" ");
            }
            System.out.println();
        });
    }
    public static int[][] generateMatrix(int m, int n, int start) {
        int[][] res = new int[m][n];
        int i = 0;
        int j = n-1;
        int k = m-1;
        int end = start + m*n;
        while (i < j && i < k) {
            for (int o = i; o < j; o++) {
                res[i][o] = start++;
            }
            for (int o = i; o < k; o++) {
                res[o][j] = start++;
            }
            for (int o = j; o > i; o--) {
                res[k][o] = start++;
            }
            for (int o = k; o > i; o--) {
                res[o][i] = start++;
            }
            i++;
            j--;
            k--;
        }
        if (start < end) {
            for (int o = i; o < j; o++) {
                res[i][o] = start++;
            }
            for (int o = i; o < k; o++) {
                res[o][i] = start++;
            }
        }
        if (i == j && m == n) {
            res[i][j] = start;
        }
        return res;
    }
}
