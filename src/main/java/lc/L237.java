package main.java.lc;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/9/14
 **/
public class L237 {
    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
    }

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        if (next == null) {
            node = null;
        }
        else {
            node.val = next.val;
            node.next = next.next;
        }
    }
}
