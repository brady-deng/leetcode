package lc;

import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/6
 **/
public class L37 {
    public static void main(String[] args) {
        System.out.println("Please input the sudoku:");
        Scanner scanner = new Scanner(System.in);
        int m = 9, n = 9;
        char[][] sudoku = new char[m][n];

        for (int i = 0; i<m; i++) {
            sudoku[i] = scanner.nextLine().toCharArray();
        }

    }
}
