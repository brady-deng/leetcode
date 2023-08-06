package main.java.lc;

import main.java.lc.common.ob.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/10/27
 **/
public class L445 {
    public static void main(String[] args) {
        ListNode l1 = LUtil.inputNodes();
        ListNode l2 = LUtil.inputNodes();
        System.out.println(new L445().addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l3, ListNode l4) {
        ListNode l1 = LUtil.reverseNode(l3);
        ListNode l2 = LUtil.reverseNode(l4);
        List<ListNode> res = new ArrayList<>();
        int carry = 0;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + carry;
            int val = tmp > 9? tmp - 10: tmp;
            carry = tmp > 9? 1:0;
            ListNode cur = new ListNode(val);
            res.add(cur);
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int tmp = l1.val + carry;
            int val = tmp > 9? tmp - 10: tmp;
            carry = tmp > 9? 1:0;
            ListNode cur = new ListNode(val);
            res.add(cur);
            l1 = l1.next;
        }
        while (l2 != null) {
            int tmp = l2.val + carry;
            int val = tmp > 9? tmp - 10: tmp;
            carry = tmp > 9? 1:0;
            ListNode cur = new ListNode(val);
            res.add(cur);
            l2 = l2.next;
        }
        if (carry != 0) {
            res.add(new ListNode(carry));
        }
        for (int i = res.size()-1;i>0;i--) {
            res.get(i).next = res.get(i-1);
        }
        return res.get(res.size()-1);
    }
}
