package main.java.lc.list;

import main.java.lc.util.LUtil;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 20240104
 **/
public class MaxArray {

    public static void main(String[] args) {
        int[] arr = LUtil.inputNums();
        System.out.println(new MaxArray().solution(arr));
    }
    public int solution(int[] arr) {
        int res = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            if (cur > 0) {
                res = Math.max(res, cur);
            } else {
                cur = 0;
            }
        }
        return res;
    }
}
