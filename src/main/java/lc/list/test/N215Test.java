package main.java.lc.list.test;

import main.java.lc.util.LUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2024/6/9
 **/
public class N215Test {


    public static void main(String[] args) {
        int[] data = LUtil.inputNums();
        int k = LUtil.inputNum();
        int m = LUtil.inputNum();
        List<List<Integer>> res = new N215Test().solution(data, k, m);
        System.out.println(res);
    }

    /**
     * 给定数组data，返回满足条件的数组（k个数之和为m）
     * 1,2,3,4,5,6,8,10
     * @param data
     * @param k
     * @param m
     * @return
     */
    public List<List<Integer>> solution(int[] data, int k, int m) {
        Arrays.sort(data);
        List<List<Integer>> res = new ArrayList<>();
        recurSolution(data, res, k, m, 0, new ArrayList<>());
        return res;
    }

    public void recurSolution(int[] data, List<List<Integer>> res, int k, int m, int cur, List<Integer> tmp) {
        if (k == 0) {
            if (m == 0) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        for (int i = cur; i < data.length; i++) {
            tmp.add(data[i]);
            recurSolution(data, res, k-1, m-data[i], cur+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
