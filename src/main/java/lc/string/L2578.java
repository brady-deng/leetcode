package main.java.lc.string;

import java.util.Arrays;

/**
 * <p>
 *     Given a positive integer num, split it into two non-negative integers num1 and num2 such that:
 *
 * The concatenation of num1 and num2 is a permutation of num.
 * In other words, the sum of the number of occurrences of each digit in num1 and num2 is equal to the number of occurrences of that digit in num.
 * num1 and num2 can contain leading zeros.
 * Return the minimum possible sum of num1 and num2.
 *
 * Notes:
 *
 * It is guaranteed that num does not contain any leading zeros.
 * The order of occurrence of the digits in num1 and num2 may differ from the order of occurrence of num.
 * </p>
 * <a href=https://leetcode.com/problems/split-with-minimum-sum/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: num = 4325
 * Output: 59
 * Explanation: We can split 4325 so that num1 is 24 and num2 is 35, giving a sum of 59. We can prove that 59 is indeed the minimal possible sum.
 * Example 2:
 *
 * Input: num = 687
 * Output: 75
 * Explanation: We can split 687 so that num1 is 68 and num2 is 7, which would give an optimal sum of 75.
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 20240216
 **/
public class L2578 {



    public int splitNum(int num) {
        char[] chars = String.valueOf(num).replaceAll("0", "").toCharArray();
        int l = chars.length;
        Arrays.sort(chars);
        if (l == 0) {
            return 0;
        } else if (l == 1) {
            return Integer.parseInt(String.valueOf(chars));
        } else {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < l; i++) {
                if (i % 2 == 0) {
                    sb1.append(chars[i]);
                } else {
                    sb2.append(chars[i]);
                }
            }
            return Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());
        }
    }
}
