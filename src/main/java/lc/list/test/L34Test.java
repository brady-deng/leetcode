package main.java.lc.list.test;

import main.java.lc.list.L34;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/5
 * <p>Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.</p>
 * <p></p>
 * <a href=https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/>ref</a>
 * <p>[5,7,7,8,8,10]
 * 8
 * [3,4]
 * </p>
 * <p>
 * [5,7,7,8,8,10]
 * 6
 * [-1,-1]
 * </p>
 * <p>
 * []
 * 0
 * [-1,-1]
 * </p>
 * <p>
 *     Medium
 * </p>
 **/
public class L34Test extends L34 {

    @Override
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        binarySearch(nums, target, 0, nums.length, res);
        return res;
    }

    public void binarySearch(int[] nums, int target, int start, int end, int[] res) {
        if (start >= end) {
            return;
        }
        int mid = start + (end-start)/2;
        if (nums[mid] < target) {
            binarySearch(nums, target, mid+1, end, res);
        } else if (nums[mid] > target) {
            binarySearch(nums, target, start, mid, res);
        } else {
            int l = mid;
            int r = mid;
            while (l >= 0 && nums[l] == target) {
                l--;
            }
            while (r < nums.length && nums[r] == target) {
                r++;
            }
            res[0] = l+1;
            res[1] = r-1;
            return;
        }
    }
}
