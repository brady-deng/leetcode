package lc.list;

import lc.list.test.L39Test;

import java.util.*;

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
public class L39 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please input the target:");
        int target = scanner.nextInt();
        System.out.println(new L39().combinationSum(nums, target));
        System.out.println(new L39Test().combinationSum(nums, target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combine(candidates, target, res, new ArrayList<>(), 0);
        return res;

    }
    public static void combine(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        else if (target < candidates[start]){
            return;
        }
        else {
            for (int i = start; i<candidates.length; i++) {
                if (candidates[i] <= target) {
                    tmp.add(candidates[i]);
                    target-=candidates[i];
                    combine(candidates, target, res, tmp, i);
                    target+=candidates[i];
                    tmp.remove(tmp.size()-1);
                }
                else {
                    return;
                }
            }
        }
    }
}
