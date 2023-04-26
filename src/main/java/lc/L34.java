package main.java.lc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/5
 **/
public class L34 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please input the target:");
        int target = scanner.nextInt();
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
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
