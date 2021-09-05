import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/30
 **/
public class L104 {

    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        TreeNode root = TreeNode.deserialize(scanner.nextLine());
        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root) {
        int depth = 0;
        int[] max = new int[]{0};
        recurMaxDepth(root, depth, max);
        return max[0];
    }

    public static void recurMaxDepth(TreeNode root, int depth, int[] max) {
        if (root != null) {
            depth++;
            if (depth > max[0]) max[0] = depth;
            recurMaxDepth(root.left, depth, max);
            recurMaxDepth(root.right, depth, max);
        }
    }
}
