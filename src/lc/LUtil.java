package lc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/29
 **/
public class LUtil {
    private static Scanner scanner = new Scanner(System.in);
    public static int[] inputNums() {
        System.out.println("Please input the nums:");
        return Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static ListNode inputNodes() {
        System.out.println("Please input the nodes:");
        return ListNode.deserialize(Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray());
    }

    public static int inputNum() {
        System.out.println("Please input the nums:");
        return scanner.nextInt();
    }
}
