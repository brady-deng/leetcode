package lc;

import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/19
 **/
public class L44 {

    public static void main(String[] args) {
        System.out.println("Please input the s:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println("Please input the p:");
        String p = scanner.nextLine();
        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch(String s, String p) {
        return match(s,p,0,0);
    }

    public static boolean match(String s, String p, int s1, int p1) {
        if (s1 > s.length()-1 && p1 > p.length()-1) return true;
        else {
            if (
                    (p1 >= p.length() && s1 < s.length())
                    || (s1 >= s.length() && p1 < p.length() && p.charAt(p1) != '*')
            ) return false;
            if (p.charAt(p1) != '?' && p.charAt(p1) != '*') {
                if (p.charAt(p1) != s.charAt(s1)) {
                    return false;
                }
                else {
                    return match(s, p, s1+1, p1+1);
                }
            }
            else if (p.charAt(p1) == '?') {
                return match(s, p, s1+1, p1+1);
            }
            else if (p.charAt(p1) == '*' && p1 == p.length()-1) {
                return true;
            }
            else if (p.charAt(p1) == '*') {
                while (p1 < p.length() && p.charAt(p1) == '*') {
                    p1++;
                }
                if (p1 == p.length()) return true;
                else {
                    for (int i = s1; i < s.length(); i++) {
                        if ((s.charAt(i) == p.charAt(p1) || p.charAt(p1) == '?') && match(s, p, i, p1)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
    }
}
