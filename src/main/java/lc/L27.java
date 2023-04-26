package main.java.lc;

import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
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
