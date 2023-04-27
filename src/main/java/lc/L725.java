package main.java.lc;

import main.java.lc.common.ob.ListNode;

import java.util.Arrays;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/9/15
 **/
public class L725 {
    public static void main(String[] args) {
        ListNode head = LUtil.inputNodes();
        int k = LUtil.inputNum();
        System.out.println(Arrays.toString(splitListToParts(head, k)));
    }
    public static ListNode[] splitListToParts(ListNode head, int k) {
        if (head != null) {
            ListNode[] res = new ListNode[k];
            ListNode cur = head;
            int dep = 0;
            while (cur != null) {
                dep++;
                cur = cur.next;
            }
            cur = head;
            int ind = 0;
            if (dep > k) {

              while (k > 0) {
                  int tmp = (int) Math.ceil((float) dep / k);
                  dep-=tmp;
                  k--;
                  int i = 1;
                  ListNode newHead = cur;
                  while (i < tmp) {
                      cur = cur.next;
                      i++;
                  }
                  ListNode next = cur.next;
                  cur.next = null;
                  res[ind] = newHead;
                  cur = next;
                  ind++;
              }
              return res;
            }
            else {
                int i = 0;
                cur = head;
                while (i < dep) {
                    ListNode next = cur.next;
                    cur.next = null;
                    res[i] = cur;
                    cur = next;
                    i++;
                }
                return res;
            }
        }
        else {
            return new ListNode[k];
        }
    }
}
