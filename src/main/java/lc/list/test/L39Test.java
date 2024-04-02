package main.java.lc.list.test;

import main.java.lc.list.L39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/7
 *
 * <p>Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.</p>
 *
 * <a href=https://leetcode.com/problems/combination-sum/>ref</a>
 * <p>[2,3,6,7]
 * 7
 * [[2,2,3],[7]]
 * </p>
 * <p>
 * [2,3,5]
 * 8
 * [[2,2,2,2],[2,3,3],[3,5]]
 * </p>
 * <p>
 * [2]
 * 1
 * []</p>
 * <p>
 *     Medium
 * </p>
 **/
public class L39Test extends L39 {

    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        findRes(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    public void findRes(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
        } else if (target > 0){
            for (int i = start; i < candidates.length; i++) {
                cur.add(candidates[i]);
                findRes(candidates, target-candidates[i], res, cur, i);
                cur.remove(cur.size()-1);
            }
        }
    }
}
