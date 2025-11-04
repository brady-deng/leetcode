package lc.list;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
// Notice that the solution set must not contain duplicate triplets.
//
//
// Example 1:
//
//
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation:
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not
//matter.
//
//
// Example 2:
//
//
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//
//
// Example 3:
//
//
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
//
//
//
// Constraints:
//
//
// 3 <= nums.length <= 3000
// -10⁵ <= nums[i] <= 10⁵
//
//
// Related Topics Array Two Pointers Sorting 👍 30568 👎 2839


import lc.util.LUtil;

import javax.swing.plaf.LabelUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class L15 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L15().threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            recurFindRes(nums, i, i+1, nums.length-1, res);
        }
        return res;
    }
    public void recurFindRes(int[] nums, int l, int m, int r, List<List<Integer>> res) {
        while (m < r) {
            if (nums[l] + nums[m] + nums[r] == 0) {
                res.add(Arrays.asList(nums[l],nums[m],nums[r]));
                m++;
                r--;
                while (m < r && nums[m] == nums[m-1]) {
                    m++;
                }
                while (r > m && nums[r] == nums[r+1]) {
                    r--;
                }
            }
            else if (nums[l] + nums[m] + nums[r] > 0) {
                r--;
            } else {
                m++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
