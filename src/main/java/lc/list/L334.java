package lc.list;

/**
 * <p>
 *     Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 * </p>
 * <a href=https://leetcode.com/problems/increasing-triplet-subsequence/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * Example 2:
 *
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 * Example 3:
 *
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2024/2/3
 **/
public class L334 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;


        for(int big : nums) {
            if(big <= small) {
                small = big;
            }
            else if(big <= mid) {
                mid = big;
            }
            else return true;
        }
        return false;
    }
}
