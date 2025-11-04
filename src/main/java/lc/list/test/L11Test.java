package lc.list.test;

import lc.list.L11;

/**
 * <p>
 *     You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 * </p>
 * <a href=https://leetcode.com/problems/container-with-most-water/description/>ref</a>
 * <p>
 *     Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/24
 **/
public class L11Test extends L11 {
    @Override
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int res = 0;
        while (l < r) {
            int temp = Math.min(height[l], height[r]) * (r-l);
            res = Math.max(temp, res);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
