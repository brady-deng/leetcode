import java.util.*;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/20
 **/
public class L107 {
    public static void main(String[] args) {
        System.out.println("Please input the s:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        TreeNode head = TreeNode.deserialize(s);
        System.out.println(levelOrderBottom(head));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null != root) {
            List<List<Integer>> tmp = new ArrayList<>();
            getStact(Collections.singletonList(root), tmp);
            while (!tmp.isEmpty()) {
                res.add(tmp.remove(tmp.size()-1));
            }
        }
        return res;
    }

    public static void getStact(List<TreeNode> head, List<List<Integer>> res) {
        if (!head.isEmpty()) {
            List<TreeNode> nextNodes = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            head.forEach(item->{
                tmp.add(item.val);
                if (item.left != null) {
                    nextNodes.add(item.left);
                }
                if (item.right != null) {
                    nextNodes.add(item.right);
                }
            });
            res.add(tmp);
            getStact(nextNodes, res);
        }
        else {
            return;
        }

    }
}
