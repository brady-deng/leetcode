package lc.list.test;

import lc.list.L41;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/18
 * <p>Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.</p>
 *
 * <a href=https://leetcode.com/problems/first-missing-positive/>ref</a>
 * <p>[1,2,0]
 * 3
 * </p>
 * <p>
 *     [3,4,-1,1]
 *  2
 * </p>
 * <p>
 *  [7,8,9,11,12]
 *  1
 * </p>
 *
 **/
public class L41Test extends L41 {

    @Override
    public int firstMissingPositive(int[] nums) {
        for (int l = 0; l < nums.length; l++) {
            while (nums[l] > 0 && nums[l] < nums.length && nums[nums[l]-1] != nums[l]) {
                swap(nums, l, nums[l]-1);
            }
        }
        for (int l = 0; l < nums.length; l++) {
            if (nums[l] != l+1) {
                return l+1;
            }
        }
        return nums.length+1;
    }

    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
