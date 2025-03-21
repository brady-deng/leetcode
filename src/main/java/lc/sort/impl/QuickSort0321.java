package lc.sort.impl;

import main.java.lc.util.LUtil;

public class QuickSort0321 implements main.java.lc.sort.Sort {

    @Override
    public int[] sort(int[] nums) {
        partition(nums, 0, nums.length-1);
        return nums;
    }

    public void partition(int[] nums, int l, int r) {
        if (l < r) {
            int pi = quickSort(nums, l, r);
            partition(nums, l, pi-1);
            partition(nums, pi+1, r);
        }
    }

    public int quickSort(int[] nums, int l, int r) {
        int thre = nums[r];
        int pi = l;
        for (int i = l; i < r; i++) {
            if (nums[i] < thre) {
                swap(nums, pi, i);
                pi++;
            }
        }

        swap(nums, pi, r);
        return pi;
    }

    private void swap(int[] nums, int i, int j) {
        LUtil.swap(nums, i, j);
    }
}
