package lc.list;
//You are given a 0-indexed integer array nums and an integer k. You have a
//starting score of 0.
//
// In one operation:
//
//
// choose an index i such that 0 <= i < nums.length,
// increase your score by nums[i], and
// replace nums[i] with ceil(nums[i] / 3).
//
//
// Return the maximum possible score you can attain after applying exactly k
//operations.
//
// The ceiling function ceil(val) is the least integer greater than or equal to
//val.
//
//
// Example 1:
//
//
//Input: nums = [10,10,10,10,10], k = 5
//Output: 50
//Explanation: Apply the operation to each array element exactly once. The
//final score is 10 + 10 + 10 + 10 + 10 = 50.
//
//
// Example 2:
//
//
//Input: nums = [1,10,3,3,3], k = 3
//Output: 17
//Explanation: You can do the following operations:
//Operation 1: Select i = 1, so nums becomes [1,4,3,3,3]. Your score increases
//by 10.
//Operation 2: Select i = 1, so nums becomes [1,2,3,3,3]. Your score increases
//by 4.
//Operation 3: Select i = 2, so nums becomes [1,1,1,3,3]. Your score increases
//by 3.
//The final score is 10 + 4 + 3 = 17.
//
//
//
// Constraints:
//
//
// 1 <= nums.length, k <= 10⁵
// 1 <= nums[i] <= 10⁹
//
//
// Related Topics Array Greedy Heap (Priority Queue) 👍 384 👎 9


import lc.util.LUtil;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2530 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        int k = LUtil.inputNum();
        System.out.println(new Solution2530().maxKelements2(nums, k));
    }

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2-o1);
        long res = 0;
        for (int num: nums) {
            q.add(num);
        }
        int c = 0;
        while (c < k) {
            int tmp = q.poll();
            res+=tmp;
            q.add((int) Math.ceil(((double) tmp)/3));
            c++;
        }
        return res;
    }

    public long maxKelements2(int[] nums, int k) {
        long res = 0;
        heapSort(nums);
        int c = 0;
        while (c < k) {
            res+=nums[0];
            nums[0] = (int) Math.ceil((double) nums[0]/3);
            doHeapHigh(nums, 0, nums.length);
            c++;
        }
        return res;
    }

    public void heapSort(int[] nums) {
        int l = nums.length;
        for (int i = l/2+1; i > -1; i--) {
            doHeap(nums, i, l);
        }
        for (int i = l-1; i > -1; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            doHeap(nums, 0, i);
        }
    }

    public void doHeapHigh(int[] nums, int root, int len) {
        int r = root * 2 + 1;
        int l = root * 2 + 2;
        int pre = root;
        if (r < len && nums[r] > nums[root]) {
            root = r;
        }
        if (l < len && nums[l] > nums[root]) {
            root = l;
        }
        if (pre != root) {
            int tmp = nums[root];
            nums[root] = nums[pre];
            nums[pre] = tmp;
            doHeapHigh(nums, root, len);
        }
    }

    public void doHeap(int[] nums, int root, int len) {
        int r = root*2+1;
        int l = root*2+2;
        int pre = root;
        if (r < len && nums[r] < nums[root]) {
            root = r;
        }
        if (l < len && nums[l] < nums[root]) {
            root = l;
        }
        if (pre != root) {
            int tmp = nums[root];
            nums[root] = nums[pre];
            nums[pre] = tmp;
            doHeap(nums, root, len);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
