package lc.list;

import lc.list.test.L80Test;
import lc.util.LUtil;


/**
 * <p>
 *     Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * </p>
 * <a href = https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/>ref</a>
 * <p>
 *     [1,1,1,2,2,3] 5
 * [0,0,1,1,1,1,2,3,3] 7
 * </p>
 * <p>
 *     Medium
 * </p>
 */
public class L80 {
    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        int[] nums2 = LUtil.deepCloneNums(nums);
        System.out.println(new L80().removeDuplicates(nums));
        LUtil.printNums(nums);
        System.out.println(new L80Test().removeDuplicates(nums2));
        LUtil.printNums(nums2);
    }
    public int removeDuplicates(int[] nums) {
        // prev unique value
        int prev = nums[0];
        int res = 1;
        // duplicate count
        int tmp = 1;
        if (nums.length > 1) {
            for (int i = 1; i< nums.length; i++) {
                if (nums[i] != prev) {
                    tmp = 1;
                    prev = nums[i];
                    nums[res] = nums[i];
                    res++;
                }
                else {
                    tmp+=1;
                    if (tmp < 3) {
                        nums[res] = nums[i];
                        res++;
                    }
                }
            }
        }
        return res;

    }
}
