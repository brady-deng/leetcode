package main.java.lc;

import java.util.Arrays;
import java.util.Scanner;

public class L81 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please input the target:");
        int target = scanner.nextInt();
        System.out.println(search(nums, target));
    }
    public static boolean search(int[] nums, int target) {
        for (int item:nums) {
            if (item == target) {
                return true;
            }
        }
        return false;
    }
}
