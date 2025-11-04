package lc.list;

//Given an integer array nums of length n and an integer target, find three
//integers in nums such that the sum is closest to target.
//
// Return the sum of the three integers.
//
// You may assume that each input would have exactly one solution.
//
//
// Example 1:
//
//
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//
//
// Example 2:
//
//
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
//
//
//
// Constraints:
//
//
// 3 <= nums.length <= 500
// -1000 <= nums[i] <= 1000
// -10⁴ <= target <= 10⁴
//
//
// Related Topics Array Two Pointers Sorting 👍 10380 👎 562


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class L16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int[] tmp = new int[]{Integer.MAX_VALUE, target};
        for(int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            recurFindRes(nums, i, i+1, nums.length-1, tmp, target);
        }
        return tmp[1];
    }

    public void recurFindRes(int[] nums, int i, int l, int r, int[] tmp, int target) {
        while(l < r) {
            int cur = nums[i] + nums[l] + nums[r];
            int closet = Math.abs(cur-target);
            if(closet < tmp[0]) {
                tmp[0] = closet;
                tmp[1] = cur;
            }
            if(cur == target) {
                return;
            }
            else if(cur < target) {
                l++;
            } else {
                r--;
            }
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
