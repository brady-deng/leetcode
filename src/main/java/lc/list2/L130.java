package main.java.lc.list2;

import main.java.lc.list2.test.L130Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 *
 * </p>
 * <a href=https://leetcode.com/problems/surrounded-regions/description/>ref</a>
 * <p>
 *     Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Notice that an 'O' should not be flipped if:
 * - It is on the border, or
 * - It is adjacent to an 'O' that should not be flipped.
 * The bottom 'O' is on the border, so it is not flipped.
 * The other three 'O' form a surrounded region, so they are flipped.
 * Example 2:
 *
 * Input: board = [["X"]]
 * Output: [["X"]]
 *
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/9
 **/
public class L130 {

    public boolean isO(char[][] board,
                       boolean[][] visited,
                       Boolean[][] res,
                       int m,
                       int n,
                       int i,
                       int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (visited[i][j] && res[i][j] != null) {
            return res[i][j];
        }
        visited[i][j] = true;
        if (board[i][j] == 'X') {
            return false;
        }
        if (board[i][j] == 'O') {
            if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                return true;
            }
        }
        return (!visited[i+1][j] && isO(board, visited, res, m, n, i+1, j))
                || (!visited[i-1][j] && isO(board, visited, res, m, n, i-1, j))
                || (!visited[i][j+1] && isO(board, visited, res, m, n, i, j+1))
                || (!visited[i][j-1] && isO(board, visited, res, m, n, i, j-1));

    }



    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited =new boolean[m][n];
        Boolean[][] res = new Boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = isO(board, visited, res, m, n, i, j);
                if (!res[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the m");
        int m = scanner.nextInt();
        System.out.println("Please input the n");
        int n = scanner.nextInt();
        char[][] sudoku = new char[m][n];
        System.out.println("Please input the sudoku:");
        scanner.nextLine();
        for (int i = 0; i<m; i++) {
            sudoku[i] = scanner.nextLine().toCharArray();
        }
//        L130 l130 = new L130();
//        l130.solve(sudoku);
        new L130Test().solve(sudoku);
        Arrays.stream(sudoku).forEach(item->{
            for (char s : item) {
                System.out.print(s);
                System.out.print(" ");
            }
            System.out.println();
        });
    }


}
