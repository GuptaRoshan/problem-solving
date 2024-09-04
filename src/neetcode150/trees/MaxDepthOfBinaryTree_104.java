package neetcode150.trees;

public class MaxDepthOfBinaryTree_104 {
    /**
     * To find the depth of a node
     *
     * @param root root node
     * @return depth of the node
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1); // to find the depth of a node
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(maxDepth(root));
    }
}
