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
        String s = scanner.nextLine();
        if (s != null && !s.equals("")) {
            int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
            return ListNode.deserialize(nums);
        }
        else {
            return null;
        }
    }

    public static TreeNode inputTree() {
        System.out.println("Please input the treeNodes:");
        String s = scanner.nextLine();
        return TreeNode.deserialize(s);
    }

    public static int inputNum() {
        System.out.println("Please input the nums:");
        return scanner.nextInt();
    }


    public static String inputString() {
        System.out.println("Please input the string:");
        return scanner.nextLine();
    }


    public static ListNode reverseNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
