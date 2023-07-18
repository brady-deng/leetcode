package main.java.lc.list;

import java.util.Arrays;
import java.util.Scanner;

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
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/23
 **/
public class L134 {
    public static void main(String[] args) {
        System.out.println("Please input the nums");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] gas = new int[n];
        int[] cost = new int[n];
        System.out.println("Please input the gas:");
        gas = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Please input the cost:");
        cost = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(canCompleteCircuit(gas, cost));
        System.out.println(L134Ans.ans(gas, cost));

    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] rest = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            rest[i] = gas[i] - cost[i];
        }
        int leftGas = 0;
        int res = -1;
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return res;
        }
        for (int i = 0; i < rest.length; i++) {
            for (int j = i; j < i+rest.length; j++) {
                if (j < rest.length) {
                    leftGas += rest[j];
                }
                else {
                    leftGas += rest[j-rest.length];
                }
                if (leftGas < 0) {
                    leftGas = 0;
                    break;
                }
                if (j-i == rest.length-1) {
                    res = i;
                    return res;
                }
            }
        }
        return res;
    }
}
