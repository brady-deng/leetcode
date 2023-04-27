package main.java.lc.sort.impl;


import main.java.lc.common.util.ArrayUtil;
import main.java.lc.sort.Sort;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/3
 **/
public class BubbleSort implements Sort {
    public int[] sort(int[] sort) {
        for (int i = 0; i < sort.length-1;i++) {
            for (int j = 0; j < sort.length-1; j++) {
                if (sort[j] > sort[j+1]) {
                    ArrayUtil.swap(sort, j, j+1);
                }
            }
        }
        return sort;
    }
}
