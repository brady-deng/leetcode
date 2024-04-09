package main.java.lc.list2.test;

import main.java.lc.list2.L48;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date
 **/
public class L48Test extends L48 {

    @Override
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int up = 0;
        int down = n-1;
        int l = 0;
        int r = n-1;
        while (up  < down) {
            for (int i = l; i < r; i++) {
                int tmp = matrix[up][i];
                matrix[up][i] = matrix[up+(i-l)][r];
                matrix[up+(i-l)][r] = tmp;
            }
            for (int i = r; i > l; i--) {
                int tmp = matrix[down][i];
                matrix[down][i] = matrix[down-(r-i)][l];
                matrix[down-(r-i)][l] = tmp;
            }
            for (int i = l; i < r; i++) {
                int tmp = matrix[up][i];
                matrix[up][i] = matrix[down][r-(i-l)];
                matrix[down][r-(i-l)] = tmp;
            }
            up++;
            down--;
            l++;
            r--;
        }
    }
}
