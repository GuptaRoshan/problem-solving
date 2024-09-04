package neetcode150.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView_199 {

    /**
     * Right side view of a binary tree is the set of nodes visible when the tree is visited from the right side.
     * <p>
     * Different Tree View : <a href="https://leetcode.com/problems/binary-tree-right-side-view/solutions/3125913/java-all-tree-views-easy-fast/">...</a>
     * 1. Left/Right View
     * 2. Top/Bottom View
     *
     * @param result Result list
     * @param root Root node
     * @param level Level of the node
     */
    public static void helper(List<Integer> result, TreeNode root, int level){
        if(root == null) return;

        if(level == result.size()){
            result.add(root.val);
        }

        helper(result, root.right, level + 1);
        helper(result, root.left, level + 1);
    }

    public static List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root, 0);
        return result;
    }

    public static List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                assert current != null;
                if (i == 0) result.add(current.val);
                if (current.right != null) queue.offer(current.right);
                if (current.left != null) queue.offer(current.left);
            }
        }

        return result;
    }


    public static void main(String[] args){
        // root node
        TreeNode root = new TreeNode(1);

        // left subtree
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        // right subtree
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideViewDFS(root));
        System.out.println(rightSideViewBFS(root));

    }

}
