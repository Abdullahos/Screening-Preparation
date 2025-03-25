package tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree101 {

    List<Integer> list = new ArrayList<>();
    public boolean isBST(TreeNode root) {
        if (root == null) return true;
        flattenTreeIntoList(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) return false;
        }
        return true;
    }

    private void flattenTreeIntoList(TreeNode node) {
        if (node == null) {
            return;
        }
        flattenTreeIntoList(node.left);
        list.add(node.val);
        flattenTreeIntoList(node.right);
    }
}
