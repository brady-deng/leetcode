package main.java.lc.sort.impl;

import main.java.lc.common.util.ArrayUtil;
import main.java.lc.sort.Sort;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/3
 **/
public class SelectionSort implements Sort {

    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                ArrayUtil.swap(nums, i, min);
            }
        }
        return nums;
    }
}
