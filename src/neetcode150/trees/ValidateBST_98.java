package neetcode150.trees;

public class ValidateBST_98 {
    // used to store the previous node in the in-order traversal
    TreeNode pre = null;

    /**
     * In order traversal of BST is always sorted
     *
     * From the last element check the sorted order increasing order
     *
     * @param root TreeNode
     * @return  boolean
     */
    public boolean inorder(TreeNode root) {
        if (root == null) return true;

        if (!inorder(root.left)) return false;

        if (pre != null && pre.val >= root.val) return false;
        pre = root;

        return inorder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    public static void main(String[] args) {
        ValidateBST_98 validateBST98 = new ValidateBST_98();

        TreeNode node10 = new TreeNode(10);
        TreeNode node20 = new TreeNode(20);
        TreeNode root1 = new TreeNode(15, node10, node20);
        System.out.println(validateBST98.isValidBST(root1));

        System.out.println("====================================");

        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4, node3, node6);
        TreeNode node1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(5, node1, node4);
        System.out.println(validateBST98.isValidBST(root2));
    }


}
