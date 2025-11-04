package lc.dp;

import lc.heap.L215;
import lc.string.L32;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 * </p>
 * <a href=https://leetcode.com/problems/coin-change/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/4
 **/
public class L322 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        System.out.println("input k:");
        int k = scanner.nextInt();
        System.out.println(new L322().coinChange(nums, k));
    }
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount+1];
        for (int i = 1; i < amount+1; i++) {
            int[] tmp = new int[coins.length];
            int min = Integer.MAX_VALUE;
            boolean flag = false;
            for (int j = 0; j < coins.length; j++) {
                tmp[j] = Math.max(i - coins[j], 0);
                if ((i - coins[j] > 0 && res[tmp[j]] > 0) || (i-coins[j] == 0) ){
                    min = Math.min(min, res[tmp[j]]+1);
                    flag = true;
                }
            }
            if (flag) {
                res[i] = min;
            } else {
                res[i] = -1;
            }
        }
        return res[amount];
    }
}
