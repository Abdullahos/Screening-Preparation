package tree;



public class Successor {

    boolean found;

//    public TreeNode getSuccessorNode(TreeNode root, TreeNode node) {
//        if (root == null) return null;
//        if (root.val == node.val) {
//            found = true;
//            return dfs(root.right);
//        } else {
//            if (root.val > node.val) {
//                TreeNode left = getSuccessorNode(root.left, node);
//                if (left != null) return left;
//            }
//            if (found) return root;
//            TreeNode right = getSuccessorNode(root.right, node);
//            return right;
//        }
//    }
//
//    private TreeNode dfs(TreeNode root) {
//        if (root == null) return null;
//        TreeNode left = dfs(root.left);
//        return left != null ? left : root;
//    }
//
//

    private TreeNode getSuccessor(TreeNode root, int val) {
        TreeNode node = findNode(root, val);
        if (node == null) return null;

        if (node.right != null) return getMostLeft(node.right);

        while (node.parent != null) {
            TreeNode parent = node.parent;
            if (node.val < parent.val) {
                return parent;
            } else {
                node = parent;
            }
        }
        return null;
    }
   private TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val >= val) {
            return findNode(root.left, val);
        }
        return findNode(root.right, val);
    }

    private TreeNode getMostLeft(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

}
