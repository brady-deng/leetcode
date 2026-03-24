package main.java.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/7/22
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node deserialize(String string) {
        if ("{}".equals(string) || "".equals(string)) {
            return null;
        }
        List<Node> nodes = Arrays.stream(string.split(",")).map(item->{
            if ("null".equals(item)) {
                return null;
            }
            else {
                return new Node(Integer.parseInt(item));
            }
        }).collect(Collectors.toList());
        List<Node> kids = new ArrayList<>(nodes);
        Node root = kids.remove(0);
        for (Node node:nodes) {
            if (node!=null) {
                if (!kids.isEmpty()) {
                    node.left = kids.remove(0);
                }
                if (!kids.isEmpty()) {
                    node.right = kids.remove(0);
                }
            }
        }
        return root;

    }

};
