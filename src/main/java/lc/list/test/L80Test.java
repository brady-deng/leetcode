package lc.list.test;

import lc.list.L80;

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
public class L80Test extends L80 {

    @Override
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        int i = 1;
        int tmp = 1;
        int cur = nums[0];
        while (i < len) {
            if (nums[i] == cur) {
                tmp++;
            } else {
                tmp = 1;
                cur = nums[i];
            }
            if (tmp > 2) {
                int l = i, r = i+1;
                while (r < len && nums[r] == cur) {
                    r++;
                }
                for (int j = r; j < len; j++) {
                    nums[l+j-r] = nums[j];
                }
                len -= (r-l);
            } else {
                i++;
            }
        }
        return len;
    }


}
