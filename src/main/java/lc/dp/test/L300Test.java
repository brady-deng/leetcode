package main.java.lc.dp.test;

import main.java.lc.dp.L300;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2024/6/5
 **/
public class L300Test extends L300 {

    @Override
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] res = new int[nums.length];
        int[] tmp = new int[nums.length+1];
        res[0] = 1;
        tmp[0] = Integer.MIN_VALUE;
        tmp[1] = nums[0];
        for (int i = 1; i < res.length; i++) {
            if (nums[i] > tmp[res[i-1]]) {
                res[i] = res[i-1]+1;
                tmp[res[i]] = nums[i];
            } else {
                res[i] = res[i-1];
                for (int j = res[i]; j > 0; j--) {
                    if (nums[i] > tmp[j-1] && nums[i] < tmp[j]) {
                        tmp[j] = nums[i];
                        break;
                    }
                }
            }
        }
        return res[nums.length-1];
    }
}
