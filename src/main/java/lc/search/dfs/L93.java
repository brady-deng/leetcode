package main.java.lc.search.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *     A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 * </p>
 * <a href = https://leetcode.com/problems/restore-ip-addresses/>ref</a>
 * <p>
 *     "25525511135" --> ["255.255.11.135","255.255.111.35"]
 * "0000" --> ["0.0.0.0"]
 * "101023" --> ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/16
 **/
public class L93 {
    public static void main(String[] args) {
        System.out.println("Please input the s:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(restoreIpAddresses(s));

    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) {
            return res;
        }
        else {
            storeIp(s, 0, 0, "", res);
        }
        return res;
    }

    /**
     *
     * @param s original string
     * @param index current index
     * @param c current count of dot
     * @param tmp the string after dot added
     * @param res
     */
    public static void storeIp(String s, int index, int c,  String tmp, List<String> res) {
        if (index == s.length()) {
            if (c == 4) {
                res.add(tmp);
            }
        }
        else {
            for (int j = index+1; j<s.length()+1;j++) {
                if ((j-index) <= 3) {
                    String ob = s.substring(index, j);
                    int obInt = Integer.parseInt(ob);
                    if (
                            obInt >= 0
                                    && obInt < 256
                                    && c < 4
                                    && (
                                        (ob.length() > 1 && !ob.startsWith("0"))
                                            || ob.length() == 1
                                    )
                                    && (s.length()-j-1 < (3-c)*3)
                    ) {
                        if (c != 0) {
                            storeIp(s, j, c+1, tmp+"."+s.substring(index,j), res);

                        }
                        else {
                            storeIp(s, j, c+1, tmp+s.substring(index,j), res);
                        }
                    }
                }
                else {
                    return;
                }

            }
        }
    }
}
