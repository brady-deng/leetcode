package main.java.lc.node;

import main.java.lc.common.ob.ListNode;
import main.java.lc.util.LUtil;

import java.util.Arrays;

/**
 * <p>
 *     Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
 *
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.
 *
 * The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
 *
 * Return an array of the k parts.
 * </p>
 * <a href=https://leetcode.com/problems/split-linked-list-in-parts/description/>ref</a>
 * <p>
 *     Input: head = [1,2,3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but its string representation as a ListNode is [].
 * </p>
 * <p>
 *     Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * Output: [[1,2,3,4],[5,6,7],[8,9,10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 * </p>
 * @author dengchenyang@tju.edu.cn
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
