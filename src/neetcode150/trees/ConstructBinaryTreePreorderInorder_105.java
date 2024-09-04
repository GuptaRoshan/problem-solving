package neetcode150.trees;

public class ConstructBinaryTreePreorderInorder_105 {

    /**
     * @param preorderStartIndex start index of a preorder array
     * @param inorderStartIndex  start index of an inorder array
     * @param inorderEndIndex    end index of an inorder array
     * @param preorder           preorder array
     * @param inorder            inorder array
     * @return root of a binary tree
     */
    public TreeNode helper(int preorderStartIndex, int inorderStartIndex, int inorderEndIndex, int[] preorder, int[] inorder) {

        // base case when there is no element in the preorder or inorder array
        if (preorderStartIndex > preorder.length - 1 || inorderStartIndex > inorderEndIndex) {
            return null;
        }

        // root of a binary tree, because the first element is always a root in a preorder array
        TreeNode root = new TreeNode(preorder[preorderStartIndex]);

        int currentRootIndexInInorder = 0; // Index of current root in inorder
        for (int i = inorderStartIndex; i <= inorderEndIndex; i++) {
            if (inorder[i] == root.val) {
                currentRootIndexInInorder = i;
            }
        }

        root.left = helper(preorderStartIndex + 1, inorderStartIndex, currentRootIndexInInorder - 1, preorder, inorder);
        // preorderStartIndex + (currentRootIndexInInorder - inorderStartIndex) + 1 calculates root of the right subtree
        root.right = helper(preorderStartIndex + (currentRootIndexInInorder - inorderStartIndex) + 1, currentRootIndexInInorder + 1, inorderEndIndex, preorder, inorder);

        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

}
