package lc.map_set;

import java.util.Arrays;

/**
 * <p>
 *     Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * </p>
 * <a href=https://leetcode.com/problems/valid-anagram/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231204
 **/
public class L242 {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }
}
