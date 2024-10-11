package practice.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTarget {

    //
    // Can be solved using binary search on BST
    // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/solutions/106059/java-c-three-simple-methods-choose-one-you-like/

    public static boolean helper(TreeNode root, int k, List<Integer> remaining) {
        if (root == null) return false;

        if(remaining.contains(root.val)) return true;

        remaining.add(k - root.val);

        return helper(root.left, k ,remaining) || helper(root.right, k, remaining);
    }

    public static boolean findTarget(TreeNode root, int k) {
        return helper(root, k, new ArrayList<>());
    }

    public static void main(String[] args) {
        int k = 9;
        // Creating nodes manually
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println(findTarget(root, k));
    }


}
