package main.java.lc.list;

import main.java.lc.util.LUtil;

/**
 * <p>
 *     Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * </p>
 * <a href=https://leetcode.com/problems/minimum-size-subarray-sum/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240102
 **/
public class L209 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        int target = LUtil.inputNum();
        System.out.println(new L209().minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 1;
        int sum = nums[start];
        int res = Integer.MAX_VALUE;
        while (start < end && end < nums.length) {
            if (sum >= target) {
                res = Math.min(res, end-start);
                sum-=nums[start];
                start++;
            } else {
                sum+=nums[end];
                end++;
            }
        }
        while (sum >= target) {
            res = Math.min(res, end-start);
            sum-=nums[start];
            start++;
        }
        return res == Integer.MAX_VALUE? 0: res;
    }
}
