import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    List<Integer> output = new ArrayList<>();

    private void recursion(TreeNode root) {
        if (root.left != null) {
            recursion(root.left);
        }

        output.add(root.val);

        if (root.right != null) {
            recursion(root.right);
        }

    }
 
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return output;
        }
        
        recursion(root);

        return output;
    }

    public static void main(String[] args) {
        
    }
}