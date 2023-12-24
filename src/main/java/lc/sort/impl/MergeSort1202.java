package main.java.lc.sort.impl;

import main.java.lc.sort.Sort;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/2
 **/
public class MergeSort1202 implements Sort {


    @Override
    public int[] sort(int[] nums) {
        mergeSort(nums, 0, nums.length);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if ((right-left) > 2) {
            int mid = (right+left)/2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid, right);
        }
        merge(nums, left, (right+left)/2, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int l = left;
        int r = mid;
        int i = 0;
        int[] temp =new int[right-left];
        while (l < mid && r < right) {
            if (nums[l] <= nums[r]) {
                temp[i] = nums[l];
                l++;
                i++;
            } else {
                temp[i] = nums[r];
                r++;
                i++;
            }
        }
        while (l < mid) {
            temp[i] = nums[l];
            l++;
            i++;
        }
        while (r < right) {
            temp[i] = nums[r];
            i++;
            r++;
        }
        for (i = 0; i<temp.length;i++) {
            nums[i+left] = temp[i];
        }
    }
}
