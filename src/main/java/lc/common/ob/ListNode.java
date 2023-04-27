package main.java.lc.common.ob;

/**
 * @author dengchenyang.brady@bytedance.com
 * @Description
 * @Date 2021/7/4
 **/


public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode deserialize(int[] nums) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i<nums.length; i++) {
            cur.val = nums[i];
            if (i != nums.length-1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        return head;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

