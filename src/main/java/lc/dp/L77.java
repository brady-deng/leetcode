package main.java.lc.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * <p>
 *     Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 * </p>
 * <a href = https://leetcode.com/problems/combinations/>ref</a>
 * <p>
 *     4,2 --> [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 *     1,1 --> [[1]]
 * </p>
 */
public class L77 {
    public static void main(String[] args) {
        System.out.println("Please input the n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Please input the k:");
        int k = scanner.nextInt();
        System.out.println(combine(n,k));

    }
    public static List<List<Integer>> combine(int n, int k) {
        return combineRe(n, k, new ArrayList<>());
    }

    public static List<List<Integer>> combineRe(int n, int k, List<List<Integer>> res) {
        if (n > k && k > 1) {
            List<List<Integer>> tmpN1 = combineRe(n-1,k,res);
            List<List<Integer>> tmpN = combineRe(n-1,k-1,new ArrayList<>());
            tmpN.forEach(item->item.add(n));
            tmpN1.addAll(tmpN);
            return tmpN1;
        }
        else if (k == 1) {
            AtomicInteger atomicInteger = new AtomicInteger(1);
            List<List<Integer>> tmpRes = new ArrayList<>();
            while (atomicInteger.get() <= n) {
                List<Integer> tmp = new ArrayList<Integer>(){{
                    add(atomicInteger.getAndIncrement());
                }};
                tmpRes.add(tmp);
            }
            return tmpRes;
        }
        else if (n == k){
            List<Integer> tmp = new ArrayList<>();
            AtomicInteger atomicInteger = new AtomicInteger(1);
            while (atomicInteger.get() <= n) {
                tmp.add(atomicInteger.getAndIncrement());
            }
            res.add(tmp);
            return res;
        }
        return new ArrayList<>();
    }
    public static List<List<Integer>> combineReK(int n, int k, List<List<Integer>> res) {
        if (k > 1) {
            List<List<Integer>> tmpRes = combineReK(n-1,k-1,res);
            tmpRes.forEach(item-> item.add(n));
            res.addAll(tmpRes);
            return tmpRes;
        }
        else {
            AtomicInteger atomicInteger = new AtomicInteger(1);
            List<List<Integer>> tmpRes = new ArrayList<>();
            while (atomicInteger.get() <= n) {
                List<Integer> tmp = new ArrayList<Integer>(){{
                    add(atomicInteger.getAndIncrement());
                }};
                tmpRes.add(tmp);
            }
            return tmpRes;
        }
    }
}
