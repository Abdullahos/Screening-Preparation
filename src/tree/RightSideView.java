package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    //Recursive. t: O(n), s: O(h)
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> view = new ArrayList<>();

        visit(root, 0, view);

        return view;
    }

    private void visit(TreeNode node, int level, List<Integer> view) {
        if (node == null) {
            return;
        }

        if (view.size() < level + 1) {
            view.add(node.val);
        } else {
            view.set(level, node.val);
        }

        visit(node.left, level + 1, view);
        visit(node.right, level + 1, view);
    }

    //Iterative, t: O(n), s: O(n)
    public List<Integer> rightSideView_Iterative(TreeNode root) {
        List<Integer> view = new ArrayList<>();

        if (root == null) {
            return view;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            TreeNode lastNode = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }

                lastNode = node;
            }

            view.add(lastNode.val);

        }

        return view;
    }

}
