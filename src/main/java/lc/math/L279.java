package lc.math;

//Given an integer n, return the least number of perfect square numbers that
//sum to n.
//
// A perfect square is an integer that is the square of an integer; in other
//words, it is the product of some integer with itself. For example, 1, 4, 9, and 16
//are perfect squares while 3 and 11 are not.
//
//
// Example 1:
//
//
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
//
//
// Example 2:
//
//
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
//
//
//
// Constraints:
//
//
// 1 <= n <= 10⁴
//
//
// Related Topics Math Dynamic Programming Breadth-First Search 👍 11456 👎 482


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//leetcode submit region begin(Prohibit modification and deletion)
class L279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {
            System.out.println(new L279().numSquares(n));
            n = sc.nextInt();
        }
    }

    public int numSquares(int n) {
        int[] res = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (isSquareRootInteger(i)) {
                res[i] = 1;
            } else {
                int temp = Integer.MAX_VALUE;
                for (int j = 1; j <= (i>>1); j++) {
                    int t = res[j] + res[i-j];
                    temp = Math.min(temp, t);
                }
                res[i] = temp;
            }
        }
        return res[n];
    }

    public int numSquaresPerfect(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public boolean isSquareRootInteger(Integer number) {
        if (number < 0) {
            return false;
        }
        if (number == 0 || number == 1) {
            return true;
        }
        long left = 1;
        long right = number / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == number) {
                return true;
            } else if (square < number) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

