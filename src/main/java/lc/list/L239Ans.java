package main.java.lc.list;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2024/5/18
 **/


class L239Ans {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            // remove first element if it's outside the window
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }
            // if window has k elements add to results (first k-1 windows have < k elements because we start from empty window and add 1 element each iteration)
            if (i >= k - 1) {
                res[i-k+1] = nums[q.peek()];
            }
        }
        return res;
    }
}
