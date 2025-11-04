package lc.list.test;

import lc.util.LUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定字符串s和不同字符数量k，返回满足条件的最长子序列（包含字符数量k）
 * @author dengchenyang@tju.edu.cn
 * @date 2024/6/9
 **/
public class N214Test {

    public static void main(String[] args) {
        String s = LUtil.inputString();
        int k = LUtil.inputNum();
        System.out.println(new N214Test().solution(s, k));
    }

    public int solution(String s, int k) {
        int left = 0;
        char leftChar = s.charAt(left);
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), right);
            while (map.size() > k) {
                if (map.get(leftChar) == left) {
                    map.remove(leftChar);
                }
                left++;
            }
            leftChar = s.charAt(left);
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}
