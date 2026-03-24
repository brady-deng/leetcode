package main.java.lc.Dtest;

import main.java.lc.list.L1477Ans;
import main.java.lc.util.LUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     You are given an array of integers arr and an integer target.
 *
 * You have to find two non-overlapping sub-arrays of arr each with a sum equal target. There can be multiple answers so you have to find an answer where the sum of the lengths of the two sub-arrays is minimum.
 *
 * Return the minimum sum of the lengths of the two required sub-arrays, or return -1 if you cannot find such two sub-arrays.
 * </p>
 * <a href=https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: arr = [3,2,2,4,3], target = 3
 * Output: 2
 * Explanation: Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.
 * Example 2:
 *
 * Input: arr = [7,3,4,7], target = 7
 * Output: 2
 * Explanation: Although we have three non-overlapping sub-arrays of sum = 7 ([7], [3,4] and [7]), but we will choose the first and third sub-arrays as the sum of their lengths is 2.
 * Example 3:
 *
 * Input: arr = [4,3,2,6,2,3,4], target = 6
 * Output: -1
 * Explanation: We have only one sub-array of sum = 6.
 * </p>
 * <p>
 *     [1,6,1]->[-1]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240216
 **/
public class L1477Test {

    public static void main(String[] args) {
        int[] arr = LUtil.inputNums();
        int target = LUtil.inputNum();
        System.out.println(new L1477Ans.Solution().minSumOfLengths(arr, target));
        System.out.println(new L1477Test().minSumOfLengths(arr, target));
    }
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(sum, i);
        }
        int cur = 0;
        // l1 >= l2
        int l1 = 0, l2 = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            if (map.containsKey(cur - target)) {
                int preInd = map.get(cur - target);
                int l = i - preInd;
                if (l1 == 0) {
                    l1 = l;
                } else if (l2 == 0) {
                    if (l1 >= l) {
                        l2 = l;
                    } else {
                        l2 = l1;
                        l1 = l;
                    }
                } else {
                    if (l <= l1 && l >l2) {
                        l1 = l;
                    } else {
                        l1 = l2;
                        l2 = l;
                    }
                }
            }
        }
        if (l1 != 0 && l2 != 0) {
            return l1+l2;
        } else {
            return -1;
        }
    }
}
