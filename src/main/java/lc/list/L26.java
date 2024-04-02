package main.java.lc.list;

import java.util.Scanner;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * <p></p>
 * cases:[1,1,2]
 * [0,0,1,1,1,2,2,3,3,4]
 * <a href=https://leetcode.com/problems/remove-duplicates-from-sorted-array/>refer</a>
 * @author dengchenyang@tju.edu.cn
 * @description
 * @date 2021/7/4
 **/
public class L26 {
    public static void main(String[] args) {
        System.out.println("Please input the count of nums:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i<n; i++) {
            System.out.println("Please input the num:");
            nums[i] = scanner.nextInt();
        }
        System.out.println(new L26().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int res = 0;
        Integer prev = null;
        for (int i = 0; i<nums.length; i++) {
            if (i == 0) {
                prev = nums[i];
                res += 1;
            }
            else if (prev != nums[i]) {
                nums[res] = nums[i];
                res+=1;
                prev = nums[i];
            }
        }
        return res;
    }
}
