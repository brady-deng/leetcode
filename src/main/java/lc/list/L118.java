package main.java.lc.list;

import main.java.lc.util.LUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * </p>
 * @author dengchenyang.brady@bytedance.com
 * @date 20231229
 **/
public class L118 {


    public static void main(String[] args) {
        System.out.println(new L118().generate(LUtil.inputNum()));
    }

    public List<List<Integer>> generate(int numRows) {
        int i = 1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<Integer>(){{add(1);}};
        res.add(prev);
        while (i < numRows) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int c = 0; c<prev.size()-1; c++) {
                cur.add(prev.get(c)+prev.get(c+1));
            }
            cur.add(1);
            res.add(new ArrayList<>(cur));
            prev = cur;
            i++;
        }
        return res;
    }
}
