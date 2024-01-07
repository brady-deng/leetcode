package main.java.lc.list;

import main.java.lc.util.LUtil;

import java.util.Arrays;

/**
 * <p>
 *     You are given an array of positive integers price where price[i] denotes the price of the ith candy and a positive integer k.
 *
 * The store sells baskets of k distinct candies. The tastiness of a candy basket is the smallest absolute difference of the prices of any two candies in the basket.
 *
 * Return the maximum tastiness of a candy basket.
 * </p>
 * <a href=https://leetcode.com/problems/maximum-tastiness-of-candy-basket/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: price = [13,5,1,8,21,2], k = 3
 * Output: 8
 * Explanation: Choose the candies with the prices [13,5,21].
 * The tastiness of the candy basket is: min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8.
 * It can be proven that 8 is the maximum tastiness that can be achieved.
 * Example 2:
 *
 * Input: price = [1,3,1], k = 2
 * Output: 2
 * Explanation: Choose the candies with the prices [1,3].
 * The tastiness of the candy basket is: min(|1 - 3|) = min(2) = 2.
 * It can be proven that 2 is the maximum tastiness that can be achieved.
 * Example 3:
 *
 * Input: price = [7,7,7,7], k = 2
 * Output: 0
 * Explanation: Choosing any two distinct candies from the candies we have will result in a tastiness of 0.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/24
 **/
public class L2517 {
    public static void main(String[] args) {
        int[] price = LUtil.inputNums();
        int k = LUtil.inputNum();
        System.out.println(new L2517().maximumTastiness(price, k));
    }


    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low = 0, high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = (low + high)/2;
            if (isPossible(price, mid, k)) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }

    public boolean isPossible(int[] price, int thre, int k) {
        int count = 1, last = price[0];
        for (int i = 1; i < price.length; i++) {
            if (price[i] - last >= thre) {
                count++;
                last = price[i];
            }
            if (count >= k) {
                return true;
            }
        }
        return count >= k;
    }
}
