package main.java.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
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
    public static void storeIp(String s, int index, int c,  String tmp, List<String> res) {
        if (index == s.length()) {
            if (c == 4) {
                res.add(tmp);
            }
        }
        else {
            for (int j = index+1; j<s.length()+1;j++) {
                if ((j-index) <= 3) {
                    if (
                            Integer.parseInt(s.substring(index, j)) >= 0
                                    && Integer.parseInt(s.substring(index,j)) < 256
                                    && c < 4
                                    && (
                                    (s.substring(index, j).length() > 1 && !s.substring(index, j).startsWith("0"))
                                            || s.substring(index, j).length() == 1

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
