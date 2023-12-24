package main.java.lc.list;

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
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/7
 **/
public class L56Ans {
    public static int[][] mergeInter(int[][] intervals) {
        int[] start = new int[10001];
        int[] end = new int[10001];
        int max = 0;
        for(int[] interval: intervals){
            start[interval[0]]++;
            end[interval[1]]++;
            max = Math.max(max,interval[1]);
        }
        List<int[]> list = new ArrayList();
        int sum = 0;
        for(int i = 0; i <= max; i++){
            if(start[i] > 0){
                int[] temp = new int[2];
                // temp[0] start ind after merge
                temp[0] = i;
                while(true){
                    sum += start[i];
                    sum -= end[i];
                    if(sum == 0)
                        break;
                    i++;
                }
                // temp[1] end ind after merge
                temp[1] = i;
                list.add(temp);
            }
        }
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
