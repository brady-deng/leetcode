package lc.list;


import lc.util.LUtil;

import java.util.*;

/**
 * <p>
 *     You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
 *
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 *
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 * </p>
 * <a href=https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/>ref</a>
 * <p>
 *     Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 20240216
 **/
public class L373 {

    public static void main(String[] args) {
        L373 l373 = new L373();
        int[] nums1 = LUtil.inputNums();
        int[] nums2 = LUtil.inputNums();
        int k = LUtil.inputNum();
        l373.kSmallestPairs(nums1, nums2, k);
        System.out.println(l373.kSmallest2(nums1, nums2, k));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = nums1[i] + nums2[j];
            }
        }
        int[][] index = new int[m*n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                index[i*n+j][0] = i;
                index[i*n+j][1] = j;
            }
        }
        Arrays.sort(index, Comparator.comparingInt(a -> sum[a[0]][a[1]]));
        for (int i = 0; i < k && i < m * n; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums1[index[i][0]]);
            tmp.add(nums2[index[i][1]]);
            res.add(tmp);
        }
        return res;
    }


    public List<List<Integer>> kSmallest2(int[] nums1, int[] nums2, int k) {
        Set<AbstractMap.SimpleEntry<Integer, Integer>> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {return (nums1[o1[0]]+nums2[o1[1]]-nums1[o2[0]]-nums2[o2[1]]);});
        queue.add(new int[] {0, 0});
        visited.add(new AbstractMap.SimpleEntry<>(0, 0));
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty() && k > 0) {
            int[] tmp = queue.remove();
            res.add(Arrays.asList(nums1[tmp[0]], nums2[tmp[1]]));
            if (tmp[0] < nums1.length-1 && !visited.contains(new AbstractMap.SimpleEntry<>(tmp[0]+1, tmp[1]))) {
                queue.add(new int[] {tmp[0]+1, tmp[1]});
                visited.add(new AbstractMap.SimpleEntry<>(tmp[0]+1, tmp[1]));
            }
            if (tmp[1] < nums2.length-1 && !visited.contains(new AbstractMap.SimpleEntry<>(tmp[0], tmp[1]+1))) {
                queue.add(new int[] {tmp[0], tmp[1]+1});
                visited.add(new AbstractMap.SimpleEntry<>(tmp[0], tmp[1]+1));
            }
            k--;
        }
        return res;
    }
}
