package lc.string;

import lc.util.LUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2024/5/18
 **/
public class Solution76 {
    //Given two strings s and t of lengths m and n respectively, return the minimum
//window substring of s such that every character in t (including duplicates) is
//included in the window. If there is no such substring, return the empty string
//"".
//
// The testcases will be generated such that the answer is unique.
//
//
// Example 1:
//
//
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
//from string t.
//
//
// Example 2:
//
//
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
//
//
// Example 3:
//
//
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
//
//
//
// Constraints:
//
//
// m == s.length
// n == t.length
// 1 <= m, n <= 10⁵
// s and t consist of uppercase and lowercase English letters.
//
//
//
// Follow up: Could you find an algorithm that runs in O(m + n) time?
//
// Related Topics Hash Table String Sliding Window 👍 17665 👎 718


    //leetcode submit region begin(Prohibit modification and deletion)

    public static void main(String[] args) {
        String s = LUtil.inputString();
        String t = LUtil.inputString();
        System.out.println(new Solution76().minWindow(s, t));
        System.out.println(new Ans76().minWindow(s, t));
    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> sm = new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();
        for (char c: s.toCharArray()) {
            sm.putIfAbsent(c, 0);
            sm.put(c, sm.get(c)+1);
        }
        for (char c: t.toCharArray()) {
            tm.putIfAbsent(c, 0);
            tm.put(c, tm.get(c)+1);
        }
        if (!check(sm, tm)) {
            return "";
        }
        return check(s, 0, s.length()-1, sm, tm);
    }

    public String check(String s, int l, int r, Map<Character, Integer> sm, Map<Character, Integer> tm) {
        String res = "";
        while (check(sm, tm)) {
            sm.put(s.charAt(l), sm.get(s.charAt(l))-1);
            l++;
        }
        sm.put(s.charAt(l-1), sm.get(s.charAt(l-1))+1);
        while (check(sm, tm)) {
            sm.put(s.charAt(r), sm.get(s.charAt(r)) -1);
            r--;
        }
        sm.put(s.charAt(r+1), sm.get(s.charAt(r+1))+1);
        res = s.substring(l-1, r+2);
        return res;
    }

    public boolean check(Map<Character, Integer> s, Map<Character, Integer> t) {
        for (Map.Entry<Character, Integer> entry: t.entrySet()) {
            if (s.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
//leetcode submit region end(Prohibit modification and deletion)

}
