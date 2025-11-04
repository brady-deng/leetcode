package lc.list;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     You are given an integer num. Rearrange the digits of num such that its value is minimized and it does not contain any leading zeros.
 *
 * Return the rearranged number with minimal value.
 *
 * Note that the sign of the number does not change after rearranging the digits.
 * </p>
 * <a href=https://leetcode.com/problems/smallest-value-of-the-rearranged-number/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: num = 310
 * Output: 103
 * Explanation: The possible arrangements for the digits of 310 are 013, 031, 103, 130, 301, 310.
 * The arrangement with the smallest value that does not contain any leading zeros is 103.
 * Example 2:
 *
 * Input: num = -7605
 * Output: -7650
 * Explanation: Some possible arrangements for the digits of -7605 are -7650, -6705, -5076, -0567.
 * The arrangement with the smallest value that does not contain any leading zeros is -7650.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231216
 **/
public class L2165 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new L2165().smallestNumber(scanner.nextLong()));
    }

    public long smallestNumber(long num) {
        if (num == 0) {
            return num;
        }
        boolean neg = num<0;
        num = neg?-num:num;
        char[] tmp = String.valueOf(num).toCharArray();
        Arrays.sort(tmp);
        if (neg) {
            int i = 0;
            while (i < (tmp.length+1)/2) {
                char c = tmp[i];
                tmp[i] = tmp[tmp.length-i-1];
                tmp[tmp.length-i-1] = c;
                i++;
            }
        }
        int i = 0;
        while (tmp[i] == '0') {
            i++;
        }
        if (i != 0) {
            tmp[0] = tmp[i];
            tmp[i] = '0';
        }
        return neg? -Long.parseLong(String.valueOf(tmp)):Long.parseLong(String.valueOf(tmp));
    }
}
