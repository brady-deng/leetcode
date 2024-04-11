package main.java.lc.list2.test;

import main.java.lc.list2.L378;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date
 **/
public class L378Test extends L378 {

    @Override
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0];
        int r = matrix[matrix.length-1][matrix[0].length-1];
        while (l < r) {
            int mid = l + (r-l)/2;
            int c = getCount(matrix, mid);
            if (c < k) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }



    public int getCount(int[][] matrix, int mid) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length-1; j > -1; j--) {
                if (matrix[i][j] <= mid) {
                    res+=(j+1);
                    break;
                }
            }
        }
        return res;
    }
}
