package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class L23 {
    public static void main(String[] args) {
        System.out.println("Please input the num of ListNode:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ListNode[] listNodes = new ListNode[n];
        List<String> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(scanner.nextLine());
        }
        AtomicInteger cn = new AtomicInteger();
        nodes.stream().filter(item-> !item.equals("")).forEach(item->{
            String[] chars = item.split(",");
            ListNode head = new ListNode();
            ListNode cur = head;
            for (int j = 0; j< chars.length;j++) {
                int tmp = Integer.parseInt(chars[j]);
                ListNode next = new ListNode();
                cur.val = tmp;
                if (j != chars.length-1) {
                    cur.next = next;
                }
                cur = cur.next;
            }
            listNodes[cn.get()] = head;
            System.out.println(head);
            cn.getAndIncrement();
        });


        System.out.println(mergeKLists(listNodes));
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;

        if (lists.length > 0) {
            long cnt = Arrays.stream(lists).filter(item-> item!=null).count();
            ListNode[] tmp = new ListNode[(int) cnt];
            int i = 0;
            for (ListNode listNode:lists) {
                if (listNode != null) {
                    tmp[i] = listNode;
                    i++;
                }
            }
            if (cnt > 0) {
                head = new ListNode();
                ListNode cur = head;
                int n = 0;
                getListNode(tmp, cur,n);
            }
        }
        return head;
    }

    public static void getListNode(ListNode[] listNodes, ListNode cur, int n) {
        if (listNodes!= null && listNodes.length > 0) {
            ListNode[] sortNode;
            if (n == 0) {
                sortNode = sortKLists(listNodes, false);
            }
            else sortNode = sortKLists(listNodes, true);
            cur.val = sortNode[0].val;
            if (!(sortNode.length == 1 && sortNode[0].next == null)) {
                cur.next = new ListNode();
                cur = cur.next;
            }
            sortNode[0] = sortNode[0].next;
            ListNode[] newList;
            if (sortNode[0] != null) {
                newList = sortNode;
            }
            else {
                newList = new ListNode[sortNode.length-1];
                System.arraycopy(sortNode, 1, newList, 0, sortNode.length-1);
            }
            getListNode(newList, cur,n+1 );
        }
    }

    public static ListNode[] sortKLists(ListNode[] listNodes,boolean flag) {
        ListNode[] res = new ListNode[listNodes.length];
        if (flag) {
            System.arraycopy(listNodes, 0, res, 0, listNodes.length);
            for (int i = 1; i < res.length; i++) {
                ListNode tmp = res[0];
                if (res[0].val >= res[i].val) {
                    if (i == res.length-1) {
                        System.arraycopy(res, 1, res, 0, i);
                        res[res.length-1] = tmp;
                    }
                }
                else {
                    System.arraycopy(res, 1, res, 0, i-1);
                    res[i-1] = tmp;
                    break;
                }
            }
        }
        else {
            for (ListNode listNode:listNodes) {
                for (int i = 0; i < res.length; i++) {
                    if (res[i] == null) {
                        res[i] = listNode;
                        break;
                    }
                    else if (listNode.val >= res[i].val) {
                    }
                    else {
                        System.arraycopy(res, i, res, i+1, listNodes.length-i-1);
                        res[i] = listNode;
                        break;
                    }
                }
            }
        }
        return res;
    }


}
