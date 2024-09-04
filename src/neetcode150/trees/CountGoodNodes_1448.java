package neetcode150.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountGoodNodes_1448 {

    int good = 0;

    public void DFS(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) good++;
        max = Math.max(max, root.val);
        DFS(root.left, max);
        DFS(root.right, max);
    }

    public int BFS(TreeNode root) {
        record Pair (TreeNode node, Integer max) {}
        int ans = 0;

        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, Integer.MIN_VALUE));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int maxVal = pair.max;

            if (node.val >= maxVal) ans++;

            if (node.left != null) {
                queue.add(new Pair(node.left, Math.max(maxVal, node.val)));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, Math.max(maxVal, node.val)));
            }
        }

        return ans;
    }



    public int goodNodes(TreeNode root) {
        //good = 0;
        //DFS(root, Integer.MIN_VALUE);
        return BFS(root);
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3b = new TreeNode(3, node4, node2);

        TreeNode root = new TreeNode(3, node3b, null);

        System.out.println(new CountGoodNodes_1448().goodNodes(root));
        System.out.println(new CountGoodNodes_1448().BFS(root));
    }
}
