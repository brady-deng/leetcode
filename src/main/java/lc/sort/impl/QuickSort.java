package main.java.lc.sort.impl;


import main.java.lc.common.util.ArrayUtil;
import main.java.lc.sort.Sort;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/3
 **/
public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] sort) {
        this.sort(sort, 0, sort.length);
        return sort;
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pi = partition(nums, start, end);
        sort(nums, start, pi);
        sort(nums, pi+1, end);
    }

    public static int partition(int[] nums, int start, int end) {
        int low = start;
        int thre = nums[end-1];
        for (int i = start; i < end; i++) {
            if (nums[i] < thre) {
                ArrayUtil.swap(nums, low, i);
                low++;
            }
        }
        ArrayUtil.swap(nums, low, end-1);
        return low;
    }
}
