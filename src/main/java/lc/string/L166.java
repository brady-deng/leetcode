package main.java.lc.string;

import java.util.*;

/**
 * <p>
 *     Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * If multiple answers are possible, return any of them.
 *
 * It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
 * </p>
 * <a href=https://leetcode.com/problems/fraction-to-recurring-decimal/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 4, denominator = 333
 * Output: "0.(012)"
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/11/25
 **/
public class L166 {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Please input the numerator:");
            Scanner scanner = new Scanner(System.in);
            int numerator = scanner.nextInt();
            System.out.println("Please input the denominator:");
            int denominator = scanner.nextInt();
            System.out.println("res:"+fractionToDecimal(numerator, denominator));
        }
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        boolean flag = (long) numerator *denominator >= 0;
        long n1 = Math.abs(Long.valueOf(numerator));
        long n2 = Math.abs(Long.valueOf(denominator));
        long n = n1/n2;
        StringBuilder res1 = new StringBuilder().append(n);
        StringBuilder res2 = new StringBuilder();
        Map<Long, Integer> set = new HashMap<>();
        long r = n1 - n*n2;
        int i = 0;
        int start = 0;
        set.put(r, 0);
        while (r != 0) {
            long tmp = r*10/n2;
            res2.append(tmp);
            r = r*10-tmp*n2;
            if (r == 0) {
                break;
            }
            if (set.containsKey(r)) {
                start = set.get(r);
                break;
            }
            i++;
            set.put(r, i);
        }
        StringBuilder res;
        if (res2.length() > 0) {
            if (r != 0) {
                String tmp1 = res2.substring(start);
                String tmp2 = res2.substring(0, start);
                res1.append(".").append(tmp2).append("(").append(tmp1).append(")");
                res = res1;
            } else {
                res = res1.append(".").append(res2);
            }
        }
        res = res1;
        if (flag) {
            return res.toString();
        }
        return "-"+ res;
    }
}
