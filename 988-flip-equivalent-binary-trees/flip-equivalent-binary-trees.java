/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean result = true;

    public void traverse(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null) return;

        int val1L = root1.left == null ? -1 : root1.left.val;
        int val2L = root2.left == null ? -1 : root2.left.val;
        int val1R = root1.right == null ? -1 : root1.right.val;
        int val2R = root2.right == null ? -1 : root2.right.val;

        if(val1L == val2L && val1R == val2R){
            // No flip required
        }
        else if(val1L == val2R && val1R == val2L){
            // Flip children of the second tree
            TreeNode temp = root2.left;
            root2.left = root2.right;
            root2.right = temp;
        }
        else{
            result = false;
            return;
        }

        traverse(root1.left, root2.left);
        traverse(root1.right, root2.right);
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;

        traverse(root1, root2);

        return result;
    }
}