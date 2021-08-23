import java.util.Arrays;
import java.util.Scanner;

/**
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
