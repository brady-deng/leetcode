package lc.list;

import lc.util.LUtil;

import java.util.*;

/**
 * <p>
 *     Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 * </p>
 * <a href=https://leetcode.com/problems/largest-divisible-subset/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,2]
 * Explanation: [1,3] is also accepted.
 * Example 2:
 *
 * Input: nums = [1,2,4,8]
 * Output: [1,2,4,8]
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240216
 **/
public class L368 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L368().largestDivisibleSubset(nums));
        System.out.println(new L368Ans().largestDivisibleSubset(nums));
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int resSize = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);
            if (tmp.size() > resSize) {
                resSize = tmp.size();
                res = tmp;
            }
            map.put(nums[i], tmp);
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                if (nums[i] % entry.getKey() == 0 && nums[i] != entry.getKey()) {
                    tmp = new ArrayList<>(entry.getValue());
                    tmp.add(nums[i]);
                    if (tmp.size() > resSize) {
                        resSize = tmp.size();
                        res = tmp;
                    }
                    if (tmp.size() > map.getOrDefault(nums[i], new ArrayList<>()).size()) {
                        map.put(nums[i], tmp);
                    }
                }
            }
        }
        return res;
    }
}
