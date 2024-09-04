package neetcode150.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal_102 {

    public static List<List<Integer>> levelOrderBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if (root == null) return wrapList;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                subList.add(node.val);
            }
            wrapList.add(subList);
        }

        return wrapList;
    }


    /**
     * This is pre-order traversal of the tree with level as the parameter to keep track of the level of the node
     *
     * @param res    result list
     * @param root   root node
     * @param height height of the node
     */
    public static void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }

    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(levelOrderBFS(root));
        System.out.println(levelOrderDFS(root));
    }

}
