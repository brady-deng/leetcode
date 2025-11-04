package lc.listx2;

import java.util.Scanner;

/**
 * @author dengchenyang@tju.edu.cn
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 *
 * <a href=https://leetcode.com/problems/sudoku-solver/>refer</a>
 * <p>test cases:[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]</p>
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
