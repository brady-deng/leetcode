package lc.sort.impl;

import lc.sort.Sort;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/2
 **/
public class QuickSort1202 implements Sort {


    @Override
    public int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length);
        return nums;
    }


    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int mi = partition(nums, start, end);
            quickSort(nums, start, mi);
            quickSort(nums, mi+1, end);
        }
    }

    public static int partition(int[] nums, int start, int end) {
        int thre = nums[end-1];
        int ind = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < thre) {
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                ind++;
            }
        }
        int temp = nums[ind];
        nums[ind] = nums[end-1];
        nums[end-1] = temp;
        return ind;




    }
}
