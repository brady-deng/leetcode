package main.java.lc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @description
 * @date 2021/7/4
 **/
public class L33 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please input the tar:");
        int tar = scanner.nextInt();

    }
    public int search(int[] nums, int target) {
        for (int i = 0;i<nums.length;i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
