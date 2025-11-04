package lc.sort.impl;

import lc.sort.Sort;

public class quickSort0807 implements Sort {



    @Override
    public int[] sort(int[] sort) {
        quickSort(sort, 0, sort.length);
        return sort;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pi = partition(nums, start, end);
        quickSort(nums, start, pi);
        quickSort(nums, pi+1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int low = start;
        int threshold = nums[end-1];
        for (int i = start; i < end; i++) {
            if (nums[i] < threshold) {
                int tmp = nums[i];
                nums[i] = nums[low];
                nums[low] = tmp;
                low++;
            }
        }

        nums[end-1] = nums[low];
        nums[low] = threshold;
        return low;
    }
}
