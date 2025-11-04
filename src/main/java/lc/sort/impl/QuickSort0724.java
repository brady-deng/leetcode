package lc.sort.impl;

import lc.sort.Sort;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 20230724
 **/
public class QuickSort0724 implements Sort {

    @Override
    public int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] sort, int start, int end) {
        if (start >= end) return;
        int low = partition(sort, start, end);
        quickSort(sort, start, low-1);
        quickSort(sort, low+1, end);
    }

    public int partition(int[] sort, int start, int end) {
        int threshold = sort[end];
        int low = start;
        for (int i = start; i < end; i++) {
            if (sort[i] < threshold) {
                int tmp = sort[i];
                sort[i] = sort[low];
                sort[low] = tmp;
                low++;
            }
        }
        sort[end] = sort[low];
        sort[low] = threshold;
        return low;
    }
}
