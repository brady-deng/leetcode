package main.java.lc.list.test;

import main.java.lc.list.L646;

import java.util.Arrays;

/**
 * @author dengchenyang@tju.edu.cn
 * @date
 **/
public class L646Test extends L646 {

    @Override
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2)->{
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return 1;
            }
        });
        int res = 1;
        int prev = pairs[pairs.length-1][0];
        for (int i = pairs.length-2; i > -1; i--) {
            if (pairs[i][1] < prev) {
                res++;
                prev = pairs[i][0];
            }
        }
        return res;
    }
}
