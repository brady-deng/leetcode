package lc.list.test;

import lc.list.L53;

/**
 * <p>
 *     Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 * </p>
 * <a href=https://leetcode.com/problems/maximum-subarray/description/>ref</a>
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
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231226
 **/
public class L53Test extends L53 {


    @Override
    public Interval maxSubArray(int[] nums) {
        Interval res = new Interval(0 ,0, 0);
        res.setVal(maxSubArray2(nums));
        return res;
    }

    public int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = nums[0];
        int cur = 0;
        int r = 0;
        while (r < nums.length) {
            cur += nums[r];
            res = Math.max(res, cur);
            if (cur < 0) {
                r++;
                cur = 0;
            } else {
                r++;
            }
        }
        return res;
    }


}
