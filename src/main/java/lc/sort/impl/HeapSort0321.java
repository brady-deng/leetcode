package lc.sort.impl;

public class HeapSort0321 implements lc.sort.Sort {

    @Override
    public int[] sort(int[] nums) {
        HeapSort(nums);
        return nums;
    }

    public void HeapSort(int[] arr) {
        for (int i = arr.length/2-1; i>-1;i--) {
            buildHeap(arr, i, arr.length);
        }
        for (int i = 0; i < arr.length; i++) {
            lc.util.LUtil.swap(arr, 0, arr.length-1-i);
            buildHeap(arr,0, arr.length-i-1);
        }
    }

    public void buildHeap(int[] arr, int i, int len) {
        int l = (i<<1)+1;
        int r = (i<<1)+2;
        int min = i;
        if (l < len && arr[l] > arr[min]) {
            min = l;
        }
        if (r < len && arr[r] > arr[min]) {
            min = r;
        }
        if (min != i) {
            lc.util.LUtil.swap(arr, i, min);
            buildHeap(arr, min, len);
        }
    }
}
