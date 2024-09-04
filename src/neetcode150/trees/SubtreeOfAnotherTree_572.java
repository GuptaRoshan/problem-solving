package neetcode150.trees;

public class SubtreeOfAnotherTree_572 {

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // Check if the two trees are same
    // Similar to the same tree Leetcode problem 100
    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    /**
     * Done using preorder sequence of tree
     *
     * @param s root of the tree
     * @param t root of the subtree
     * @return true if t is a subtree of s
     */
    public static boolean isSubtreePreorderSequence(TreeNode s, TreeNode t) {
        String seqS = preorder(s);
        String seqT = preorder(t);
        System.out.println(seqS); // #3#4#1nullnull#2nullnull#5nullnull
        System.out.println(seqT); // #4#1nullnull#2nullnull
        return seqS.contains(seqT);
    }

    private static String preorder(TreeNode t) {
        if (t == null) {
            return "null";
        }
        return "#" + t.val + preorder(t.left) + preorder(t.right); // inefficient
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        //root.left.right.right = new TreeNode(0);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(isSubtree(root, subRoot));
        System.out.println(isSubtreePreorderSequence(root, subRoot));
    }
}
