package main.java.lc.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * <p>
 *     You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * </p>
 * <a href=https://leetcode.com/problems/evaluate-reverse-polish-notation/description/>ref</a>
 * <p>
 *     Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * </p>
 * <p>
 *     Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * </p>
 * <p>
 *     Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/24
 **/
public class L150 {
    public static void main(String[] args) {
        System.out.println("Please input the strings");
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(",");
        System.out.println(evalRPN(strings));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> strings = new Stack<>();
        for (String item:tokens) {
            if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
                int res;
                Integer tmp;
                Integer pre;
                String pro;

                tmp = strings.pop();
                pre = strings.pop();
                pro = item;

                switch (pro) {
                    case "+":
                        res = tmp+pre;
                        break;
                    case "-":
                        res = pre-tmp;
                        break;
                    case "*":
                        res = pre*tmp;
                        break;
                    case "/":
                        res = pre/tmp;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + pro);
                }
                strings.push(res);
            }
            else {
                strings.push(Integer.valueOf(item));
            }
        }
        return strings.pop();
    }
}
