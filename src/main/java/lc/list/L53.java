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
public class L53 {

    static class Interval {
        int start;
        int end;

        int val;

        public  Interval(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    ", val=" + val +
                    '}';
        }
    }


    public static void main(String[] args) {
        int[] arr = LUtil.inputNums();
        System.out.println(new L53.Solution().maxSubArray(arr));
    }

    static class Solution {
        public Interval maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
            int currentSum = 0;
            int start = 0;
            int end = 1;
            Interval res = new Interval(start, end, 0);

            for (int i = 0; i < nums.length; i++) {
                currentSum += nums[i];
                end = i;

                if (currentSum > maxSum) {
                    res = new Interval(start, end, currentSum);
                    maxSum = currentSum;
                }

                if (currentSum < 0) {
                    currentSum = 0;
                    start = i;
                    end = start;
                }
            }

            return res;
        }
    }
}
