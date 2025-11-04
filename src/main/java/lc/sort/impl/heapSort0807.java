package lc.sort.impl;

import lc.sort.Sort;

public class heapSort0807 implements Sort {


    @Override
    public int[] sort(int[] sort) {
        buildHeap(sort);
        int temp = sort[0];
        sort[0] = sort[sort.length-1];
        sort[sort.length-1] = temp;
        for (int i = sort.length-1; i>0;i--) {
            maxHeap(sort, 0, i);
            temp = sort[0];
            sort[0] = sort[i-1];
            sort[i-1] = temp;
        }
        return sort;
    }

    public void buildHeap(int[] sort) {
        for (int i = sort.length/2; i > -1; i--) {
            maxHeap(sort, i, sort.length);
        }
    }

    public void maxHeap(int[] sort, int root, int end) {
        int left = 2*root+1;
        int right = 2*root+2;
        int max = root;
        if (left < end && sort[left] > sort[max]) {
            max = left;
        }
        if (right < end && sort[right] > sort[max]) {
            max = right;
        }
        if (max != root) {
            int temp = sort[root];
            sort[root] = sort[max];
            sort[max] = temp;
            maxHeap(sort, max, end);

        }
    }
}
