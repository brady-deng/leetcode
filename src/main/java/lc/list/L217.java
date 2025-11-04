package lc.list;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * </p>
 * <a href=https://leetcode.com/problems/contains-duplicate/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240102
 **/
public class L217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }
}
