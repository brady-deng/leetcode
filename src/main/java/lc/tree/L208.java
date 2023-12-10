package main.java.lc.tree;

import java.util.Scanner;

/**
 * <p>
 *     A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 * </p>
 * <a href=https://leetcode.com/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2023/12/9
 **/
public class L208 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Trie trie = new Trie();
//        trie.insert("apple");
//        System.out.println(trie.search("app"));
//        System.out.println(trie.search("apple"));
//        System.out.println(trie.startsWith("app"));
//        System.out.println(trie.startsWith("apn"));
        System.out.println('.'-'a');
    }

    static class Node {
        boolean end;
        Node[] next;

        public Node() {
            this.end = false;
            next = new Node[27];
        }
    }

    static class Trie {

        Node[] nodes;

        public Trie() {
            nodes = new Node[27];
        }

        public void insert(String word) {
            char[] arr = word.toCharArray();
            Node[] cur = nodes;
            Node end = new Node();
            for (char item: arr) {
                end = cur[item-'a'];
                if (end == null) {
                    end = new Node();
                    cur[item-'a'] = end;
                }
                cur = end.next;
            }
            end.end = true;
        }

        public boolean search(String word) {
            char[] arr = word.toCharArray();
            Node[] cur = nodes;
            Node end = new Node();
            for (char item: arr) {
                end = cur[item-'a'];
                if (end == null) {
                    return false;
                }
                cur = end.next;
            }
            return end.end;
        }

        public boolean startsWith(String prefix) {
            char[] arr = prefix.toCharArray();
            Node[] cur = nodes;
            Node end = new Node();
            for (char item: arr) {
                end = cur[item-'a'];
                if (end == null) {
                    return false;
                }
                cur = end.next;
            }
            return true;
        }
    }
}
