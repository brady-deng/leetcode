package main.java.lc.list;

import main.java.lc.util.LUtil;

/**
 * <p>
 *     Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 * </p>
 * <a href=https://leetcode.com/problems/subarray-product-less-than-k/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 * </p>
 * <p>
 *     1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231227
 **/
public class L713 {
    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        int k = LUtil.inputNum();
        System.out.println(new Solution().numSubarrayProductLessThanK(nums, k));
    }


    static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int low = 0;
            int count = 0;
            int pro = 1;
            for (int i=0; i<nums.length; i++) {
                pro *= nums[i];
                while (pro>=k && low<i) {
                    pro /= nums[low++];
                }
                if (pro<k) {
                    count += (i-low+1);
                }
            }
            return count;
        }
    }
}
