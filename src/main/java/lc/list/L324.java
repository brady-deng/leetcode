package lc.list;

import lc.sort.impl.QuickSort;
import lc.util.LUtil;

import java.util.Arrays;

/**
 * <p>
 *     Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * You may assume the input array always has a valid answer.
 * </p>
 * <a href=https://leetcode.com/problems/wiggle-sort-ii/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums = [1,5,1,1,6,4]
 * Output: [1,6,1,5,1,4]
 * Explanation: [1,4,1,5,1,6] is also accepted.
 * Example 2:
 *
 * Input: nums = [1,3,2,2,3,1]
 * Output: [2,3,1,3,1,2]
 *
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2024/2/3
 **/
public class L324 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        int[] nums2 = LUtil.deepCloneNums(nums);
//        new L324().wiggleSort(nums);
//        LUtil.ourputString(nums);
        new L324().wiggleSort2(nums2);
        LUtil.printNums(nums2);
    }
    public void wiggleSort(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int mid = nums.length%2==0?nums.length/2:nums.length/2+1;
        new QuickSort().sort(nums);
        int[] numSmall = Arrays.copyOfRange(nums, 0, mid);
        int[] numLark = Arrays.copyOfRange(nums, mid, nums.length);
        int smallIndex = numSmall.length-1;
        int largeIndex = numLark.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = numSmall[smallIndex];
                smallIndex--;
            } else {
                nums[i] = numLark[largeIndex];
                largeIndex--;
            }
        }

    }


    public void wiggleSort2(int[] nums) {
        int mid = quickSortMid(nums, 0, nums.length);
        int largePos = 1; //Odd position from start for larger than median numbers
        int len = nums.length;
        int smallPos = len%2==0 ? len-2: len-1; //Even position from end for smaller than median numbers
        int cur = 0;
        while(cur<len) {
            //Avoiding already checked even positions from the end
            if(nums[cur]<mid && (cur<smallPos || (cur>=smallPos && cur%2!=0))) {
                swap(nums, cur, smallPos);
                smallPos-=2;
            }
            //Avoiding already checked odd positions from the start
            else if(nums[cur]>mid && (largePos<cur || (largePos>=cur && cur%2==0))) {
                swap(nums, cur, largePos);
                largePos+=2;
            }

            else cur++;
        }
    }

    public void swap (int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public int quickSortMid(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = partition(nums, start, end);
        int m = start + (end-start)/2;
        if (mid > m) {
            return quickSortMid(nums, start, mid);
        } else if (mid < m) {
            return quickSortMid(nums, mid+1, end);
        } else {
            return nums[mid];
        }
    }

    public int partition(int[] nums, int start, int end) {
        int par = start;
        int thre = nums[end-1];
        for (int i = start; i < end; i++) {
            if (nums[i] < thre) {
                int tmp = nums[i];
                nums[i] = nums[par];
                nums[par] = tmp;
                par++;
            }
        }

        int tmp = nums[par];
        nums[par] = nums[end-1];
        nums[end-1] = tmp;
        return par;
    }
}
