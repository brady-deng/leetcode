package main.java.lc.list;

import java.util.Scanner;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * <p></p>
 * <p>case:[3,2,2,3]
 * 3
 * [0,1,2,2,3,0,4,2]
 * 2</p>
 * <a href=https://leetcode.com/problems/remove-element/>refer</a>
 * @author dengchenyang@tju.edu.cn
 * @description
 * @date 2021/7/4
 **/
public class L27 {
    public static void main(String[] args) {
        System.out.println("Please input the count of nums:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i<n; i++) {
            System.out.println("Please input the num:");
            nums[i] = scanner.nextInt();
        }
        System.out.println("Please input the val:");
        int val = scanner.nextInt();
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length > 1){
            int res = 0;
            Integer prev = null;
            for (int i = 0; i<nums.length; i++) {
                if (nums[i] != val) {
                    nums[res] = nums[i];
                    res += 1;
                }
            }
            return res;
        }
        else if (nums.length == 1 && nums[0] != val) return 1;
        else {
            return 0;
        }
    }
}
