package main.java.lc.list.test;

import main.java.lc.list.L152;

/**
 * <p>
 *     Given an integer array nums, find a
 * subarray
 *  that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * </p>
 * <a href = https://leetcode.com/problems/maximum-product-subarray/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231127
 **/
public class L152Test extends L152 {

    @Override
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int min = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = Math.max(max * nums[i], nums[i]);
                min = Math.min(min * nums[i], nums[i]);
            } else {
                int t = max;
                max = Math.max(min * nums[i], nums[i]);
                min = Math.min(t * nums[i], nums[i]);
            }
            res = Math.max(max, res);
        }
        return res;
    }
}
