package lc.list.test;
//Given an integer array nums, rotate the array to the right by k steps, where
//k is non-negative.
//
//
// Example 1:
//
//
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//
//
// Example 2:
//
//
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation:
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁵
// -2³¹ <= nums[i] <= 2³¹ - 1
// 0 <= k <= 10⁵
//
//
//
// Follow up:
//
//
// Try to come up with as many solutions as you can. There are at least three
//different ways to solve this problem.
// Could you do it in-place with O(1) extra space?
//
//
// Related Topics Array Math Two Pointers 👍 17450 👎 1917


//leetcode submit region begin(Prohibit modification and deletion)
public class L189Test {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k==0) {
            return;
        }
        int i = 0;
        int l = nums.length - k;
        while (i < l/2) {
            swap(nums, i, l-i-1);
            i++;
        }
        i = l;
        while (i < l+k/2) {
            swap(nums, i, nums.length-(i-l)-1);
            i++;
        }
        i = 0;
        while (i < nums.length/2) {
            swap(nums, i, nums.length-i-1);
            i++;
        }
    }
    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
