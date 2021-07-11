
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
        String tmp = "";
        if (left != null) {
         tmp+= " left: "+left.toString();
        }
        else {
            tmp += " left: null";
        }
        if (right != null) {
         tmp += " right: "+right.toString();
        }
        else {
            tmp+=" right: null";
        }
        return tmp+ " val: " + this.val;
    }
}