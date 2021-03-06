package lc;

import java.util.Stack;

/**
 * @author dengchenyang.brady@bytedance.com
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
