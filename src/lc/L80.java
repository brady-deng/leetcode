package lc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
