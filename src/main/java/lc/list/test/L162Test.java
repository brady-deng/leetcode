package lc.list.test;

import lc.list.L162;

/**
 * <p>
 *     A peak element is an element that is strictly greater than its neighbors.
 *
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 *
 * You must write an algorithm that runs in O(log n) time.
 * </p>
 * <a href=https://leetcode.com/problems/find-peak-element/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * </p>
 * <p>
 *     Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/29
 **/
public class L162Test extends L162 {
    @Override
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] res = new int[1];
        findPeak(nums, 0, nums.length, nums.length, res);
        return res[0];
    }

    public void findPeak(int[] nums, int start, int end, int l, int[] res) {
        if (start >= end) {
            return;
        } else {
            int mid = start+(end-start-1)/2;
            if (mid == 0) {
                if (nums[mid] > nums[mid+1]) {
                    res[0] = mid;
                    return;
                }
            } else if (mid == l-1) {
                if (nums[mid] > nums[mid-1]) {
                    res[0] = mid;
                    return;
                }
            } else {
                if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                    res[0] = mid;
                    return;
                }
            }
            findPeak(nums, start, mid, l, res);
            findPeak(nums, mid+1, end, l, res);
        }

    }
}
