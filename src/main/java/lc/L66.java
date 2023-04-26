package main.java.lc;

import java.util.Arrays;
import java.util.Scanner;

/**
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
