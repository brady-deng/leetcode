package main.java.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/23
 **/
public class L142 {
    public static Map<Integer, Integer> map = new HashMap<>();
    public ListNode detectCycle(ListNode head) {
        while (head != null) {
            int tmp = map.getOrDefault(head.hashCode(), 0);
            if (tmp == 1) {
                return head;
            }
            map.put(head.hashCode(), 1);
            head = head.next;
        }
        return null;
    }
}
