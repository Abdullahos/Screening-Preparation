package tree;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBSTRec(root) != null;
    }

    private Integer[] isValidBSTRec(TreeNode root) {
        Integer[] l = null, r = null;
        if (root.left == null && root.right == null) {
            return new Integer[] {root.val, root.val};
        }
        if (root.left != null) {
            l = isValidBSTRec(root.left);
            if (l == null || l[1] >= root.val) {
                return null;
            }
        }
        if (root.right != null) {
            r = isValidBSTRec(root.right);
            if (r == null || r[0] <= root.val) {
                return null;
            }
        }

        int min = l != null ? l[0] : root.val;
        int max = r != null ? r[1] : root.val;

        return new Integer[] {min, max};

    }

}
