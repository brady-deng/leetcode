package lc.list;

import lc.util.LUtil;

/**
 * <p>
 *     An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 *
 * A subarray is a contiguous subsequence of the array.
 * </p>
 * <a href=https://leetcode.com/problems/arithmetic-slices/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 0
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240208
 **/
public class L413 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L413().numberOfArithmeticSlices(nums));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int[] prev = new int[nums.length];
        for (int i = 1; i < prev.length; i++) {
            prev[i] = nums[i] - nums[i-1];
        }
        int i = 1, j = 2;
        int ans = 0;
        while (i <= prev.length-2) {
            int c = 2;
            while (j < prev.length && prev[j] == prev[i]) {
                j++;
                c++;
            }
            if (c > 2) {
                ans += (c-1)*(c-2)/2;
            }
            i = j;
            j += 1;
        }
        return ans;
    }
}
