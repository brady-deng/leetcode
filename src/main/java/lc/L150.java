package main.java.lc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author dengchenyang.brady@bytedance.com
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
