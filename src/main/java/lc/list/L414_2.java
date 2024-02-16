package main.java.lc.list;

import main.java.lc.util.LUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *     Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
 * </p>
 * <a href=https://leetcode.com/problems/third-maximum-number/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * Example 2:
 *
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 *
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240209
 **/
public class L414_2 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L414_2().thirdMax(nums));
    }

    /**
     * max1 > max2 > max3
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        for (int num : nums) {
            if (!tmp.contains(num)) {
                tmp.add(num);
            }
        }
        if (tmp.size() < 3) {
            return Collections.max(tmp);
        }
        int[] ns = tmp.stream().mapToInt(Integer::intValue).toArray();
        quickSort(ns, 0, ns.length, ns.length-3);
        return ns[ns.length-3];

    }

    public void quickSort(int[] nums, int start, int end, int thre) {
        int par = partition(nums, start, end);
        if (par == thre) {
            return;
        }
        else if (par < thre) {
            quickSort(nums, par, end, thre);
        } else {
            quickSort(nums, start, par, thre);
        }
    }

    public int partition(int[] nums, int start, int end) {
        int thre = nums[end-1];
        int ind = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < thre) {
                int tmp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = tmp;
                ind++;
            }
        }
        int tmp = nums[ind];
        nums[ind] = nums[end-1];
        nums[end-1] = tmp;
        return ind;
    }
}
