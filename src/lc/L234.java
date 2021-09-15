package lc;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/9/14
 **/
public class L234 {
    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
        System.out.println(isPalindrome(head));
    }


    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow;
        slow = slow.next;
        pre.next = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        slow = pre;
        fast = head;
        while (fast != null && slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
