package main.java.lc.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <p>
 *     Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 * </p>
 * <a href = https://leetcode.com/problems/triangle/>ref</a>
 * <p>
 *     [[2],[3,4],[6,5,7],[4,1,8,3]] --> 11
 * [[-10]] --> -10
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/21
 **/
public class L120 {
    public static void main(String[] args) {
        System.out.println("Please input the n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> trangle = new ArrayList<>();
        scanner.nextLine();
        for (int i =0; i<n; i++) {
            System.out.println("Please input the nums");
            trangle.add(Arrays.stream(scanner.nextLine().split(",")).map(Integer::valueOf).collect(Collectors.toList()));
        }
        System.out.println(minimumTotal(trangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] nums = new int[triangle.size()][triangle.size()];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == 0 && j == 0) {
                    nums[i][j] = triangle.get(i).get(j);
                }
                else if (j == 0) {
                    nums[i][j] = nums[i-1][j] + triangle.get(i).get(j);
                }
                else if (j == i) {
                    nums[i][j] = nums[i-1][j-1] + triangle.get(i).get(j);
                }
                else {
                    nums[i][j] = Math.min(nums[i-1][j], nums[i-1][j-1]) + triangle.get(i).get(j);
                }
                if (i == triangle.size()-1 && nums[i][j] < res) {
                    res = nums[i][j];
                }
            }
        }
        return res;
    }
}
