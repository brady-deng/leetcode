package lc.list;

//Given an array nums of n integers, return an array of all the unique
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
//
//
// You may return the answer in any order.
//
//
// Example 1:
//
//
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//
// Example 2:
//
//
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 200
// -10⁹ <= nums[i] <= 10⁹
// -10⁹ <= target <= 10⁹
//
//
// Related Topics Array Two Pointers Sorting 👍 11207 👎 1372


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class L18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        for(int i = 0; i < nums.length-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            threeSum(nums, i, target, res);
        }
        return res;

    }
    public void threeSum(int[] nums, int start, int tar, List<List<Integer>> res) {
        for (int i = start+1; i < nums.length-2; i++) {
            if(i > start+1 && nums[i] == nums[i-1]) continue;
            recurFindRes(nums, start, i, i+1, nums.length-1, res, tar);
        }
    }
    public void recurFindRes(int[] nums, int start, int l, int m, int r, List<List<Integer>> res, int tar) {
        while (m < r) {
            long tmp = (long)nums[start]+nums[l]+nums[m]+nums[r];
            long t = (long) tar;
            if (tmp == t) {
                res.add(Arrays.asList(nums[start],nums[l],nums[m],nums[r]));
                m++;
                r--;
                while (m < r && nums[m] == nums[m-1]) {
                    m++;
                }
                while (r > m && nums[r] == nums[r+1]) {
                    r--;
                }
            }
            else if (tmp > t) {
                r--;
            } else {
                m++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

