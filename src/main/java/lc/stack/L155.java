package lc.stack;

import lc.common.ob.ListNode;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/27
 **/
public class L155 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());

    }
    public static class MinStack {
        ListNode listNode;
        int min;

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int val) {
            ListNode tmp = new ListNode(val);
            if (listNode == null) {
                listNode = tmp;
                min = tmp.val;
            }
            else {
                tmp.next = listNode;
                listNode = tmp;
                if (tmp.val < min) {
                    min = tmp.val;
                }
            }
        }

        public void pop() {
            listNode = listNode.next;
        }

        public int top() {
            return listNode.val;
        }

        public int getMin() {
            return min;
        }
    }
}
