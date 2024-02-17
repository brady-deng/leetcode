package main.java.lc.list;

import java.util.Arrays;

/**
 * <p>
 *     You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
 *
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
 *
 * Return the length longest chain which can be formed.
 *
 * You do not need to use up all the given intervals. You can select pairs in any order.
 * </p>
 * <a href=https://leetcode.com/problems/maximum-length-of-pair-chain/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: pairs = [[1,2],[2,3],[3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4].
 * Example 2:
 *
 * Input: pairs = [[1,2],[7,8],[4,5]]
 * Output: 3
 * Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240216
 **/
public class L646 {

    public static void main(String[] args) {
        int[][] pairs = new int[][]{{7,9},{4,5},{7,9},{-7,-1},{0,10},{3,10},{3,6},{2,3}};
        L646 l646 = new L646();
        System.out.println(l646.findLongestChain(pairs));
    }
    public int findLongestChain(int[][] pairs) {
        sort(pairs, 0, pairs.length);
        int[] res = new int[1];
        recurFind(pairs, 0, pairs.length-1, Integer.MAX_VALUE, res);
        return Arrays.stream(res).max().getAsInt();
    }

    public void sort(int[][] pairs, int start, int end) {
        if (start < end) {
            int mid = partition(pairs, start, end);
            sort(pairs, start, mid);
            sort(pairs, mid+1, end);
        }
    }

    public int partition(int[][] pairs, int start, int end) {
        int[] thre = pairs[end-1];
        int ind = start;
        for (int i = start; i < end-1; i++) {
            if (pairs[i][0] < thre[0] || (pairs[i][0] == thre[0] && pairs[i][1] <= thre[1])) {
                int[] tmp = pairs[ind];
                pairs[ind] = pairs[i];
                pairs[i] = tmp;
                ind++;
            }
        }
        int[] tmp = pairs[ind];
        pairs[ind] = pairs[end-1];
        pairs[end-1] = tmp;
        return ind;
    }

    public void recurFind(int[][] pairs, int start, int ind, int prev, int[] res) {
        if (ind == -1) {
            return;
        } else {
            if (pairs[ind][1] < prev) {
                res[0]++;
                recurFind(pairs, start, ind-1, pairs[ind][0], res);
            } else {
                recurFind(pairs, start, ind-1, prev, res);
            }
        }
    }
}
