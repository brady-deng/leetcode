package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/24
 **/
public class L148 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes");
        Scanner scanner = new Scanner(System.in);
        ListNode head = ListNode.deserialize(Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray());
        head = sortList(head);
        System.out.println(head);
    }


    public static ListNode sortList(ListNode head) {
        if (head != null) {
            List<ListNode> array = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                array.add(cur);
                cur = cur.next;
            }
            partition(array, 0, array.size());
            for (int i = 0; i < array.size(); i++) {
                if (i == array.size()-1){
                    array.get(i).next = null;
                }
                else {
                    array.get(i).next = array.get(i+1);
                }
            }
            return array.get(0);
        }
        else {
            return null;
        }
    }
    public static void partition(List<ListNode> nodes, int left, int right) {
        if (left < right) {
            int m = quickSort(nodes, left, right);
            partition(nodes, left, m);
            partition(nodes, m+1, right);
        }
    }

    public static int quickSort(List<ListNode> nodes, int left, int right) {
        ListNode high = nodes.get(right-1);
        int low = left;
        for (int i = left; i < right; i++) {
            if (nodes.get(i).val < high.val) {
                ListNode tmp = nodes.get(low);
                nodes.set(low, nodes.get(i));
                nodes.set(i, tmp);
                low++;
            }
        }
        nodes.set(right-1, nodes.get(low));
        nodes.set(low, high);
        return low;
    }
}
