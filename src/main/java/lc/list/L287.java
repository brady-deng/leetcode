package main.java.lc.list;

/**
 * <p>
 *     Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * </p>
 * <a href=https://leetcode.com/problems/find-the-duplicate-number/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2024/1/28
 **/
public class L287 {
    public int findDuplicate(int[] nums) {
        int res = 0;
        int c = 0;
        for (int num: nums) {
            if (num != res && c== 0) {
                res = num;
                c=1;
            } else if (num == res) {
                return num;
            } else {
                c--;
            }
        }
        return res;
    }
}
