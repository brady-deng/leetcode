//package main.java.lc.list.test;
//
//import main.java.lc.list.L57;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * <p>
// *     You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
// *
// * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
// *
// * Return intervals after the insertion.
// * </p>
// * <a href = https://leetcode.com/problems/insert-interval/>ref</a>
// * <p>
// *     [[1,3],[6,9]]
// * [2,5]
// *  [[1,5],[6,9]]
// *
// *
// * [[1,2],[3,5],[6,7],[8,10],[12,16]]
// * [4,8]
// *  [[1,2],[3,10],[12,16]]
// * </p>
// * @author dengchenyang@tju.edu.cn
// * @date 2021/7/8
// **/
//public class L57Test extends L57 {
//
//    @Override
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        int[] start = new int[100001];
//        int[] end = new int[100001];
//        int max = 0;
//        for (int i = 0; i < intervals.length; i++) {
//            start[intervals[i][0]]++;
//            end[intervals[i][1]]++;
//            max = Math.max(max, intervals[i][1]);
//        }
//        start[newInterval[0]]++;
//        end[newInterval[1]]++;
//        max = Math.max(max, newInterval[1]);
//        List<int[]> res = new ArrayList<>();
//        for (int i = 0; i <= max; i++) {
//            if (start[i] > 0) {
//                int[] tmp = new int[2];
//                tmp[0] = i;
//                int temp = 0;
//                while (true) {
//                    if (start[i] > 0) {
//                        temp+=start[i];
//                    }
//                    if (end[i] > 0) {
//                        temp-=end[i];
//                    }
//                    if (temp == 0) {
//                        tmp[1] = i;
//                        res.add(tmp);
//                        break;
//                    }
//                    i++;
//                }
//            }
//        }
//        int[][] ans = new int[res.size()][2];
//        for (int i = 0; i < ans.length; i++) {
//            ans[i] = res.get(i);
//        }
//        return ans;
//    }
//
//
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        int l = -1;
//        boolean fl = false;
//        int r = -1;
//        boolean fr = false;
//        for (int i = 0; i < intervals.length; i++) {
//            if (newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
//                l = i;
//                fl = true;
//            } else if (i < intervals.length-1 && newInterval[0] > intervals[i][1] && newInterval[0] < intervals[i+1][0]) {
//                l = i;
//                fl =false;
//            }
//            if (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {
//                r = i;
//                fr = true;
//            } else if (i < intervals.length-1 && newInterval[1] > intervals[i][1] && newInterval[1] < intervals[i+1][0]) {
//                r = i;
//                fr =false;
//            }
//        }
//        if (l == -1 && r == -1 && newInterval[0] > intervals[intervals.length-1][1]) {
//            int[][] ans = new int[intervals.length+1][2];
//            for (int i = 0; i < intervals.length; i++) {
//                ans[i] = intervals[i];
//            }
//            ans[ans.length-1] = newInterval;
//            return ans;
//        } else if (l == -1 && r == -1 && newInterval[1] < intervals[intervals.length-1][0]) {
//            int[][] ans = new int[intervals.length+1][2];
//            for (int i = 0; i < intervals.length; i++) {
//                ans[i+1] = intervals[i];
//            }
//            ans[0] = newInterval;
//            return ans;
//        } else {
//            if (!fl && !fr) {
//                int[][] ans = new int[intervals.length+1][2];
//                for (int i = 0; i < intervals.length; i++) {
//                    if (i)
//                    ans[i] = intervals[i];
//                }
//                ans[0] = newInterval;
//                return ans;
//            }
//        }
//    }
//}
