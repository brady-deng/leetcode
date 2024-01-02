package main.java.lc.list;

import main.java.lc.util.LUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *     Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 * </p>
 * <a href=https://leetcode.com/problems/combination-sum-iii/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 *
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240102
 **/
public class L216 {

    public static void main(String[] args) {
        int k = LUtil.inputNum();
        int n = LUtil.inputNum();
        System.out.println(new L216().combinationSum3(k, n));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] rec = new boolean[10];
        List<List<Integer>> res = new ArrayList<>();
        doCombine(k, n, rec, new ArrayList<>(), res, new HashSet<>());
        return res;
    }

    public void doCombine(int k,
                          int n,
                          boolean[] rec,
                          List<Integer> cur,
                          List<List<Integer>> res,
                          Set<Set<Integer>> dup) {
        if (k == 0 && n == 0 && !dup.contains(new HashSet<>(cur))) {
            res.add(new ArrayList<>(cur));
            dup.add(new HashSet<>(cur));
        } else if (k >0 && n > 0){
            for (int j = 9; j > 0; j--) {
                if (!rec[j]) {
                    rec[j] = true;
                    cur.add(j);
                    doCombine(k-1, n-j, rec, cur, res, dup);
                    cur.remove(cur.size()-1);
                    rec[j] = false;
                }
            }
        }
    }
}

