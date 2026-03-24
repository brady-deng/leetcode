package main.java.lc.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <p>
 *     Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * </p>
 * <a href=https://leetcode.com/problems/word-break/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231215
 **/
public class L139 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> dict = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());
        System.out.println(new L139().wordBreak(s, dict));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<Integer> ind = new ArrayList<>();
        ind.add(0);
        for (int i = 1; i < n+1; i++) {
            for (int j: ind) {
                String tmp = s.substring(j, i);
                if (wordDict.contains(tmp)) {
                    ind.add(i);
                    break;
                }
            }
        }
        return ind.get(ind.size()-1) == n;

    }
}
