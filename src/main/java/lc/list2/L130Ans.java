package main.java.lc.list2;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/10
 **/
public class L130Ans {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                recur(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                recur(board, i, n-1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                recur(board, 0, j);
            }
            if (board[m-1][j] == 'O') {
                recur(board, m-1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void recur(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'E';
        recur(board, i, j+1);
        recur(board, i, j-1);
        recur(board, i+1, j);
        recur(board, i-1, j);
    }
}
