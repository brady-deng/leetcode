package lc.list;

import lc.list.test.L11Test;
import lc.util.LUtil;

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
public class L11 {

    public static void main(String[] args) {
        int[] height = LUtil.inputNums();
        System.out.println(new L11().maxArea(height));
        System.out.println(new L11Test().maxArea(height));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxWater = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int tmp = h*(right-left);
            maxWater = Math.max(tmp, maxWater);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
