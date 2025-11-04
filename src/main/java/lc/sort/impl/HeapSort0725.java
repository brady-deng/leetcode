package lc.sort.impl;

import lc.sort.Sort;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 20230728
 **/
public class HeapSort0725 implements Sort {

    @Override
    public int[] sort(int[] nums) {
        maxHeap(nums, nums.length);
        for (int i = nums.length-1;i>0;i--){
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            heapFy(nums, 0, 1,2,i);
        }
        return nums;
    }

    public void maxHeap(int[] nums, int end) {
        for (int i = end>>1;i>-1;i--) {
            heapFy(nums, i, (i<<1)+1, (i<<1)+2, end);
        }

    }

    public void heapFy(int[] nums, int root, int left, int right, int end) {
        int largest = root;
        if (left < end && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < end && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != root) {
            int tmp = nums[root];
            nums[root] = nums[largest];
            nums[largest] = tmp;
            heapFy(nums, largest, (largest<<1)+1, (largest<<1)+2,end);
        }
    }
}
