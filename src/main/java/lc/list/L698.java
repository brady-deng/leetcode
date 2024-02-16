package main.java.lc.list;

import main.java.lc.util.LUtil;

import java.util.Arrays;

/**
 * <p>
 *     Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 * </p>
 * <a href=https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [4,3,2,3,5,2,1], k = 4
 * Output: true
 * Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Example 2:
 *
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240214
 **/
public class L698 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        int k = LUtil.inputNum();
        System.out.println(new L698().canPartitionKSubsets(nums, k));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num: nums) {
            sum+=num;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        return partitionKBuckets(nums, sum/k, nums.length-1, new int[k]);

    }

    public boolean partitionKBuckets(int[] nums, int target, int l, int[] buckets) {
        if (l == -1) {
            return true;
        }
        for (int j = 0; j < buckets.length; j++) {
            if (buckets[j] + nums[l] <= target) {
                buckets[j] += nums[l];
                if (partitionKBuckets(nums, target, l-1, buckets)) {
                    return true;
                }
                buckets[j] -= nums[l];
            }
            if (buckets[j] == 0) {
                break;
            }
        }
        return false;
    }
}
