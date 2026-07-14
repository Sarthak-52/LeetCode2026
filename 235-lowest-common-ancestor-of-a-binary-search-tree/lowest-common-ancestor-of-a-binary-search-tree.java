class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: we hit an empty node
        if (root == null) {
            return null;
        }

        // OPTIMIZATION: Check if the current node is p or q BEFORE recursing.
        // If it is, we return it immediately, saving us from uselessly exploring its subtrees.
        if (root == p || root == q) {
            return root;
        }

        // Search the left and right subtrees
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);

        // If both sides found a target, this current node is the intersection (LCA)
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, pass up whichever side actually found something
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}