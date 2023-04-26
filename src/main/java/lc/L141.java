package main.java.lc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/27
 **/
public class L141 {
    public static void main(String[] args) {
        System.out.println("please input the string s:");
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(hasCycle(ListNode.deserialize(nums)));
    }
    public static boolean hasCycle(ListNode head) {
        if (head != null && head.next != null) {
            ListNode fast = head.next.next;
            ListNode slow = head.next;
            while (fast != slow && fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast == slow && fast != null) {
                return true;
            }
            else return false;
        }
        return false;
    }
}
