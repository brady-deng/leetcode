package main.java.lc.sort.impl;

import main.java.lc.sort.Sort;
import main.java.lc.common.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/3
 **/
public class HeapSort implements Sort {
    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            ArrayUtil.swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // head
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            ArrayUtil.swap(arr, i, largest);
            // cause there is a swap, need to heapify the leaf node after the swap of largest and i
            heapify(arr, largest, len);
        }
    }


}
