package main.java.lc.list;

import main.java.lc.util.LUtil;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *     Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * </p>
 * <a href=https://leetcode.com/problems/top-k-frequent-elements/description/>ref</a>
 * <p>
 *  Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 2024/2/3
 **/
public class L347 {

    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        int n = LUtil.inputNum();
        int[] res = new L347().topKFrequent(nums, n);
        LUtil.ourputString(res);
    }
    static class NumFreq implements Comparable<NumFreq>{
        int num;
        int freq;
        public NumFreq(int num) {
            this.num = num;
            this.freq = 1;
        }
        public int getNum() {
            return this.num;
        }

        public int getFreq() {
            return this.freq;
        }

        public void increFreq() {
            this.freq++;
        }

        @Override
        public int compareTo(NumFreq o) {
            return this.getFreq()-o.getFreq();
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, NumFreq> freq = new HashMap<>();
        for (int num : nums) {
            NumFreq numFreq = freq.getOrDefault(num, new NumFreq(num));
            numFreq.increFreq();
            freq.put(num, numFreq);
        }
        NumFreq[] numFreqs = freq.values().toArray(new NumFreq[0]);
        FindK<NumFreq> findK = new FindK<>();
        findK.findLarge(numFreqs, k);
        int [] res = new int[k];
        int i = 0;
        while (i < k) {
            res[i] = numFreqs[i].getNum();
            i++;
        }
        return res;
    }
}
