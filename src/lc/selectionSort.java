package lc;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/3
 **/
public class selectionSort {

    public static int[] sort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = nums[temp];
            }
        }
        return nums;
    }
}
