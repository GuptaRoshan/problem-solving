package neetcode150.trees;

public class LowestCommonAncestorBST_235 {

    /**
     * Finds the lowest common ancestor (LCA) of two nodes in a Binary Search Tree (BST).
     * The method starts at the root and traverses the tree until it finds the LCA.
     *
     * @param root The root node of the BST.
     * @param p    The first node for which to find the LCA.
     * @param q    The second node for which to find the LCA.
     * @return The LCA of nodes p and q.
     * <p>
     * Steps:
     * 1. Compute the larger value (large) and smaller value (small) between p.val and q.val.
     * 2. Start with the root. Keep iterating the BST:
     * a. If root.val > large, then both p and q are in the left subtree. Go left by setting root = root.left.
     * b. If root.val < small, then both p and q are in the right subtree. Go right by setting root = root.right.
     * c. If small <= root.val <= large, then root is the LCA between p and q.
     * <p>
     * Link : <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solutions/1347857/c-java-python-iterate-in-bst-picture-explain-time-o-h-space-o-1/">...</a>
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);
        while (root != null) {
            if (root.val > large) // p, q belong to the left subtree
                root = root.left;
            else if (root.val < small) // p, q belong to the right subtree
                root = root.right;
            else // Now, small <= root.val <= large -> This root is the LCA between p and q
                return root;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        //Given array: [6,2,8,0,4,7,9,null,null,3,5]
        TreeNode root = new TreeNode(6);

        root.left = p;

        root.right = q;

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // LCA of 2 and 8 is 6
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

}
