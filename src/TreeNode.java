import java.util.*;
import java.util.stream.Collectors;

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static TreeNode deserialize(String string) {
        if ("{}".equals(string) || "".equals(string)) {
            return null;
        }
        List<TreeNode> nodes = Arrays.stream(string.split(",")).map(item->{
            if ("null".equals(item)) {
                return null;
            }
            else {
                return new TreeNode(Integer.parseInt(item));
            }
        }).collect(Collectors.toList());
        List<TreeNode> kids = new ArrayList<>(nodes);
        TreeNode root = kids.remove(0);
        for (TreeNode node:nodes) {
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
}
