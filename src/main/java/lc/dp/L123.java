package lc.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 20231216
 **/
public class L123 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] prices = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solution().maxProfit(prices));
    }

    // First we are calculating the total max. profit we are getting when 1 txn. is allowed
// for every index, store the max. profit at their index in array profit
// similar to

// 122. Best Time to Buy and Sell Stock II
// by simply finding the minimum buy price, and if any greater price[i] comes,
// profit will be updated

// Now going backwards, if we are at index i, then till (i-1) we have the profit from first txn.
// and at i we have the profit of second txn.
// at each step, we are finding the max sell and min buy, to have max profit and adding it with
// profit[i-1]

// also in 2nd txn. when a greater value for sell is found, then buy is also changed
// because the buy value should occur previously than the sell index



    static class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length==1) return 0;
            int profit[]=new int[prices.length];
            int buy=prices[0],sell=0;

            for(int i=1;i<prices.length;i++){
                buy=Math.min(buy,prices[i]);
                profit[i]=Math.max(profit[i-1],prices[i]-buy);
            }

            sell=prices[prices.length-1];
            buy=sell;
            for(int i=prices.length-2;i>0;i--){
                if(sell<prices[i]) sell=buy=prices[i];
                buy=Math.min(buy,prices[i]);
                profit[i]=Math.max(profit[i+1],profit[i-1]+sell-buy);
            }
            return profit[1];
        }
    }
}
