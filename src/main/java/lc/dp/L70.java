package lc.dp;

/**
 * <p>
 *     You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * </p>
 * <a href=https://leetcode.com/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231215
 **/
public class L70 {

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++) {
            res[i] = res[i-2]+res[i-1];
        }
        return res[n-1];

    }
}
