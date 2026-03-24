package main.java.lc.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *     Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 * </p>
 * <a href = https://leetcode.com/problems/design-add-and-search-words-data-structure/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2023/12/9
 **/
public class L211 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordDictionary trie = new WordDictionary();
        trie.addWord("apple");
        System.out.println(trie.search("app"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.search(".pp"));
        System.out.println(trie.search("..ple"));
        System.out.println(trie.search("....."));
        System.out.println(trie.search("..pl."));
        System.out.println(trie.search("..p.."));
//        System.out.println(trie.startsWith("app"));
//        System.out.println(trie.startsWith("apn"));
//        System.out.println('.'-'a');
    }

    static class WordDictionary {
        private WordDictionary[] children;
        boolean isEndOfWord;
        // Initialize your data structure here.
        public WordDictionary() {
            children = new WordDictionary[26];
            isEndOfWord = false;
        }

        // Adds a word into the data structure.
        public void addWord(String word) {
            WordDictionary curr = this;
            for(char c: word.toCharArray()){
                if(curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new WordDictionary();
                curr = curr.children[c - 'a'];
            }
            curr.isEndOfWord = true;
        }

        // Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            WordDictionary curr = this;
            for(int i = 0; i < word.length(); ++i){
                char c = word.charAt(i);
                if(c == '.'){
                    for(WordDictionary ch: curr.children)
                        if(ch != null && ch.search(word.substring(i+1))) return true;
                    return false;
                }
                if(curr.children[c - 'a'] == null) return false;
                curr = curr.children[c - 'a'];
            }
            return curr != null && curr.isEndOfWord;
        }
    }
}
