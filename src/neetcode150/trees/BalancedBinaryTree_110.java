package neetcode150.trees;

public class BalancedBinaryTree_110 {

    // This returns the depth of subtree
    public static int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    /**
     * Top-Down Recursive Approach
     *
     * @param root root node
     * @return true if the binary tree is balanced, false otherwise
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        // Calculate the depth of the left subtree
        int left = depth(root.left);
        // Calculate the depth of the right subtree
        int right = depth(root.right);
        // Check if the difference between the left and right subtree is less than or equal to 1
        // Also, check if the left and right subtrees are balanced
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

//----------------------------------------------------------------------------------------------

    /**
     * DFS Recursive Approach
     *
     * @param root root node
     * @return height of the binary tree
     */
    public static int dfsHeight(TreeNode root) {
        // If the root is null, return 0
        if (root == null) return 0;

        // Calculate the height of the left subtree
        int left = dfsHeight(root.left);
        if (left == -1) return -1;

        // Calculate the height of the right subtree
        int right = dfsHeight(root.right);
        if (right == -1) return -1;

        // Check if the difference between the left and right subtree is less than or equal to 1
        if (Math.abs(left - right) > 1) return -1;

        // Return the maximum height of the left and right subtree
        return Math.max(left, right) + 1;
    }


    /**
     * public static boolean isBalanced(TreeNode root) {
     * return dfsHeight(root) != -1;
     * }
     **/

    public static void main(String[] args) {
        // Level 4
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(4);

        // Level 3
        TreeNode node3 = new TreeNode(3, node7, null);
        TreeNode node4 = new TreeNode(3, null, node8);

        // Level 2
        TreeNode node1 = new TreeNode(2, node3, null);
        TreeNode node2 = new TreeNode(2, node4, null);

        // Level 1 (Root)
        TreeNode root = new TreeNode(1, node1, node2);

        System.out.println(isBalanced(root));
    }
}
