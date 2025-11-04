package lc.map_set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <p>
 *     Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 * </p>
 * <a href = https://leetcode.com/problems/longest-consecutive-sequence/>ref</a>
 * <p>
 *     [100,4,200,1,3,2] --> 4
 * [0,3,7,2,5,8,4,6,0,1] --> 9
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/22
 **/
public class L128 {
    public static void main(String[] args) {
        System.out.println("Please input the nums:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (start.isEmpty()) {
                start.add(nums[i]-1);
                end.add(nums[i]+1);
            }
            else if (start.contains(nums[i])) {
                int tmp = nums[i];
                start = start.stream().map(item->{
                    if(item == tmp) {
                        return item - 1;
                    }
                    else {
                        return item;
                    }
                }).collect(Collectors.toList());
                mergeList(start,end);
            }
            else if (end.contains(nums[i])) {
                int tmp = nums[i];
                end = end.stream().map(item->{
                    if(item == tmp) {
                        return item + 1;
                    }
                    else {
                        return item;
                    }
                }).collect(Collectors.toList());
                mergeList(start,end);
            }
            else {
                start.add(nums[i]-1);
                end.add(nums[i]+1);
            }

        }

        return merge(start, end);
    }
    public static void mergeList(List<Integer> start, List<Integer> end) {
        for (int i = 0; i < start.size(); i++) {
            for ( int j = i+1; j < start.size(); j++) {
                if (start.get(i) > start.get(j) && start.get(i) < end.get(j)) {
                    start.set(i, start.get(j));
                }
                if (end.get(i) > start.get(j) && end.get(i) < end.get(j)) {
                    end.set(i, end.get(j));
                }
            }
        }
    }

    public static int merge(List<Integer> start, List<Integer> end) {
        int res = 0;
        for (int i = 0; i < start.size(); i++) {
            if (end.get(i) - start.get(i)-1 > res) {
                res = end.get(i) - start.get(i)-1;
            }
        }
        return res;
    }
}
