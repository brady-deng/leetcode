package main.java.lc.list;

/**
 * cur, current remind gas
 * total, total remind gas
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/23
 **/
public class L134Ans {
    public static int ans(int[] gas, int[] cost) {
        int cur = 0;
        int total = 0;
        int can = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            total += gas[i] - cost[i];
            // if cur < 0, starting from 0 to i will all failed
            if (cur < 0) {
                can=i+1;
                cur = 0;
            }
        }
        return total<0?-1:can;
    }
}
