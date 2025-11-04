package lc.list;//An ugly number is a positive integer which does not have a prime factor other
//than 2, 3, and 5.
//
// Given an integer n, return true if n is an ugly number.
//
//
// Example 1:
//
//
//Input: n = 6
//Output: true
//Explanation: 6 = 2 × 3
//
//
// Example 2:
//
//
//Input: n = 1
//Output: true
//Explanation: 1 has no prime factors.
//
//
// Example 3:
//
//
//Input: n = 14
//Output: false
//Explanation: 14 is not ugly since it includes the prime factor 7.
//
//
//
// Constraints:
//
//
// -2³¹ <= n <= 2³¹ - 1
//
//
// Related Topics Math 👍 3576 👎 1754


import lc.list.test.L204Test;

import java.lang.reflect.Array;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class L263 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            System.out.println(new L263().isUgly(n));
            n = sc.nextInt();
        }
    }

    public boolean isUgly(int n) {
        Set<Integer> res = findPrimeFactors(n);
        Set<Integer> ugly = new HashSet<>();
        ugly.add(2);
        ugly.add(3);
        ugly.add(5);
        ugly.add(1);
        res.removeAll(ugly);
        return res.isEmpty();
    }

    public Set<Integer> findPrimeFactors(int n) {
        Set<Integer> res = new HashSet<>();
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i*i <= n; i++) {
            if (primes[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    primes[j] = false;
                }
            }
        }
        primes[1] = true;
        for (int i = 1; i * i <= n; i++) {
            if (primes[i] && n % i == 0) {
                res.add(i);
                int tp = n/i;
                if (primes[tp]) {
                    res.add(tp);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
