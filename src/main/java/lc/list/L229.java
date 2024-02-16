package main.java.lc.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * </p>
 * <a href=https://leetcode.com/problems/majority-element-ii/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,2]
 * Output: [1,2]
 *
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2024/1/28
 **/
public class L229 {

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int threshold = n/3;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
            if (map.get(num) > threshold && !res.contains(num)) {
                res.add(num);
            }
        }
        return res;
    }
}
