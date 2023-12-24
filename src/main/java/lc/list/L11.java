package main.java.lc.list;

import main.java.lc.util.LUtil;

import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2023/12/24
 **/
public class L11 {

    public static void main(String[] args) {
        int[] height = LUtil.inputNums();
        System.out.println(new L11().maxArea(height));
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
