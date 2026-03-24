package main.java.lc.sort.impl;

import main.java.lc.sort.Sort;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/3
 **/
public class MergeSort implements Sort {
    public int[] sort(int[] arr){
        int[] temp =new int[arr.length];
        internalMergeSort(arr, temp, 0, arr.length-1);
        return arr;
    }
    private static void internalMergeSort(int[] arr, int[] temp, int left, int right){
        //当left==right的时，已经不需要再划分了
        if (left<right){
            int middle = (left+right)/2;
            internalMergeSort(arr, temp, left, middle);          //左子数组
            internalMergeSort(arr, temp, middle+1, right);       //右子数组
            mergeSortedArray(arr, temp, left, middle, right);    //合并两个子数组
        }
    }
    // 合并两个有序子序列
    private static void mergeSortedArray(int arr[], int temp[], int left, int middle, int right){
        int i=left;
        int j=middle+1;
        int k=0;
        while (i<=middle && j<=right){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <=middle){
            temp[k++] = arr[i++];
        }
        while ( j<=right){
            temp[k++] = arr[j++];
        }
        //把数据复制回原数组
        for (i=0; i<k; ++i){
            arr[left+i] = temp[i];
        }
    }
}
