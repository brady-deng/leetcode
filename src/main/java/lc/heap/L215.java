package main.java.lc.heap;

import main.java.lc.list.L274;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 * </p>
 * <a href=https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2023/12/4
 **/
public class L215 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        System.out.println("input k:");
        int k = scanner.nextInt();
        System.out.println(new L215().findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        for (int i = nums.length/2; i > -1; i--) {
            buildMax(nums, i, nums.length);
        }
        for (int i = 0; i<k; i++) {
            int temp = nums[0];
            nums[0] = nums[nums.length-1-i];
            nums[nums.length-1-i] = temp;
            buildMax(nums, 0, nums.length-1-i);
        }
        return nums[nums.length-k];

    }

    public void buildMax(int[] nums, int root, int end) {
        int l = (root<<1)+1;
        int r = (root<<1)+2;
        int largest = root;
        if (l < end && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < end && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != root) {
            int temp = nums[root];
            nums[root] = nums[largest];
            nums[largest] = temp;
            buildMax(nums, largest, end);
        }
    }
}
