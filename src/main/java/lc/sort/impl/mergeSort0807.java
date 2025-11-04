package lc.sort.impl;

import lc.sort.Sort;

public class mergeSort0807 implements Sort {


    @Override
    public int[] sort(int[] sort) {
        int[] temp = new int[sort.length];
        mergeSort(sort, temp, 0, sort.length);
        return sort;
    }

    public void mergeSort(int[] sort, int[] temp, int start, int end) {
        if (end-start < 2) return;
        int mid = (start+end)/2;
        mergeSort(sort, temp, start, mid);
        mergeSort(sort, temp, mid, end);
        merge(sort, temp, start, mid, end);
    }

    public void merge(int[] sort, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int ind = 0;
        while (i < mid && j < right) {
            temp[ind++] = sort[i] <= sort[j]?sort[i++]:sort[j++];
        }
        while (i < mid) {
            temp[ind++] = sort[i++];
        }
        while (j < right) {
            temp[ind++] = sort[j++];
        }
        for (int c = left; c < right; c++) {
            sort[c] = temp[c-left];
        }
    }
}
