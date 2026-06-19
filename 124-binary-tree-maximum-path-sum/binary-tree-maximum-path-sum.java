class Solution {
    // Global variable to track the maximum path sum found so far
    // Initialize to -1001 since node values can be as low as -1000
    private int maxSum = -1001;
  
    /**
     * Finds the maximum path sum in a binary tree.
     * A path can start and end at any nodes in the tree.
     * 
     * @param root The root of the binary tree
     * @return The maximum sum of any path in the tree
     */
    public int maxPathSum(TreeNode root) {
        calculateMaxGain(root);
        return maxSum;
    }
  
    /**
     * Helper method that calculates the maximum gain from each node.
     * The gain represents the maximum sum of a path that starts from this node
     * and goes down to one of its descendants (or just the node itself).
     * 
     * @param node The current node being processed
     * @return The maximum gain that can be obtained starting from this node going downward
     */
    private int calculateMaxGain(TreeNode node) {
        // Base case: if node is null, contribution is 0
        if (node == null) {
            return 0;
        }
      
        // Recursively calculate the maximum gain from left subtree
        // Use Math.max with 0 to ignore negative paths (we can choose not to include them)
        int leftGain = Math.max(0, calculateMaxGain(node.left));
      
        // Recursively calculate the maximum gain from right subtree
        // Use Math.max with 0 to ignore negative paths
        int rightGain = Math.max(0, calculateMaxGain(node.right));
      
        // Calculate the maximum path sum that passes through the current node
        // This path includes the current node, potentially the left path, and potentially the right path
        int currentMaxPath = node.val + leftGain + rightGain;
      
        // Update the global maximum if the current path sum is greater
        maxSum = Math.max(maxSum, currentMaxPath);
      
        // Return the maximum gain from this node to its parent
        // Parent can only use one branch (either left or right) plus the current node's value
        return node.val + Math.max(leftGain, rightGain);
    }
}