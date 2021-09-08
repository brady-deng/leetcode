package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author dengchenyang.brady@bytedance.com
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
