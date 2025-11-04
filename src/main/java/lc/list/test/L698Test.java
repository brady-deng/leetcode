package lc.list.test;

import lc.list.L698;

import java.util.Arrays;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date
 **/
public class L698Test extends L698 {

    @Override
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum % k != 0) {
            return false;
        } else {
            int ava = sum/k;
            int[] buckets = new int[k];
            Arrays.sort(nums);
            return recurFillBuckets(nums, nums.length-1, buckets, ava);
        }
    }

    public boolean recurFillBuckets(int[] nums, int ind, int[] buckets, int target) {
        if (ind == -1) {
            return true;
        }
        for (int j = 0; j < buckets.length; j++) {
            if (buckets[j] + nums[ind] <= target) {
                buckets[j] += nums[ind];
                if (recurFillBuckets(nums, ind-1, buckets, target)) {
                    return true;
                }
                buckets[j] -= nums[ind];
            }
            if (buckets[j] == 0) {
                break;
            }
        }
        return false;
    }
}
