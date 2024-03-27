package main.java.mytest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 * </p>
 * <a href = https://leetcode.com/problems/insert-interval/>ref</a>
 * <p>
 *     [[1,3],[6,9]]
 * [2,5]
 *  [[1,5],[6,9]]
 *
 *
 * [[1,2],[3,5],[6,7],[8,10],[12,16]]
 * [4,8]
 *  [[1,2],[3,10],[12,16]]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/8
 **/
public class L57test {
    public static void main(String[] args) {
        System.out.println("Please input the interval length:");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[][] intervals = new int[m][2];
        scanner.nextLine();
        for (int i = 0; i<m; i++) {
            System.out.println("Please input the interval:");
            intervals[i] = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }
        int[] newInterval = new int[2];
        System.out.println("Please input the new interval:");
        newInterval = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    /**
     * to fill in
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ans = new int[2][2];
        return ans;
    }


    /**
     * <p>
     *     start, the index of new start to insert
     *     end, the index of new end to insert
     *     if start == end, no other intervals
     *     if start != end, exist other intervals
     * </p>
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insertAns(int[][] intervals, int[] newInterval) {
        int i = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            i++;
        }
        int start = i;

        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            i++;
        }

        int end = i;
        int curIntervalCounter = 0;
        int[][] finalIntervals = new int[intervals.length - end + start + 1][];

        for (curIntervalCounter = 0; curIntervalCounter < start; curIntervalCounter++) {
            int[] interval = new int[2];
            interval[0] = intervals[curIntervalCounter][0];
            interval[1] = intervals[curIntervalCounter][1];
            finalIntervals[curIntervalCounter] = interval;
        }

        if (start == end) {
            int[] interval = new int[2];
            interval[0] = newInterval[0];
            interval[1] = newInterval[1];
            finalIntervals[curIntervalCounter++] = interval;
        } else {
            int[] mergedInterval = new int[2];
            mergedInterval[0] = Math.min(newInterval[0], intervals[start][0]);
            mergedInterval[1] = Math.max(newInterval[1], intervals[end - 1][1]);
            finalIntervals[curIntervalCounter++] = mergedInterval;
        }

        for (int j = end; j < intervals.length; j++) {
            int[] interval = new int[2];
            interval[0] = intervals[j][0];
            interval[1] = intervals[j][1];
            finalIntervals[curIntervalCounter++] = interval;
        }

        return finalIntervals;
    }
}
