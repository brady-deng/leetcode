package main.java.lc.map_set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/22
 **/
public class L128Ans {
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<Integer>();

        for(int num: nums) set.add(num);
        int max = 1;
        for(int num: nums) {
            if(set.remove(num)) {//num hasn't been visited
                int val = num;
                int sum = 1;
                while(set.remove(val-1)) val--;
                sum += num - val;

                val = num;
                while(set.remove(val+1)) val++;
                sum += val - num;

                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
