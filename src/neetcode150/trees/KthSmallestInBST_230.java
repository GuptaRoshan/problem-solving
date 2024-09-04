package neetcode150.trees;

import java.util.Stack;

public class KthSmallestInBST_230 {

    int count = 0;
    int result = Integer.MIN_VALUE;

    /**
     * Does the inorder traversal that gives an element in sorted order
     * count the element and when count == k, return the element?
     * <p>
     * This can also be solved using Arraylist, push all the elements in list and return kth the smallest element
     *
     * @param root root of the tree
     * @param k    smallest element to find
     */
    public void inorderDFS(TreeNode root, int k) {
        if (root == null) return;

        if(count >= k) return;

        inorderDFS(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inorderDFS(root.right, k);
    }

    /**
     * Iterative inorder traversal
     *
     * @param root root of the tree
     * @param k   smallest element to find
     * @return kth smallest element
     */
    public int inorderIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            k--;
            if (k == 0) return current.val;
            current = current.right;
        }

        return -1;
    }

    public int kthSmallest(TreeNode root, int k) {
        inorderDFS(root, k);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        System.out.println(new KthSmallestInBST_230().kthSmallest(root, 2));
    }


}
