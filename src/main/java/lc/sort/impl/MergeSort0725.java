package lc.sort.impl;

import lc.sort.Sort;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 20230725
 **/
public class MergeSort0725 implements Sort {
    @Override
    public int[] sort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length-1);
        return temp;
    }
    public void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left < right) {
            int tMid = (left+right) >> 1;
            mergeSort(nums, temp, left, tMid);
            mergeSort(nums, temp, tMid+1, right);
            merge(nums, temp, left, tMid, right);
        }
    }

    public void merge(int[] nums, int[] temp, int left, int mid, int right) {
        int k = 0;
        int i = left;
        int j = mid+1;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }
        for (i = left; i <= right; i++) {
            nums[i] = temp[i-left];
        }
    }
}
