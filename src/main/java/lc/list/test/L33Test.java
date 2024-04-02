package main.java.lc.list.test;

import main.java.lc.list.L33;

/**
 * @author dengchenyang@tju.edu.cn
 * @description
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *</p>
 * <a href=https://leetcode.com/problems/search-in-rotated-sorted-array/>refer</a>
 * <p>test cases:</p>
 * <p>[4,5,6,7,0,1,2]
 * 0
 * 4
 * </p>
 * <p>
 * [4,5,6,7,0,1,2]
 * 3
 * -1
 * </p>
 * <p>
 * [1]
 * 0
 * -1
 * </p>
 * <p>
 *     Medium
 * </p>
 * @date 2021/7/4
 **/
public class L33Test extends L33 {

    @Override
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        if (nums[l] > nums[r]) {
            if (target > nums[r] && target < nums[l]) {
                return -1;
            } else if (target == nums[l]) {
                return l;
            } else if (target > nums[l]) {
                while (l < r) {
                    if (nums[l] < target && nums[l+1] > nums[l]) {
                        l++;
                    } else if (nums[l] == target) {
                        return l;
                    } else {
                        return -1;
                    }
                }
            } else if (target == nums[r]) {
                return r;
            } else {
                while (r > l) {
                    if (nums[r] > target && nums[r-1] < nums[r]) {
                        r--;
                    } else if (nums[r] == target) {
                        return r;
                    } else {
                        return -1;
                    }
                }
            }
        } else {
            while (l < nums.length) {
                if (nums[l] < target) {
                    l++;
                } else if (nums[l] == target) {
                    return l;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }
}
