package main.java.lc.list;

/**
 * <p>
 *     Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.
 * </p>
 * <a href=https://leetcode.com/problems/maximum-product-of-word-lengths/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * </p>
 * <p>
 * Example 2:
 *  *
 *  * Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
 *  * Output: 4
 *  * Explanation: The two words can be "ab", "cd".
 * </p>
 * <p>
 * Example 3:
 *
 * Input: words = ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240130
 **/
public class L318Ans {
    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];

        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words[i].length(); j++) {
                bits[i] = bits[i] | 1 << (words[i].charAt(j) - 'a');
            }
        }

        int result = 0;
        for(int i=0; i<bits.length; i++) {
            for(int j=i+1; j<bits.length; j++) {
                if((bits[i] & bits[j]) == 0) {
                    result = Math.max(words[i].length() * words[j].length(), result);
                }
            }
        }
        return result;
    }

}
