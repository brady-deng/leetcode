package main.java.lc.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * <p>
 *     Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 * </p>
 * <a href = https://leetcode.com/problems/simplify-path/>ref</a>
 * <p>
 *     "/home/" --> /home
 * "/../" --> /
 * "/home//foo/" --> /home/foo
 * </p>
 */
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
