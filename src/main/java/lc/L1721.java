package main.java.lc;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/9/15
 **/
public class L1721 {

    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
        int k = LUtil.inputNum();
        System.out.println(swapNodes(head, k));
    }

    public static ListNode swapNodes(ListNode head, int k) {
        if (head != null) {
            int i = 1;
            int dep = 0;
            ListNode cur = head;
            ListNode posNode = head;

            while (cur != null) {
                dep++;
                if (i == k) {
                    posNode = cur;
                }

                cur = cur.next;
                i++;
            }
            i = 1;
            ListNode negNode = head;

            while (dep-i+1 != k) {
                i++;

                negNode = negNode.next;
            }
            int val = posNode.val;
            posNode.val = negNode.val;
            negNode.val = val;
            return head;
        }
        return head;
    }
}
