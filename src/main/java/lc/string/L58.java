package main.java.lc.string;

import java.util.Scanner;

/**
 * <p>
 *     Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal
 * substring
 *  consisting of non-space characters only.
 * </p>
 * <a href = https://leetcode.com/problems/length-of-last-word/description/>ref</a>
 * <p>
 *     "Hello World" 5
 * "   fly me   to   the moon  " 4
 * "luffy is still joyboy" 6
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/8
 **/
public class L58 {
    public static void main(String[] args) {
        System.out.println("Please input the String:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord2(s));
    }
    public static int lengthOfLastWord(String s) {
        String[] tmp = s.split(" ");
        if (tmp.length>0) {
            return tmp[tmp.length-1].length();
        }
        else return 0;
    }

    public static int lengthOfLastWord2(String s) {
        int i = 0;
        boolean flag = false;
        for (int c = s.length()-1; c > -1; c--) {
            if (!flag && s.charAt(c) != ' ') {
                flag = true;
            }
            if (flag && s.charAt(c) != ' ') {
                i++;
            }
            if (flag && s.charAt(c) == ' ') {
                break;
            }
        }
        return i;
    }
}
