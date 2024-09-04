package neetcode150.trees;

public class SameTree_100 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // Base Case check if both nodes are null
        if (p == null && q == null) {
            return true;
        }

        /*
         * There are 3 cases to consider:
         *
         * 1. If p is null and  q not null
         * 2. If q is null and p not null
         * 3. If both p and q are not null
         */
        if (p == null || q == null) {
            return false;
        }

        /*
         * It will come here only if both p and q are not null
         * Check if the values of the nodes are same
         */
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {
        // Creating the first tree from the array [1, 2, 3]
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        // Creating the second tree from the array [1, 2, 3]
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println(isSameTree(p, q));
    }
}
