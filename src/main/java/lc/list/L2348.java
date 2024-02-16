package main.java.lc.list;

import main.java.lc.util.LUtil;

/**
 * <p>
 *     Given an integer array nums, return the number of subarrays filled with 0.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * </p>
 * <a href=https://leetcode.com/problems/number-of-zero-filled-subarrays/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,3,0,0,2,0,0,4]
 * Output: 6
 * Explanation:
 * There are 4 occurrences of [0] as a subarray.
 * There are 2 occurrences of [0,0] as a subarray.
 * There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
 * Example 2:
 *
 * Input: nums = [0,0,0,2,0,0]
 * Output: 9
 * Explanation:
 * There are 5 occurrences of [0] as a subarray.
 * There are 3 occurrences of [0,0] as a subarray.
 * There is 1 occurrence of [0,0,0] as a subarray.
 * There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.
 * Example 3:
 *
 * Input: nums = [2,10,2019]
 * Output: 0
 * Explanation: There is no subarray filled with 0. Therefore, we return 0.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240208
 **/
public class L2348 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L2348().zeroFilledSubarray(nums));
    }
    public long zeroFilledSubarray(int[] nums) {
        long start = -1;
        long end = -1;
        long ans = 0;
        long i = 0;
        while (i < nums.length) {
            if (nums[(int) i] == 0l) {
                start = i;
                end = i;
                while (end < nums.length && nums[(int)end] == 0) {
                    end++;
                }
                i = end;
                ans += (end - start) * (end - start + 1) / 2;
            }
            i++;
        }
        return ans;
    }
}
