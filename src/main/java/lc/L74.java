package main.java.lc;

import java.util.Arrays;
import java.util.Scanner;

public class L74 {
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
        System.out.println("Please input the target:");
        int target = scanner.nextInt();
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int[] ints : matrix) {
            if (target >= ints[0] && target <= ints[n - 1]) {
                for (int j = 0; j < n; j++) {
                    if (target == ints[j]) return true;
                }
            } else if (target < ints[0]) return false;
        }
        return false;
    }
}
