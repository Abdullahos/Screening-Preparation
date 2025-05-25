package tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

    //t: O(n), s: O(1)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        visit(root, 0, result);

        return result;
    }

    private void visit(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        visit(node.left, level + 1, result);
        visit(node.right, level + 1, result);

    }

}
