package lc;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/3
 **/
public class quickSort {
    public static void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pi = partition(nums, start, end);
        sort(nums, start, pi);
        sort(nums, pi+1, end);
    }

    public static int partition(int[] nums, int start, int end) {
        int low = start;
        int thre = nums[end-1];
        for (int i = start; i < end; i++) {
            if (nums[i] < thre) {
                int temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                low++;
            }
        }
        int temp = nums[low];
        nums[low] = thre;
        nums[end-1] = temp;
        return low;
    }
}
