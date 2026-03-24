package main.java.lc.list.test;

import main.java.lc.util.LUtil;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2024/6/9
 **/
public class N211 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new N211().solution(nums));
    }

    /**
     * [100,4,200,5,3,2]
     * 做大连续子序列
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
        int[] bucket = new int[10001];
        for (int num : nums) {
            bucket[num] = 1;
        }
        int res = 0;
        int start = -1;
        for (int i = 0; i < 10001; i++) {
            if(bucket[i] > 0 && start == -1) {
                start = i;
            }
            while (start > -1 && bucket[i] > 0) {
                i++;
                res = Math.max(res, i-start);
            }
            start = -1;
        }
        return res;
    }
}
