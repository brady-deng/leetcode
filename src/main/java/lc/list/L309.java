package main.java.lc.list;

import main.java.lc.list.test.L309Test;
import main.java.lc.util.LUtil;

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
public class L309 {

    public static void main(String[] args) {
        int[] prices = LUtil.inputNums();
        System.out.println(new L309Ans().maxProfit(prices));
        System.out.println(new L309Test().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        } else {
            int[] profile = new int[prices.length];
            calProfile(prices, profile, 0, -2, 0, true);
            return profile[profile.length-1];
        }
    }

    public void calProfile(int[] prices, int[] profile, int lastProfile, int prev, int i, boolean flag) {
        if (i >= prices.length) {
            return;
        }
        if (flag && i > prev+1) {
            calProfile(prices, profile, lastProfile, i, i+1, !flag);
        } else if (!flag) {
            if (prices[i] > prices[prev]) {
                int newProfile = lastProfile + prices[i] - prices[prev];
                profile[i] = Math.max(profile[i], newProfile);
                calProfile(prices, profile, newProfile, i, i+1, !flag);
            }
        }
        if (i > 0) {
            profile[i] = Math.max(profile[i], profile[i-1]);
        }
        calProfile(prices, profile, lastProfile, prev, i+1, flag);

    }
}
