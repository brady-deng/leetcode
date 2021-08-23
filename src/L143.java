import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/23
 **/
public class L143 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        ListNode head = ListNode.deserialize(nums);
        reorderList(head);
        System.out.println(head);
    }
    public static void reorderList(ListNode head) {
        List<ListNode> tmp = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            tmp.add(cur);
            cur = cur.next;
        }
        reorder(tmp, 0, tmp.size()-1, null);

    }
    public static void reorder(List<ListNode> tmp, int start, int end, ListNode pre) {
        if (start == end) {
            if (pre != null) {
                pre.next = tmp.get(start);
                tmp.get(start).next = null;
            }
        }
        else if (start > end) {
            pre.next = null;
            return;
        }
        else {
            if (pre != null) {
                pre.next = tmp.get(start);
            }
            tmp.get(start).next = tmp.get(end);
            pre = tmp.get(end);
            reorder(tmp, start+1, end-1, pre);
        }
    }
}
