package main.java.lc.list;

import main.java.lc.util.LUtil;

/**
 * <p>
 *     Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 * </p>
 * <a href=https://leetcode.com/problems/partition-equal-subset-sum/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240214
 **/
public class L416 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L416().canPartition(nums));
    }



    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum%2!=0) {
            return false;
        }

        int target = sum/2;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target+1];
        for (int num=0; num < n; num++) {
            dp[num][0] = true;
        }
        // dp[i][j], whether can nums[0:i] can reach the target
        for (int i = 1; i < nums.length+1; i++) {
            for (int j=1; j<target+1; j++) {
                dp[i][j] = (j-nums[i-1] >= 0 && dp[i-1][j-nums[i-1]]) || dp[i-1][j];
            }
        }
        return dp[n][target];
    }
}
