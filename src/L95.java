import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L95 {
    public static void main(String[] args) {
        System.out.println("Please input the n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<TreeNode> res = generateTrees(n);
        System.out.println(res);
    }
    public static List<TreeNode> generateTrees(int n) {
        if (n > 1) {
            List<TreeNode> res = new ArrayList<>();
            List<TreeNode> tmpRes = generateTrees(n-1);
            tmpRes.forEach(item->{
                TreeNode treeNode = new TreeNode(n);
                treeNode.left = item;
                res.add(treeNode);
                TreeNode tmp = copyTreeNode(item);
                TreeNode head = tmp;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = new TreeNode(n);
                res.add(head);
            });
            return res;
        }
        else {
            return new ArrayList<TreeNode>() {{
               add(new TreeNode(1));
            }};
        }
    }
    public static TreeNode copyTreeNode(TreeNode head) {
        if (head != null) {
            return new TreeNode(head.val, copyTreeNode(head.left), copyTreeNode(head.right));
        }
        else {
            return null;
        }
    }
}
