package main.java.lc.sort.impl;

import main.java.lc.sort.Sort;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 20230725
 **/
public class QuickSort0725 implements Sort {

    @Override
    public int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pi = partition(nums, start, end);
        quickSort(nums, start, pi-1);
        quickSort(nums, pi+1, end);
    }

    public int partition(int[] sort, int start, int end) {
        int thre = sort[end];
        int low = start;
        for (int i = start; i < end; i++) {
            if (sort[i] < thre) {
                int tmp = sort[i];
                sort[i] = sort[low];
                sort[low] = tmp;
                low++;
            }
        }
        sort[end] = sort[low];
        sort[low] = thre;
        return low;

    }
}
