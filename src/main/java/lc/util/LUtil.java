package main.java.lc.util;

import main.java.lc.common.ob.TreeNode;
import main.java.lc.common.ob.ListNode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/29
 **/
public class LUtil {
    private static Scanner scanner = new Scanner(System.in);


    public static void printArray2(int[][] nums) {
        for (int[] n : nums) {
            LUtil.printNums(n);
            System.out.println();
        }
    }

    public static char[][] inputCharArray() {
        int m = LUtil.inputNum();
        int n = LUtil.inputNum();
        char[][] res = new char[m][n];
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            res[i] = scanner.nextLine().toCharArray();
        }
        return res;
    }

    public static int[][] inputArray2() {
        int m = LUtil.inputNum();
        int n = LUtil.inputNum();
        int[][] res = new int[m][n];
        int i = 0;
        scanner.nextLine();
        while (i < m) {
            res[i] = LUtil.inputNums();
            i++;
        }
        return res;
    }

    public static int[] inputNums() {
        System.out.println("Please input the nums:");
        return Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static ListNode inputNodes() {
        System.out.println("Please input the nodes:");
        String s = scanner.nextLine();
        if (s != null && !s.equals("")) {
            int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
            return ListNode.deserialize(nums);
        }
        else {
            return null;
        }
    }

    public static ListNode deepClone(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode prev = newHead;
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            prev.next = tmp;
            head = head.next;
            prev = prev.next;
        }
        return newHead.next;
    }

    public static TreeNode inputTree() {
        System.out.println("Please input the treeNodes:");
        String s = scanner.nextLine();
        return TreeNode.deserialize(s);
    }


    public static TreeNode deepCloneTree(TreeNode root) {
        if (root != null) {
            TreeNode res = new TreeNode(root.val);
            res.left = deepCloneTree(root.left);
            res.right = deepCloneTree(root.right);
            return res;
        }
        return null;
    }

    public static int[] deepCloneNums(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public static int inputNum() {
        System.out.println("Please input the nums:");
        return scanner.nextInt();
    }

    public static void inputNextLine() {
        scanner.nextLine();
    }


    public static String inputString() {
        System.out.println("Please input the string:");
        return scanner.nextLine();
    }

    public static void printNums(int[] nums) {
        for (int num: nums) {
            System.out.print(num);
            System.out.print(" ");
        }
    }

    public static void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }


    public static ListNode reverseNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            System.out.print(",");
            head = head.next;
        }
        System.out.println();
    }
}
