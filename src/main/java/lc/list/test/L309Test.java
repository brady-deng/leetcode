package main.java.lc.list.test;

import main.java.lc.list.L309;
import main.java.lc.string.L30;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 <p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

 <p>Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:</p>

 <ul>
 <li>After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).</li>
 </ul>

 <p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>

 <p>&nbsp;</p>
 <p><strong class="example">Example 1:</strong></p>

 <pre>
 <strong>Input:</strong> prices = [1,2,3,0,2]
 <strong>Output:</strong> 3
 <strong>Explanation:</strong> transactions = [buy, sell, cooldown, buy, sell]
 </pre>

 <p><strong class="example">Example 2:</strong></p>

 <pre>
 <strong>Input:</strong> prices = [1]
 <strong>Output:</strong> 0
 </pre>

 <p>&nbsp;</p>
 <p><strong>Constraints:</strong></p>

 <ul>
 <li><code>1 &lt;= prices.length &lt;= 5000</code></li>
 <li><code>0 &lt;= prices[i] &lt;= 1000</code></li>
 </ul>

 <div><div>Related Topics</div><div><li>Array</li><li>Dynamic Programming</li></div></div><br><div><li>👍 9258</li><li>👎 310</li></div>

 * <p>
 *     Medium
 * </p>
 **/
public class L309Test extends L309 {
    @Override
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return calculateProfit2(prices, dp, 0, 1);
    }


    public int calculateProfit2(int[] prices, int[][] dp, int n, int tb) {
        if (n >= prices.length) {
            return 0;
        }
        if (dp[n][tb] != -1) {
            return dp[n][tb];
        }
        if (tb == 1) {
            dp[n][tb] = Math.max(calculateProfit2(prices, dp, n+1, 0)-prices[n], calculateProfit2(prices, dp, n+1, 1));
        } else {
            dp[n][tb] = Math.max(calculateProfit2(prices, dp, n+2, 1)+prices[n], calculateProfit2(prices, dp, n+1, 0));
        }
        return dp[n][tb];
    }


    public void calculateProfit(int[] prices, int[] profit, int lastProfile, int ind, int lastBuy) {
        if (ind <= 0 || ind >= prices.length || lastBuy >= prices.length) {
            return;
        } else {
            if (ind > lastBuy) {
                if (prices[ind] > prices[lastBuy]) {
                    lastProfile+=prices[ind]-prices[lastBuy];
                    profit[ind] = Math.max(profit[ind], lastProfile);

                    calculateProfit(prices, profit, lastProfile, ind+1, ind+2);
                    lastProfile-=prices[ind]-prices[lastBuy];
                }
                lastBuy = prices[ind] < prices[lastBuy] ? ind: lastBuy;
            }
            profit[ind] = Math.max(profit[ind-1], profit[ind]);
            calculateProfit(prices, profit, lastProfile, ind+1, lastBuy);
        }
    }
}
