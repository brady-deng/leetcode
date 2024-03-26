package main.java.lc.list;

import main.java.lc.sort.impl.QuickSort;
import main.java.lc.util.LUtil;

import java.util.Arrays;

/**
 * <p>
 *     Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * You may assume the input array always has a valid answer.
 * </p>
 * <a ref=https://leetcode.com/problems/wiggle-sort-ii/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,5,1,1,6,4]
 * Output: [1,6,1,5,1,4]
 * Explanation: [1,4,1,5,1,6] is also accepted.
 * Example 2:
 *
 * Input: nums = [1,3,2,2,3,1]
 * Output: [2,3,1,3,1,2]
 *
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2024/2/3
 **/
public class L324 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        new L324().wiggleSort(nums);
        LUtil.ourputString(nums);
    }
    public void wiggleSort(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int mid = nums.length%2==0?nums.length/2:nums.length/2+1;
        new QuickSort().sort(nums);
        int[] numSmall = Arrays.copyOfRange(nums, 0, mid);
        int[] numLark = Arrays.copyOfRange(nums, mid, nums.length);
        int smallIndex = numSmall.length-1;
        int largeIndex = numLark.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = numSmall[smallIndex];
                smallIndex--;
            } else {
                nums[i] = numLark[largeIndex];
                largeIndex--;
            }
        }

    }
}
