package lc.sort.impl;


import lc.common.util.ArrayUtil;
import lc.sort.Sort;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/3
 **/
public class BubbleSort implements Sort {
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j] > nums[j+1]) {
                    ArrayUtil.swap(nums, j, j+1);
                }
            }
        }
        return nums;
    }
}
