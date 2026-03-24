package main.java.lc.list.test;

import main.java.lc.list.L134;

/**
 * <p>
 *     There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
 * </p>
 * <a href=https://leetcode.com/problems/gas-station/>ref</a>
 * <p>
 *     [1,2,3,4,5]
 * [3,4,5,1,2] --> 3
 * [2,3,4]
 * [3,4,3] --> -1
 * </p>
 * <p>
 *     Medium
 * </p>
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/23
 **/
public class L134Test extends L134 {

    @Override
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0;
        int cur = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            cur+= gas[i] - cost[i];
            total+=gas[i] - cost[i];
            if (cur < 0) {
                cur = 0;
                res = i+1;
            }
        }
        return total < 0? -1: res;
    }
}
