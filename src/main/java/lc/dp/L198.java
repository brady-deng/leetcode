package main.java.lc.dp;

/**
 * <p>
 *     You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * </p>
 * <a href=https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231215
 **/
public class L198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return nums[1]>nums[0]?nums[1]:nums[0];
        } else {
            int[] res = new int[nums.length];
            res[0] = nums[0];
            res[1] = nums[1]>nums[0]?nums[1]:nums[0];
            for (int i = 2; i < n; i++) {
                res[i] = Math.max(res[i-1], res[i-2]+nums[i]);
            }
            return Math.max(res[n-1], res[n-2]);
        }
    }
}
