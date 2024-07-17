package dataStructure.trees;

public class binarySearchTree {

    public static TreeNode root;

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            TreeNode treeNode = new TreeNode(val);
            return treeNode;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val > root.val) {
            root.right = delete(root.right, val);
        } else if (val < root.val) {
            root.left = delete(root.left, val);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode successorNode = findSuccessor(root.right);
            root.val = successorNode.val;
            root.right = delete(root.right, root.val);
        }

        return root;
    }


    public static TreeNode findSuccessor(TreeNode root) {
        TreeNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }


    public static void main(String[] args) {
        TreeNode root = insert(null, 8);
        insert(root, 8);
        insert(root, 32);
        insert(root, 15);
        insert(root, 17);

    }

}


