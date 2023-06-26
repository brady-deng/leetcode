package main.java.lc.list;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 * </p>
 * <a href = https://leetcode.com/problems/plus-one/>ref</a>
 * <p>
 *     [1,2,3] [1,2,4]
 * [4,3,2,1] [4,3,2,2]
 * [9] [1,0]
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/8
 **/
public class L66 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] n = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(plusOne(n)));
    }

    /**
     * flag 是否进位
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];
        boolean flag = true;
        for (int i = digits.length-1; i > -1; i--) {
            if (flag) {
                res[i] = digits[i]+1;
                if (res[i] == 10) {
                    res[i] = 0;
                    flag = true;
                }
                else {
                    flag = false;
                }
            }
            else {
                res[i] = digits[i];
            }
        }
        if (flag) {
            int[] finalRes = new int[res.length+1];
            System.arraycopy(res, 0, finalRes, 1, res.length);
            finalRes[0] = 1;
            return finalRes;
        }
        else {
            return res;
        }
    }
}
