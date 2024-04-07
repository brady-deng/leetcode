package main.java.lc.list;

import main.java.lc.list.test.L152Test;
import main.java.lc.util.LUtil;

/**
 * <p>
 *     Given an integer array nums, find a
 * subarray
 *  that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * </p>
 * <a href = https://leetcode.com/problems/maximum-product-subarray/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231127
 **/
public class L152 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L152Test().maxProduct(nums));
    }

    /**
     * <a href=https://leetcode.com/problems/maximum-product-subarray/solutions/1608862/java-3-solutions-detailed-explanation-using-image/>ref</a>
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int temp = max;  // store the max because before updating min your max will already be updated

            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            if (max > ans) {
                ans = max;
            }
        }

        return ans;
    }
}
