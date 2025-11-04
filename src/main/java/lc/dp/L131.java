package lc.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *     Given a string s, partition s such that every
 * substring
 *  of the partition is a
 * palindrome
 * . Return all possible palindrome partitioning of s.
 * </p>
 * <a href=https://leetcode.com/problems/palindrome-partitioning/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231216
 **/
public class L131 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new Solution().partition(s));
    }

    static class Solution {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        boolean isPalindrome(String s, int low, int high) {
            while (low < high)
                if (s.charAt(low++) != s.charAt(high--)) return false;

            return true;
        }
        void genrate(String s,int start)
        {
            if(start >=s.length())
                ans.add(new ArrayList<>(curr));
            for(int i=start;i<s.length();i++)
            {
                if(isPalindrome(s,start,i))
                {
                    curr.add(s.substring(start,i+1));
                    genrate(s,i+1);
                    curr.remove(curr.size()-1);
                }
            }
        }
        public List<List<String>> partition(String s) {
            genrate(s,0);
            return ans;
        }
    }


}
