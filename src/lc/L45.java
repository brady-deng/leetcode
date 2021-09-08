package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/7
 **/
public class L45 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        if (nums.length>1) {
            res.add(nums[0]);
            int i = 1;
            while (res.get(1) < nums.length-1) {
                int max = 0;
                for (int j = res.get(0);j<=res.get(1);j++) {
                    int tmp = j+nums[j];
                    if (tmp > max) max = tmp;
                }
                res.remove(0);
                res.add(max);
                i+=1;
            }
            return i;
        }
        else {
            return 0;
        }
    }
}
