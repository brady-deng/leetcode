package main.java.lc.list;

import main.java.lc.util.LUtil;

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
public class L414 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L414().thirdMax(nums));
    }

    /**
     * max1 > max2 > max3
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        // first
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (int num : nums) {
            if (max1 == null) {
                max1 = num;
            } else {
                if (num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                } else if (num < max1){
                    if (max2 == null || num > max2) {
                        max3 = max2;
                        max2 = num;
                    } else if ((max3 == null && num < max2) || (max3 != null && num > max3 && num < max2)) {
                        max3 = num;
                    }
                }
            }
        }
        if (max3 != null) {
            return max3;
        } else {
            return max1;
        }

    }
}
