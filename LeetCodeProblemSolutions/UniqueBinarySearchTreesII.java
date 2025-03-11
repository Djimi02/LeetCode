import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return generateSubTreesRecursively(1, n);
    }

    private List<TreeNode> generateSubTreesRecursively(Integer start, Integer end) {
        if (start > end) {
            var result = new ArrayList<TreeNode>();
            result.add(null);
            return result;
        }

        var subTrees = new ArrayList<TreeNode>();
        for (int i = start; i <= end; i++) {
            var leftSubTrees = generateSubTreesRecursively(start, i - 1);
            var rightSubTrees = generateSubTreesRecursively(i + 1, end);

            for (var leftSubTree : leftSubTrees) {
                for (var rightSubTree : rightSubTrees) {
                    var root = new TreeNode(i);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    subTrees.add(root);
                }
            }
        }

        return subTrees;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new UniqueBinarySearchTreesII().generateTrees(3);
        System.out.println(treeNodes.size());
    }
}