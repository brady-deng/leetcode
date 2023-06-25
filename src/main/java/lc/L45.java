package main.java.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *     You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 * </p>
 * <a href = https://leetcode.com/problems/jump-game-ii/>ref</a>
 * <p>
 *     [2,3,1,1,4] 2
 * [2,3,0,1,4] 2
 * </p>
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
