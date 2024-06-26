package main.java.lc.list;

import main.java.lc.list.test.L34Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/5
 * <p>Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.</p>
 * <p></p>
 * <a href=https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/>ref</a>
 * <p>[5,7,7,8,8,10]
 * 8
 * [3,4]
 * </p>
 * <p>
 * [5,7,7,8,8,10]
 * 6
 * [-1,-1]
 * </p>
 * <p>
 * []
 * 0
 * [-1,-1]
 * </p>
 * <p>
 *     Medium
 * </p>
 **/
public class L34 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please input the target:");
        int target = scanner.nextInt();
        System.out.println(Arrays.toString(new L34().searchRange(nums, target)));
        System.out.println(Arrays.toString(new L34Test().searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length > 0) {
            int m = binarySearch(nums, target, 0, nums.length-1);
            if (m == -1) {
                return new int[]{-1,-1};
            }
            else {
                int l = m,h = m;
                while (l >= 0 && nums[l] == target) {
                    l--;
                }
                while (h >= 0 && h < nums.length && nums[h] == target) {
                    h++;
                }
                return new int[]{l+1,h-1};
            }
        }
        else {
            return new int[]{-1,-1};
        }
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        if (right-left>0) {
            int m = left+(right-left)/2;
            if (nums[m] > target) {
                return binarySearch(nums, target, left, m-1);
            }
            else if (nums[m] < target) {
                return binarySearch(nums, target, m+1, right);
            }
            else {
                return m;
            }
        }
        else {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }
    }


}
