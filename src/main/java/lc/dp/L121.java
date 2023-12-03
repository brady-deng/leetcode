package main.java.lc.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * </p>
 * <a href=https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2023/12/3
 **/
public class L121 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        System.out.println(new L121().maxProfit(nums));
        System.out.println(new L121().maxProfit2(nums));
    }
    public int maxProfit(int[] prices) {
        int minInd = 0;
        int maxInd = 0;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > minInd && prices[i] > prices[maxInd]) {
                maxInd = i;
                res = Math.max(res, prices[maxInd] - prices[minInd]);
            }
            if (prices[i] < prices[minInd]) {
                res = Math.max(res, prices[maxInd] - prices[minInd]);
                minInd = i;
                maxInd = i;
            }
        }
        return res;
    }


    public int maxProfit2(int[] prices) {
        int temp = 0;
        int res = 0;
        if (prices.length < 2) {
            return res;
        }
        for (int i = 1; i < prices.length; i++) {
            temp = Math.max(prices[i]-prices[i-1]+temp, prices[i]-prices[i-1]);
            res = Math.max(res, temp);
        }
        return res;
    }
}
