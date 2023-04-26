package main.java.lc;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/29
 **/
public class L162 {
    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L162().findPeakElement(nums));
    }


    public int findPeakElement(int[] nums) {
        return recurFindPeak(nums, 0, nums.length-1);
    }

    public int recurFindPeak(int[] nums, int left, int right) {
        if (left == right) return left;
        else if (left+1 == right) {
            if (nums[left] > nums[right]) {
                return left;
            }
            else {
                return right;
            }
        }
        else if (right > left) {
            int mid = left + (right-left)/2;
            if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if (nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1]) {
                return recurFindPeak(nums, mid+1, right);
            }
            else if (nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1]) {
                return recurFindPeak(nums, 0, mid-1);
            }
            else {
                int res1 = recurFindPeak(nums, 0, mid-1);
                int res2 = recurFindPeak(nums, mid+1, right);
                if (res1 != -1) return res1;
                else return res2;
            }
        }
        else {
            return -1;
        }
    }
}
