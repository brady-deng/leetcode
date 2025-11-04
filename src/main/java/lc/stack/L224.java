package lc.stack;

import lc.util.LUtil;

import java.util.Stack;

/**
 * <p>
 *     Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * </p>
 * <a href=https://leetcode.com/problems/basic-calculator/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * </p>
 * <p>
 *     Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * </p>
 * <p>
 *     Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/10/27
 **/
public class L224 {
    public static void main(String[] args) {
        System.out.println(calculate(LUtil.inputString()));
    }
    public static int calculate(String s) {
        int sign = 1;
        int tmp = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (char item:s.toCharArray()) {
            if (item == '+') {
                result = result + sign*tmp;
                tmp = 0;
                sign = 1;
            }
            else if (item == '-') {
                result = result + sign*tmp;
                tmp = 0;
                sign = -1;
            }
            else if (item == '(') {
                result = result + sign*tmp;
                stack.push(result);
                stack.push(sign);
                tmp = 0;
                result = 0;
                sign = 1;
            }
            else if (item == ')') {
                result = result + sign*tmp;
                result = result * stack.pop();
                result = result + stack.pop();
                tmp = 0;
                sign = 1;
            }
            else if (item != ' '){
                tmp = 10*tmp + (item-'0');
            }
        }
        if (tmp != 0) {
            result = result + sign*tmp;
        }
        return result;
    }
}
