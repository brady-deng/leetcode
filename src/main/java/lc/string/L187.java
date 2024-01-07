package main.java.lc.string;

import java.util.*;

/**
 * <p>
 *     The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 *
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 *
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 * </p>
 * <a href=https://leetcode.com/problems/repeated-dna-sequences/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 *
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20231216
 **/
public class L187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return Collections.emptyList();
        }
        Set<String> set = new HashSet<>();
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i+9 < s.length()) {
            String tmp = s.substring(i, i+10);
            if (set.contains(tmp) && !res.contains(tmp)) {
                res.add(tmp);
            } else {
                set.add(tmp);
            }
            i++;
        }
        return res;
    }

}
