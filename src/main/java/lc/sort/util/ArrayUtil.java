package lc.sort.util;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 20230426
 **/
public class ArrayUtil {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
