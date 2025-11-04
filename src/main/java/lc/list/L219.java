package lc.list;

import lc.util.LUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * </p>
 * <a href=https://leetcode.com/problems/contains-duplicate-ii/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240102
 **/
public class L219 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        int k = LUtil.inputNum();
        System.out.println(new L219().containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                if (i - list.get(list.size()-1) <= k) {
                    return true;
                }
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        return false;
    }
}
