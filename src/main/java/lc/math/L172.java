package main.java.lc.math;

/**
 * <p>
 *     Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 * </p>
 * <a href = https://leetcode.com/problems/factorial-trailing-zeroes/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Example 3:
 *
 * Input: n = 0
 * Output: 0
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2023/11/25
 **/
public class L172 {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

}
