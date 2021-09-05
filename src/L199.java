import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/30
 **/
public class L199 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        TreeNode root = TreeNode.deserialize(scanner.nextLine());
        System.out.println(rightSideView(root));
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            res.add(root.val);
            recurRightView(Collections.singletonList(root), res);
        }
        return res;
    }
    public static void recurRightView(List<TreeNode> parentNode, List<Integer> res) {
        if (!parentNode.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            boolean found = false;
            for (TreeNode item:parentNode) {
                if (item.right != null) {
                    if (!found) {
                        res.add(item.right.val);
                        found = true;
                    }
                    next.add(item.right);
                }
                if (item.left != null) {
                    if (!found) {
                        res.add(item.left.val);
                        found = true;
                    }
                    next.add(item.left);
                }
            }
            recurRightView(next, res);
        }
    }
}
