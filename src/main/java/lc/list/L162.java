package main.java.lc.list;

import main.java.lc.util.LUtil;

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
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/29
 **/
public class L162 {
    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L162().findPeakElement(nums));
    }


    public int findPeakElement(int[] nums) {
        return recurFindPeak(nums, 0, nums.length-1);
    }

    public int recurFindPeak(int[] nums, int left, int right) {
        if (left == right) return left;
        else if (left+1 == right) {
            if (nums[left] > nums[right]) {
                return left;
            }
            else {
                return right;
            }
        }
        else if (right > left) {
            int mid = left + (right-left)/2;
            if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if (nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1]) {
                return recurFindPeak(nums, mid+1, right);
            }
            else if (nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1]) {
                return recurFindPeak(nums, 0, mid-1);
            }
            else {
                int res1 = recurFindPeak(nums, 0, mid-1);
                int res2 = recurFindPeak(nums, mid+1, right);
                if (res1 != -1) return res1;
                else return res2;
            }
        }
        else {
            return -1;
        }
    }
}
