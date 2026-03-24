package main.java.lc.list.test;

import main.java.lc.list.L56Ans;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * </p>
 * <a href = https://leetcode.com/problems/merge-intervals/>ref</a>
 * <p>
 *     [[1,3],[2,6],[8,10],[15,18]] --> [[1,6],[8,10],[15,18]]
 * [[1,4],[4,5]] --> [[1,5]]
 * </p>
 * <p>
 *     start[], the count of start interval
 *     end[], the count of end interval
 *     sum, whether the internal has ended? if > 0, the internal has not ended, if - 0, the internal has ended
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/7
 **/
public class L56Test extends L56Ans {
    @Override
    public int[][] mergeInter(int[][] intervals) {
        int[] start = new int[10001];
        int[] end = new int[10001];
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][1], max);
            start[intervals[i][0]]++;
            end[intervals[i][1]]++;
        }
        List<int[]> res = new ArrayList<>();
        int[] t = {-1, -1};
        int tmp = 0;
        for (int i =0; i <= max; i++) {
            if (start[i] > 0) {
                if (tmp == 0) {
                    t[0] = i;
                }
                tmp += start[i];
            }
            if (end[i] > 0) {
                tmp -= end[i];
            }
            if (tmp == 0 && t[0] != -1) {
                t[1] = i;
                res.add(t);
                t = new int[]{-1, -1};
            }
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }



}
