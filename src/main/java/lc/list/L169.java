package main.java.lc.list;

/**
 * <p>
 *     Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * </p>
 * <a href=https://leetcode.com/problems/majority-element/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2023/11/25
 **/
public class L169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
