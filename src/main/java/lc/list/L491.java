package main.java.lc.list;

import main.java.lc.util.LUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.
 * </p>
 * <a href=https://leetcode.com/problems/non-decreasing-subsequences/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * Example 2:
 *
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240216
 **/
public class L491 {

    public List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L491().findSubsequences(nums));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        recurFind(nums, 0, new ArrayList<>(), Integer.MIN_VALUE);
        return res;
    }

    public void recurFind(int[] nums, int ind, List<Integer> cur, int previous) {
        if (ind == nums.length ) {
            if (cur.size() > 1) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        if (nums[ind] >= previous) {
            cur.add(nums[ind]);
            recurFind(nums, ind + 1, cur, nums[ind]);
            cur.remove(cur.size() - 1);
        }
        if (nums[ind] == previous) {
            return;
        }
        recurFind(nums, ind + 1, cur, previous);
    }
}
