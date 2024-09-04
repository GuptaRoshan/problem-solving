package neetcode150.trees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_226 {

    /**
     * BFS Implementation
     *
     * @param root root node
     * @return root node
     */
    public static TreeNode BFS(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) queue.add(current.left);

            if (current.right != null) queue.add(current.right);

            if (current.left != null || current.right != null) {
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
            }
        }

        return root;
    }

    /**
     * DFS Implementation
     *
     * @param root root node
     * @return root node
     */
    public static TreeNode DFS(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        DFS(root.left);
        DFS(root.right);

        return root;
    }

    public static TreeNode invertTree(TreeNode root) {
        return DFS(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(invertTree(root));
    }

}
