package lc.list2;

import java.util.Scanner;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/9
 **/
public class L36Ans {

    public static void main(String[] args) {
        System.out.println("Please input the sudoku:");
        Scanner scanner = new Scanner(System.in);
        int m = 9, n = 9;
        char[][] sudoku = new char[m][n];

        for (int i = 0; i<m; i++) {
            sudoku[i] = scanner.nextLine().toCharArray();
        }
        System.out.println(Solution.isValidSudoku(sudoku));
    }

    static class Solution {
        public static boolean isValidSudoku(char[][] board) {
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(board[i][j]=='.') continue;
                    char num = board[i][j];
                    board[i][j] = '.';
                    if(isTrue(board,i,j,num)==false) return false;
                    board[i][j] = num;
                }
            }
            return true;
        }
        public static boolean isTrue(char[][] board, int row, int col, char num){
            //check row
            for(int j=0;j<9;j++){
                if(board[row][j] == num) return false;
            }
            //check column
            for(int i=0;i<9;i++){
                if(board[i][col]== num) return false;
            }
            //check 3x3 grid
            int sr = (row/3)*3;
            int sc = (col/3)*3;
            for(int i = sr;i<sr+3;i++){
                for(int j = sc;j<sc+3;j++){
                    if(board[i][j] == num) return false;
                }
            }
            return true;
        }
    }
}
