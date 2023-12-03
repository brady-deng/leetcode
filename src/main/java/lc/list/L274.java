package main.java.lc.list;

import java.util.Arrays;

/**
 * <p>
 *     Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 * </p>
 * <a href=https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * Example 2:
 *
 * Input: citations = [1,3,1]
 * Output: 1
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2023/12/3
 **/
public class L274 {
    public int hIndex(int[] citations) {
        if (citations.length < 2) {
            return 1;
        }
        Arrays.sort(citations);
        for (int i = 0; i<citations.length; i++) {
            if (citations[i] > (citations.length-i)) {
                return citations.length-i;
            }
        }
        return 0;
    }

}
