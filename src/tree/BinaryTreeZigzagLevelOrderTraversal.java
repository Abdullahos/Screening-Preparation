package tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder_base_solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        visit_base_solution(root, 0, result);

        return result;
    }

    private void visit_base_solution(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }

        if (level % 2 == 0) {
            result.get(level).add(root.val);
        } else {
            result.get(level).add(0, root.val);
        }

        visit_base_solution(root.left, level + 1, result);
        visit_base_solution(root.right, level + 1, result);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Theoretically using the Deque should make time complexity O(n) instead of O(n^2) but java handles Lists better than linked list
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Deque<Integer>> listOfQueues = new ArrayList<>();

        visit(root, 0, listOfQueues);

        for (Deque<Integer> q : listOfQueues) {
            result.add(new ArrayList<>(q));
        }

        return result;
    }

    private void visit(TreeNode root, int level, List<Deque<Integer>> listOfQueues) {
        if (root == null) {
            return;
        }

        if (listOfQueues.size() < level + 1) {
            listOfQueues.add(new LinkedList<>());
        }

        if (level % 2 == 0) {
            listOfQueues.get(level).add(root.val);
        } else {
            listOfQueues.get(level).addFirst(root.val);
        }

        visit(root.left, level + 1, listOfQueues);
        visit(root.right, level + 1, listOfQueues);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Iterative approach, t: O(n), s(n)
    public List<List<Integer>> zigzagLevelOrderIterative(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isToLeft = false;

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (isToLeft) {
                    list.addFirst(node.val);
                } else {
                    list.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(list);
            isToLeft = !isToLeft;
        }

        return result;
    }

}
