package main.java.lc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/6
 **/
public class L32Ans {
    public static void main(String[] args) {
        System.out.println("Please input the parentheses:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
