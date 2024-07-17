package dataStructure.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {

    /**
     * Level order problems.tree traversal(BFS)
     **/
    public static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            System.out.print(x.val + " ");
            if (x.left != null) queue.add(x.left);
            if (x.right != null) queue.add(x.right);
        }
    }


    /**
     * Depth First Search recursion
     * Preorder
     **/
    static void preorderRecursion(TreeNode node) {
        if (node == null) return;

        System.out.print(node.val + " ");
        preorderRecursion(node.left);
        preorderRecursion(node.right);
    }


    /**
     * Depth First Search recursion
     * Postorder
     **/
    static void postorderRecursion(TreeNode node) {
        if (node == null) return;

        postorderRecursion(node.left);
        postorderRecursion(node.right);
        System.out.print(node.val + " ");
    }

    /**
     * Depth First Search recursion
     * Inorder
     **/
    static void inorderRecursion(TreeNode node) {
        if (node == null) return;

        inorderRecursion(node.left);
        System.out.print(node.val + " ");
        inorderRecursion(node.right);
    }

    /**
     * Depth First Search iterative
     * Preorder
     **/
    public static void preorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode x = stack.pop();
            System.out.print(x.val + " ");
            if (x.right != null) stack.add(x.right);
            if (x.left != null) stack.add(x.left);
        }
    }


    /**
     * Depth First Search iterative
     * Inorder
     **/
    public static void inorderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }


    /**
     * Depth First Search iterative
     * Postorder
     **/
    public static void postorderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.push(node);

            // Push the left child first, so it's processed after the right child
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        while (!output.isEmpty()) {
            System.out.print(output.pop().val + " ");
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println("\nLevel order traversal(BFS) : ");
        bfs(root);


        System.out.println("\n\n---------------------------------");

        System.out.println("\nPreorder using recursion(DFS) : ");
        preorderRecursion(root);

        System.out.println("\nInorder using recursion(DFS) : ");
        inorderRecursion(root);

        System.out.println("\nPostorder using recursion(DFS) : ");
        postorderRecursion(root);


        System.out.println("\n\n---------------------------------");

        System.out.println("\nPreorder using iterative(DFS) : ");
        preorderIterative(root);

        System.out.println("\nInorder using iterative(DFS) : ");
        inorderIterative(root);

        System.out.println("\nInorder using iterative(DFS) : ");
        postorderIterative(root);
    }
}
