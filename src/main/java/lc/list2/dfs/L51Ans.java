package main.java.lc.list2.dfs;

import java.util.*;

/**
 * <p>
 *     The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * </p>
 * <a href=https://leetcode.com/problems/n-queens/description/>ref</a>
 * <p>
 *     4->[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/18
 **/
public class L51Ans {


    public List<List<String>> solveNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[2*n];
        boolean[] dia2 = new boolean[2*n];
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res,new ArrayList<String>(), 0, n, col, dia1, dia2);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> list, int row, int n, boolean[] col, boolean[] dia1, boolean[] dia2){
        if (row == n){
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = 0; i < n; i++){
            if (col[i] || dia1[row+i] || dia2[i-row+n]) continue;

            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);

            list.add(rowString);
            col[i] = true;
            dia1[row+i] = true;
            dia2[i-row+n] = true;

            dfs(res, list, row + 1, n, col, dia1, dia2);

            list.remove(list.size() - 1);
            col[i] = false;
            dia1[row+i] = false;
            dia2[i-row+n] = false;
        }
    }
}
