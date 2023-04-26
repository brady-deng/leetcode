package main.java.lc;

import java.util.*;

/**
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
