package dataStructure.trees;

class BST {

    private TreeNode root;

    //----------------------- Insertion --------------------------//
    private TreeNode insertHelper(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key < root.val) {
            root.left = insertHelper(root.left, key);
        } else if (key > root.val) {
            root.right = insertHelper(root.right, key);
        }
        return root;
    }

    // Inserts and return the root
    public void insert(int key) {
        root = insertHelper(root, key);
    }

    //----------------------- Searching --------------------------//
    private boolean containsHelper(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.val) {
            return true;
        }
        return key < root.val ? containsHelper(root.left, key) : containsHelper(root.right, key);
    }

    // Check if the key is in the tree
    public boolean contains(int key) {
        return containsHelper(root, key);
    }

    //----------------------- Deletion --------------------------//
    private TreeNode deleteHelper(TreeNode root, int key) {
        // Base Case: If the tree is empty
        if (root == null) return null;

        // Otherwise, recur down the tree
        if (key < root.val)
            root.left = deleteHelper(root.left, key);
        else if (key > root.val)
            root.right = deleteHelper(root.right, key);
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: get the inorder successor (smallest in the right subtree)
            root.val = minValue(root.right);
            // delete the inorder successor
            root.right = deleteHelper(root.right, root.val);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int min = root.val;
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

    // Deletes the key from the tree
    public void delete(int key) {
        root = deleteHelper(root, key);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] values = {-10, -3, 0, 5, 9};
        for (int value : values) {
            bst.insert(value);
        }

        bst.delete(3);

        // Check if values exist
        System.out.println("Contains 3: " + bst.contains(3)); // Should print: false
    }

}