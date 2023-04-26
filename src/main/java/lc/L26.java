package main.java.lc;

import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
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
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
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
