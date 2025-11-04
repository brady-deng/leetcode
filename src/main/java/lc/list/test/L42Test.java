package lc.list.test;

import lc.list.L42;

/**
 *
 * <p>
 *     Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * </p>
 * <a href = https://leetcode.com/problems/trapping-rain-water/>ref</a>
 * <p>
 *     [0,1,0,2,1,0,1,3,2,1,2,1] 6
 *     </p>
 *     <p>
 * [4,2,0,3,2,5] 9
 * </p>
 * <p>
 *     hard
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/18
 **/
public class L42Test extends L42 {

    @Override
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int lm = 0;
        for (int i = 0; i < height.length; i++) {
            lm = Math.max(height[i], lm);
            leftMax[i] = lm;
        }
        int rm = 0;
        for (int j = height.length -1; j > -1; j--) {
            rm = Math.max(height[j], rm);
            rightMax[j] = rm;
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

}
