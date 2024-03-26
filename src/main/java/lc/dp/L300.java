package main.java.lc.dp;

import java.util.*;

/**
 * <p>
 *     Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * .
 * </p>
 * <a href=https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/4
 **/
public class L300 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        System.out.println(new L300().lengthOfLIS(nums));
    }

    /**
     * res[i] represents the length of the longest increasing subsequence ending with nums[i]
     * tmp[i] represents the smallest number of the longest increasing subsequence ending with nums[i]
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        // tmp subsequece of nums
        int[] tmp = new int[nums.length+1];
        tmp[0] = Integer.MIN_VALUE;
        tmp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tmp[res[i-1]]) {
                res[i] = res[i-1]+1;
                tmp[res[i]] = nums[i];
            } else {
                res[i] = res[i-1];
                for (int j = res[i]; j > 0; j--) {
                    if (nums[i] < tmp[j] && nums[i] > tmp[j-1]) {
                        tmp[j] = nums[i];
                        break;
                    }
                }
            }
        }
        return res[nums.length-1];

    }

}
