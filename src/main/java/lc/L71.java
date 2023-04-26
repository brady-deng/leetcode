package main.java.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class L71 {
    public static void main(String[] args) {
        System.out.println("Please input the path:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println(simplifyPath(path));
    }
    public static String simplifyPath(String path) {
        Stack<String> res = new Stack<>();
        res.push("");
        StringBuilder tmp = new StringBuilder();
        for (char item:path.toCharArray()) {
            if (item == '/') {
                String string = tmp.toString();
                tmp = new StringBuilder();
                if (string.equals("..") ) {
                    if (res.size() > 1) {
                        res.pop();
                    }
                }
                else if (string.equals(".") || "".equals(string)) {
                    continue;
                }
                else {
//                res.add("/");
                    res.push(string);
                }
            }
            else {
                tmp.append(item);
            }
        }
        if (!tmp.toString().equals("/")) {
            String string = tmp.toString();
            if (string.equals("..") ) {
                if (res.size() > 1) {
                    res.remove(res.size()-1);
                }
            }
            else if (string.equals(".") || "".equals(string)) {

            }
            else {
//                res.add("/");
                res.push(string);
            }
        }
        if (res.size()>1) {
            return String.join( "/", res);
        }
        else return "/";
    }

    public static List<String> dpSearch(String path, int start, List<String> res) {
        return new ArrayList<>();
    }
}
