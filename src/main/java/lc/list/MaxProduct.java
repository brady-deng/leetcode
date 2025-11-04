package lc.list;

import lc.util.LUtil;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 20240104
 **/
public class MaxProduct {

    public static void main(String[] args) {
        int[] arr = LUtil.inputNums();
        System.out.println(new MaxProduct().solution(arr));
    }

    public int solution(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(max*arr[i], min*arr[i]), arr[i]);
            min = Math.min(Math.min(tmp*arr[i], min*arr[i]), arr[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
