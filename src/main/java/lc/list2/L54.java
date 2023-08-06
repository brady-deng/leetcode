package main.java.lc.list2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *  Given an m x n matrix, return all elements of the matrix in spiral order.
 * </p>
 *
 * <a href=https://leetcode.com/problems/spiral-matrix/>ref</a>
 * <p>
 *     [[1,2,3],[4,5,6],[7,8,9]]-->[1,2,3,6,9,8,7,4,5]
 * [[1,2,3,4],[5,6,7,8],[9,10,11,12]]-->[1,2,3,4,8,12,11,10,9,5,6,7]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/7
 **/
public class L54 {
    public static void main(String[] args) {
        System.out.println("Please input the m:");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println("Please input the n:");
        int n = scanner.nextInt();
        int[][] nums = new int[m][n];
        scanner.nextLine();
        for (int i = 0; i<m; i++) {
            System.out.println("Please input the nums:");
            nums[i] = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(spiralOrder(nums));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int r1 = 0;
        int r2 = m;
        int l1 = 0;
        int l2 = n;
        List<Integer> res = new ArrayList<>();
        while (r1 < r2 && l1 < l2) {
            for (int j = l1; j < l2; j++) {
                res.add(matrix[r1][j]);
            }
            for (int i = r1+1; i < r2; i++) {
                res.add(matrix[i][l2-1]);
            }
            for (int j = l2-2; j >= l1; j--) {
                res.add(matrix[r2-1][j]);
            }
            for (int i = r2-2; i > r1; i--) {
                res.add(matrix[i][l1]);
            }
            r1++;
            r2--;
            l1++;
            l2--;
        }
        return res;
    }
}
