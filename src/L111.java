import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/30
 **/
public class L111 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        TreeNode head = TreeNode.deserialize(scanner.nextLine());
        System.out.println(minDepth(head));
    }
    public static int minDepth(TreeNode root) {
        if (root != null) {
            int[] min = new int[]{Integer.MAX_VALUE};
            int depth = 0;
            miniDepth(root, depth, min);
            return min[0];
        }
        else {
            return 0;
        }
    }

    public static void miniDepth(TreeNode root, int depth, int[] min) {
        if (root != null) {
            depth++;
            if (root.left != null) {
                miniDepth(root.left, depth, min);
            }
            if (root.right != null) {
                miniDepth(root.right, depth, min);
            }
            if (root.left == null && root.right == null) {
                if (depth < min[0]) {
                    min[0] = depth;
                }
            }
        }
    }
}
