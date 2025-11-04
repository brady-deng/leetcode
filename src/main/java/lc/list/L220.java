package lc.list;

import lc.list.test.L220Test;
import lc.util.LUtil;

/**
 * <p>
 *     You are given an integer array nums and two integers indexDiff and valueDiff.
 *
 * Find a pair of indices (i, j) such that:
 *
 * i != j,
 * abs(i - j) <= indexDiff.
 * abs(nums[i] - nums[j]) <= valueDiff, and
 * Return true if such pair exists or false otherwise.
 * </p>
 * <a href=https://leetcode.com/problems/contains-duplicate-iii/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
 * Output: true
 * Explanation: We can choose (i, j) = (0, 3).
 * We satisfy the three conditions:
 * i != j --> 0 != 3
 * abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
 * abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
 * Example 2:
 *
 * Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
 * Output: false
 * Explanation: After trying all the possible pairs (i, j), we cannot satisfy the three conditions, so we return false.
 * </p>
 * <p>
 *     hard
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240102
 **/
public class L220 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        int indexDiff = LUtil.inputNum();
        int valueDiff = LUtil.inputNum();
        System.out.println(new L220().containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
        System.out.println(new L220Ans().containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
        System.out.println(new L220Test().containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < Math.min(nums.length, i + indexDiff+1); j++) {
                if (Math.abs(nums[j] - nums[i]) <= valueDiff) {
                    return true;
                }
            }
        }
        return false;
    }
}
