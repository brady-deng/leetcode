package main.java.lc.list;

/**
 * <p>
 *     Given an integer array nums containing distinct positive integers, find and return any number from the array that is neither the minimum nor the maximum value in the array, or -1 if there is no such number.
 *
 * Return the selected integer.
 * </p>
 * <a href=https://leetcode.com/problems/neither-minimum-nor-maximum/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [3,2,1,4]
 * Output: 2
 * Explanation: In this example, the minimum value is 1 and the maximum value is 4. Therefore, either 2 or 3 can be valid answers.
 * Example 2:
 *
 * Input: nums = [1,2]
 * Output: -1
 * Explanation: Since there is no number in nums that is neither the maximum nor the minimum, we cannot select a number that satisfies the given condition. Therefore, there is no answer.
 * Example 3:
 *
 * Input: nums = [2,1,3]
 * Output: 2
 * Explanation: Since 2 is neither the maximum nor the minimum value in nums, it is the only valid answer.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240214
 **/
public class L2733 {
    public int findNonMinOrMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        boolean flagMin = false;
        boolean flagMax = false;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
                flagMin = true;
            }
            if (num > max) {
                max = num;
                flagMax = true;
            }
        }
        for (int num : nums) {
            if (min != max && flagMax && flagMin && num != min && num != max) {
                return num;
            }
        }
        return -1;
    }
}
