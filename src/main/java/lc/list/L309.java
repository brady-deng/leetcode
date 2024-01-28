package main.java.lc.list;

import main.java.lc.util.LUtil;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2024/1/28
 **/
public class L309 {

    public static void main(String[] args) {
        int[] prices = LUtil.inputNums();
        System.out.println(new L309().maxProfit(prices));
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
