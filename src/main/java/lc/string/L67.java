package main.java.lc.string;

import java.util.Scanner;

/**
 * <p>
 *     Given two binary strings a and b, return their sum as a binary string.
 * </p>
 * <a href = https://leetcode.com/problems/add-binary/>ref</a>
 * <p>
 *     "11"
 * "1"
 * 100
 *
 * "1010"
 * "1011"
 *
 * 10101
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/8
 **/
public class L67 {
    public static void main(String[] args) {
        System.out.println("Please input the a:");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        System.out.println("Please input the b:");
        String b = scanner.nextLine();
        System.out.println(addBinary(a, b));
    }
    public static String addBinary(String a, String b) {

        int l1 = a.length();
        int l2 = b.length();
        int m = Math.max(l1, l2);
        int n = Math.min(l1, l2);
        if (l1 > l2 ) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        char[] res = new char[m];

        int i = 0;
        boolean flag = false;
        while (i<n) {
            char c;
            int tmp = flag?a.charAt(a.length()-i-1) + b.charAt(b.length()-i-1)+1
                    :a.charAt(a.length()-i-1) + b.charAt(b.length()-i-1);
            if (tmp == 96) {
                c = '0';
                flag = false;
            }
            else if (tmp == 97) {
                c = '1';
                flag = false;
            }
            else if (tmp == 98){
                c = '0';
                flag = true;
            }
            else {
                c = '1';
                flag = true;
            }
            res[res.length-i-1] = c;
            i++;
        }
        while (i < m) {
            int tmp = flag?b.charAt(b.length()-i-1)+1:b.charAt(b.length()-i-1);
            char c;
            if (tmp == 48) {
                c = '0';
                flag = false;
            }
            else if (tmp == 49) {
                c = '1';
                flag = false;
            }
            else{
                c = '0';
                flag = true;
            }
            res[res.length-i-1] = c;
            i++;
        }
        if (flag) {
            char[] newRes = new char[m+1];
            System.arraycopy(res, 0, newRes, 1, res.length);
            newRes[0] = '1';
            return new String(newRes);
        }
        return new String(res);
    }
}
