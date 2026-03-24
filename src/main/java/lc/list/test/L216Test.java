package main.java.lc.list.test;

import main.java.lc.list.L216;

import java.util.ArrayList;
import java.util.List;

public class L216Test extends L216 {


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        recurFindSum3(k, n, 1, 0, res, new ArrayList<>());
        return res;
    }

    public void recurFindSum3(int k, int n, int num, int ind, List<List<Integer>> res, List<Integer> cur) {
        if (num > 10 || ind > k || n < 0) {
            return;
        } else if (n == 0 && ind == k) {
            res.add(new ArrayList<>(cur));
        } else {
            while (num < 10) {
                cur.add(num);
                int remain = n-num;
                num++;
                recurFindSum3(k, remain, num, ind+1, res, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}
