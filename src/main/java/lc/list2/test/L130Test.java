package lc.list2.test;

import lc.list2.L130;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date
 **/
public class L130Test extends L130 {

    @Override
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (board[i][j] == 'O' && isSurrounded(board, visited, i, j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public boolean isSurrounded(char[][] board, boolean[][] visited, int i, int j) {
        if (board[i][j] == 'O' && ((i == 0 || i == board.length-1) || (j == 0 || j == board[0].length-1))) {
            return false;
        } else {
            if (board[i][j] == 'X') {
                return true;
            }
            if (board[i][j] == 'O' && visited[i][j]) {
                return false;
            }
            visited[i][j] = true;
            return isSurrounded(board, visited, i-1, j)
                    && isSurrounded(board, visited, i+1, j)
                    && isSurrounded(board, visited, i, j+1)
                    && isSurrounded(board, visited, i, j-1);
        }
    }
}
