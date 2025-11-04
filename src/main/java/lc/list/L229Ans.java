package lc.list;

import lc.util.LUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2024/1/28
 **/
public class L229Ans {
    public static void main(String[] args) {
        int[] nums = LUtil.inputNums();
        System.out.println(new L229Ans().majorityElement(nums));
    }
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;
        for (int num : nums) {
            if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2 = 1;
            } else if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length/3) {
            res.add(candidate1);
        }
        if (count2 > nums.length/3) {
            res.add(candidate2);
        }
        return res;
    }
}
