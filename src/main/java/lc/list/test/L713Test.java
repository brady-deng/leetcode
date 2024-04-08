package main.java.lc.list.test;

import main.java.lc.list.L713;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date
 **/
public class L713Test extends L713 {

    @Override
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int low = 0;
        int pro = 1;
        int i = 0;
        int res = 0;
        while (i < nums.length) {
            pro *= nums[i];
            while (pro >= k && low < i) {
                pro /= nums[low++];
            }
            if (pro < k) {
                res += (i-low+1);
            }
            i++;
        }
        return res;
    }
}
