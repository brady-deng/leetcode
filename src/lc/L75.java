package lc;

import java.util.Arrays;
import java.util.Scanner;

public class L75 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        mySort(nums, 0 , nums.length-1);
    }
    public static void mySort(int[] nums, int l, int r) {
        if (l < r) {
            int pi = partition(nums, 0, r);
            mySort(nums, l, pi-1);
            mySort(nums, pi+1, r);
        }
    }
    public static int partition(int[] nums, int l, int r) {
        int i = l;
        int pivot = nums[r];
        for (int j = i; j < r; j++) {
            if (nums[j] <= pivot) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i+=1;
            }
        }
        int tmp = nums[r];
        nums[r] = nums[i];
        nums[i] = tmp;
        return i;
    }
}
