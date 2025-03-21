package lc.sort.impl;

import java.lang.reflect.Array;

public class MergeSort0321 implements main.java.lc.sort.Sort {

    @Override
    public int[] sort(int[] nums) {
        splitAndMerge(nums, 0, nums.length-1);
        return nums;
    }

    public void splitAndMerge(int[] nums, int l, int r) {
        int m = l+(r-l)/2;
        if (l < r) {
            splitAndMerge(nums, l, m);
            splitAndMerge(nums, m+1, r);
        }
        merge(nums, l, m, r);
    }

    public void merge(int[] nums, int l, int m, int r) {
        int[] tmp = new int[r - l+1];
        int i = l;
        int j = m+1;
        int k = 0;
        while (i <= m && j <= r) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= m) {
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }
        k = 0;
        for (i = l; i <= r; i++) {
            nums[i] = tmp[k++];
        }
    }
}
