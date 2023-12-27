package main.java.lc.list;

import main.java.lc.util.LUtil;

/**
 * <p>
 *     Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 * </p>
 * <a ref=https://leetcode.com/problems/maximum-subarray/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231226
 **/
public class Ali1226 {

    public static void main(String[] args) {
        int[] arr = LUtil.inputNums();
        System.out.println(new Ali1226().solution(arr));
    }


    class Interval {
        int start;
        int end;

        public  Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }


    // 1,2,5,12,-2,-3,3,4
    public Interval solution(int[] arr) {
        int start = 0;
        int end = start+1;
        int max = arr[start];
        int tmp = max;
        Interval res = new Interval(start, end);
        while (end < arr.length) {
            if (arr[end] > tmp+arr[end]) {
                start = end;
                end = start+1;
                tmp = arr[start];
            } else if (tmp+arr[end] >= tmp){
                tmp += arr[end];
                end++;
            } else if (tmp+arr[end] < tmp){
                start = end;
                end = start+1;
                tmp = arr[start];
            }
            if (tmp > max) {
                max = tmp;
                res = new Interval(start, end);
            }
        }
        return res;
    }
}
