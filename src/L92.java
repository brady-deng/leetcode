import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L92 {
    public static void main(String[] args) {
        System.out.println("Please input the num of nodes:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i<n; i++) {
            System.out.println("Please input the num:");
            cur.val = scanner.nextInt();
            if (i != n-1) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        System.out.println("Please input the num left:");
        int l = scanner.nextInt();
        System.out.println("Please input the num right:");
        int r = scanner.nextInt();
        System.out.println(reverseBetween(head, l, r));

    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int depth = 0;
        ListNode lPre = null;
        ListNode rNext = null;
        ListNode cur = head;
        List<ListNode> tar = new ArrayList<>();
        while (cur != null) {
            if (depth+2 == left) {
                lPre = cur;
            }
            else if (depth == right) {
                rNext = cur;
            }
            else if (depth >= left-1 && depth < right) {
                tar.add(cur);
            }
            depth++;
            cur = cur.next;
        }
        for (int i = tar.size()-1; i>0; i--) {
            tar.get(i).next = tar.get(i-1);
        }
        if (rNext != null) {
            tar.get(0).next = rNext;
        }
        else {
            tar.get(0).next = null;
        }
        if (lPre != null) {
            lPre.next = tar.get(tar.size()-1);
            return head;
        }
        return tar.get(tar.size()-1);

    }
}
