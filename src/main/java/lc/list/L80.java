package main.java.lc.list;

import java.util.Arrays;
import java.util.Scanner;


/**
 * <p>
 *     Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * </p>
 * <a href = https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/>ref</a>
 * <p>
 *     [1,1,1,2,2,3] 5
 * [0,0,1,1,1,1,2,3,3] 7
 * </p>
 */
public class L80 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int res = 1;
        int tmp = 1;
        if (nums.length > 1) {
            for (int i = 1; i< nums.length; i++) {
                if (nums[i] != prev) {
                    tmp = 1;
                    prev = nums[i];
                    nums[res] = nums[i];
                    res++;
                }
                else {
                    tmp+=1;
                    if (tmp < 3) {
                        nums[res] = nums[i];
                        res++;
                    }
                }
            }
        }
        return res;

    }
}
