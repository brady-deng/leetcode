package lc.list;

import lc.util.LUtil;

/**
 * <p>
 *     Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 *
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 * </p>
 * <a href=https://leetcode.com/problems/combination-sum-iv/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Example 2:
 *
 * Input: nums = [9], target = 3
 * Output: 0
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240216
 **/
public class L377 {
    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        int target = LUtil.inputNum();
        System.out.println(new L377().combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }



}
