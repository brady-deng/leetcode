package lc;

/**
 * @author dengchenyang.brady@bytedance.com
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

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int val) {
            ListNode tmp = new ListNode(val);
            if (listNode == null) {
                listNode = tmp;
            }
            else {
                tmp.next = listNode;
                listNode = tmp;
            }
        }

        public void pop() {
            listNode = listNode.next;
        }

        public int top() {
            return listNode.val;
        }

        public int getMin() {
            int min = listNode.val;
            ListNode cur = listNode;
            while (cur != null) {
                if (cur.val < min) {
                    min = cur.val;
                }
                cur = cur.next;
            }
            return min;
        }
    }
}
