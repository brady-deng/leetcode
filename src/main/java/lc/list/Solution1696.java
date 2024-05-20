package main.java.lc.list;//You are given a 0-indexed integer array nums and an integer k.
//
// You are initially standing at index 0. In one move, you can jump at most k
//steps forward without going outside the boundaries of the array. That is, you can
//jump from index i to any index in the range [i + 1, min(n - 1, i + k)]
//inclusive.
//
// You want to reach the last index of the array (index n - 1). Your score is
//the sum of all nums[j] for each index j you visited in the array.
//
// Return the maximum score you can get.
//
//
// Example 1:
//
//
//Input: nums = [1,-1,-2,4,-7,3], k = 2
//Output: 7
//Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (
//underlined above). The sum is 7.
//
//
// Example 2:
//
//
//Input: nums = [10,-5,-2,4,0,3], k = 3
//Output: 17
//Explanation: You can choose your jumps forming the subsequence [10,4,3] (
//underlined above). The sum is 17.
//
//
// Example 3:
//
//
//Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
//Output: 0
//
//
//
// Constraints:
//
//
// 1 <= nums.length, k <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
//
//
// Related Topics Array Dynamic Programming Queue Heap (Priority Queue)
//Monotonic Queue 👍 3389 👎 112


import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1696 {
    public int maxResult(int[] nums, int k) {
        int[] res = new int[nums.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = nums[i];
                deque.push(i);
            } else {
                res[i] = res[deque.peek()]+nums[i];
                while (!deque.isEmpty() && res[deque.getLast()] < res[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);
                if (!deque.isEmpty() && (i-deque.peek()) == k) {
                    deque.pop();
                }
            }
        }
        return res[res.length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
