package lc.list;

/**
 *
 * @author dengchenyang@tju.edu.cn
 * @date 20240102
 **/
public class L209Ans {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int ans = Integer.MAX_VALUE; // minimum length of subarray
            int n = nums.length; // size of the input array
            int left = 0; // left pointer
            int sum = 0; // current sum of elements in subarray

            for (int right = 0; right < n; right++) {
                sum += nums[right]; // include current element in the sum

                // check if the sum exceeds or equals the target
                while (sum >= target) {
                    sum -= nums[left]; // subtract the leftmost element from the sum
                    ans = Math.min(ans, right - left + 1); // update the minimum length
                    left++; // move the left pointer to the right
                }
            }

            // if no valid subarray is found, return 0
            if (ans == Integer.MAX_VALUE) {
                return 0;
            }

            return ans;
        }
    }
}
