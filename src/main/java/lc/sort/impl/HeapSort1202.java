package main.java.lc.sort.impl;

import main.java.lc.sort.Sort;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/2
 **/
public class HeapSort1202 implements Sort {

    @Override
    public int[] sort(int[] nums) {
        for (int i = nums.length/2; i > -1; i--) {
            buildMax(nums, i, nums.length);
        }
        for (int i = nums.length; i > 0; i--) {
            heapSort(nums, 0, i);
        }
        return nums;
    }

    public void heapSort(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end-1];
        nums[end-1] = temp;
        buildMax(nums, start, end-1);
    }

    public void buildMax(int[] nums, int root, int end) {
        int l = (root<<1)+1;
        int r = (root<<1)+2;
        if (r < end) {
            if (nums[l] > nums[r]) {
                if (nums[l] > nums[root]) {
                    int temp = nums[root];
                    nums[root] = nums[l];
                    nums[l] = temp;
                    buildMax(nums, l, end);
                }
            } else {
                if (nums[r] > nums[root]) {
                    int temp = nums[root];
                    nums[root] = nums[r];
                    nums[r] = temp;
                    buildMax(nums, r, end);
                }
            }
        } else if (l < end) {
            if (nums[l] > nums[root]) {
                int temp = nums[root];
                nums[root] = nums[l];
                nums[l] = temp;
                buildMax(nums, l, end);
            }
        }
    }
}
