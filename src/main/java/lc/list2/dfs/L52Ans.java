package main.java.lc.list2.dfs;

/**
 * <p>
 *     The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * </p>
 * <a href=https://leetcode.com/problems/n-queens-ii/>ref</a>
 * <p>
 *     4->2, 1->1
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/18
 **/
public class L52Ans {
    private int res;


    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[2*n];
        boolean[] dia2 = new boolean[2*n];
        dfs(  0, n, col, dia1, dia2);
        return res;
    }
    private void dfs(  int row, int n, boolean[] col, boolean[] dia1, boolean[] dia2){
        if (row == n){
            res++;
            return;
        }
        for (int i = 0; i < n; i++){
            if (col[i] || dia1[row+i] || dia2[i-row+n]) continue;




            col[i] = true;
            dia1[row+i] = true;
            dia2[i-row+n] = true;

            dfs(  row + 1, n, col, dia1, dia2);


            col[i] = false;
            dia1[row+i] = false;
            dia2[i-row+n] = false;
        }
    }
}
