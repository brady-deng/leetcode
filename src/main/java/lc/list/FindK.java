package main.java.lc.list;

import main.java.lc.util.LUtil;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2024/2/3
 **/
public class FindK<T extends Comparable<T>> {


    public void findLarge(T[] nums, int n) {
        if (nums.length <= n) {
            return;
        }
        quickSortLarge(nums, 0, nums.length, n);
    }

    public void quickSortLarge(T[] nums, int start, int end, int k) {

        int par = partitionLarge(nums, start, end);
        if (par == k) {
            return;
        }
        if (par > k) {
            quickSortLarge(nums, start, par, k);
        } else {
            quickSortLarge(nums, par+1, end, k);
        }

    }


    public void findSmall(T[] nums, int n) {
        if (nums.length <= n) {
            return;
        }
        quickSortSmall(nums, 0, nums.length, n);
    }

    public void quickSortSmall(T[] nums, int start, int end, int k) {

        int par = partitionSmall(nums, start, end);
        if (par == k) {
            return;
        }
        if (par > k) {
            quickSortSmall(nums, start, par, k);
        } else {
            quickSortSmall(nums, par+1, end, k);
        }

    }


    public int partitionSmall(T[] nums, int start, int end) {
        T thre = nums[end-1];
        int par = start;
        for (int i = start; i < end-1; i++) {
            if (nums[i].compareTo(thre) <= 0) {
                T tmp = nums[i];
                nums[i] = nums[par];
                nums[par] = tmp;
                par++;
            }
        }
        nums[end-1] = nums[par];
        nums[par] = thre;
        return par;
    }

    public int partitionLarge(T[] nums, int start, int end) {
        T thre = nums[end-1];
        int par = start;
        for (int i = start; i < end-1; i++) {
            if (nums[i].compareTo(thre) >= 0) {
                T tmp = nums[i];
                nums[i] = nums[par];
                nums[par] = tmp;
                par++;
            }
        }
        nums[end-1] = nums[par];
        nums[par] = thre;
        return par;
    }
}
