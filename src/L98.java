import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/16
 **/
public class L98 {
    public static void main(String[] args) {
        System.out.println("Please input the nodes:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        TreeNode head = TreeNode.deserialize(s);
        System.out.println(isValidBST(head));

    }

    public static boolean isValidBST(TreeNode root) {


        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean isBST(TreeNode root,long min,long max)
    {
        if(root == null) {
            return true;
        }

        //System.out.println(root.val + " "+min + " "+max);
        if(root.val <= min || root.val >= max)
            return false;

        boolean left = isBST(root.left,min,root.val);
        boolean right = isBST(root.right,root.val,max);
        return left && right;
    }
}
