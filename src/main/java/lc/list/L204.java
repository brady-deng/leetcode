package lc.list;

/**
 * <p>
 *     Given an integer n, return the number of prime numbers that are strictly less than n.
 * </p>
 * <a href=https://leetcode.com/problems/count-primes/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 *
 * Input: n = 0
 * Output: 0
 * Example 3:
 *
 * Input: n = 1
 * Output: 0
 * </p>
 * <p>
 *     Medium
 * </p>
 * <p>
 *     如果x是质数，那么大于x的x的倍数2x,3x,…一定不是质数，因此我们可以从这里入手。
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240102
 **/
public class L204 {

    class Solution {
        public int countPrimes(int n) {
            if (n <= 2) {
                return 0;
            }

            boolean[] isPrime = new boolean[n];
            for (int i = 3; i < n; i += 2) {
                isPrime[i] = true;
            }

            isPrime[2] = true;

            for (int i = 3; i * i < n; i += 2) {
                if (isPrime[i]) {
                    for (int j = i * i; j < n; j += 2 * i) {
                        isPrime[j] = false;
                    }
                }
            }

            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }

            return count;
        }
    }
}
