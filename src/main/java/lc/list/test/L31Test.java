package main.java.lc.list.test;

import main.java.lc.list.L31;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * The replacement must be in place and use only constant extra memory.
 *
 * <p>case:[1,2,3]
 * [3,2,1]
 * [1,1,5]</p>
 * <a href=https://leetcode.com/problems/next-permutation/>refer</a>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/5
 **/
public class L31Test extends L31 {

    @Override
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int ind = -1;
        for (int i = nums.length-2; i > -1; i--) {
            if (nums[i] < nums[i+1]) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            reverse(nums, 0);
        } else {
            int ind2 = ind+1;
            for (int i = nums.length-1; i > ind; i--) {
                if (nums[i] > nums[ind]) {
                    ind2 = i;
                    break;
                }
            }
            swap(nums, ind, ind2);
            reverse(nums, ind+1);
        }
    }

    public void reverse(int[] nums, int start) {
        int l = start;
        int r = nums.length-1;
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
