package lc.list;

import lc.util.LUtil;

/**
 * <p>
 *     Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * </p>
 * <a href=https://leetcode.com/problems/max-consecutive-ones/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 * </p>
 * <p>
 *     Easy
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240209
 **/
public class L485 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L485().findMaxConsecutiveOnes(nums));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                c++;
            } else {
                res = Math.max(res, c);
                c = 0;
            }
        }
        res = Math.max(res, c);
        return res;
    }
}
