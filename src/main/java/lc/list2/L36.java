package main.java.lc.list2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/6
 * <p>Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.</p>
 *
 * <a href=https://leetcode.com/problems/valid-sudoku/></a>
 * <p>[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * [["8","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]</p>
 **/
public class L36 {
    public static void main(String[] args) {
        System.out.println("Please input the sudoku:");
        Scanner scanner = new Scanner(System.in);
        int m = 9, n = 9;
        char[][] sudoku = new char[m][n];

        for (int i = 0; i<m; i++) {
            sudoku[i] = scanner.nextLine().toCharArray();
        }
        System.out.println(isValidSudoku(sudoku));
    }
    public static boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (!isValidArray(board[i])) {
                return false;
            }
        }
        char[][] tmp = formatSudoku(board);
        for (int i = 0; i<m; i++) {
            if (!isValidArray(tmp[i])) {
                return false;
            }
        }
        char[][] tran = tranSudoku(board);
        for (int i = 0; i<m; i++) {
            if (!isValidArray(tran[i])) {
                return false;
            }
        }
        return true;

    }

    public static boolean isValidArray(char[] array) {
        Map<Character, Integer> map = new HashMap<>();
        for (char item:array) {
            if (map.containsKey(item)) {
                return false;
            }
            else if (item!='.'){
                map.put(item,1);
            }
        }
        return true;
    }

    public static char[][] formatSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        char[][] res = new char[m][n];
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                res[i/3*3+j/3][(i-i/3*3)*3+(j-j/3*3)] = board[i][j];
            }
        }
        return res;
    }

    public static char[][] tranSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i<m; i++) {
            for (int j = i+1; j<n; j++) {
                char tmp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = tmp;
            }
        }
        return board;
    }
}
