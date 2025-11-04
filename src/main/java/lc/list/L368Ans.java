package lc.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 20240216
 **/
public class L368Ans {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > max) {
                        max = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int num = nums[maxIndex];
        for (int i = maxIndex; i > -1; i--) {
            if (num % nums[i] == 0 && dp[i] == max) {
                res.add(nums[i]);
                num = nums[i];
                max--;
            }
        }
        return res;
    }
}
