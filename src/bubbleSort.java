import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/3
 **/
public class bubbleSort {
    public static void main(String[] args) throws Exception {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
//        System.out.println(Arrays.toString(sort(nums)));
//        System.out.println(Arrays.toString(selectionSort.sort(nums)));
//        quickSort.sort(nums, 0, nums.length);
//        mergeSort.mergeSort(nums);
        quickSort.sort(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] sort(int[] sort) {
        for (int i = 0; i < sort.length-1;i++) {
            for (int j = 0; j < sort.length-1; j++) {
                if (sort[j] > sort[j+1]) {
                    int temp = sort[j+1];
                    sort[j+1] = sort[j];
                    sort[j] = temp;
                }
            }
        }
        return sort;
    }
}
