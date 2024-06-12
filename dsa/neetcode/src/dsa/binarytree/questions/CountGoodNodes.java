package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

/**
 * LeetCode 1448. Count Good Nodes in Binary Tree
 * <p>
 * Given a binary tree root, a node X in the tree is named good if in the path
 * from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 * <p>
 * <p>
 * Example 1:
 */
public class CountGoodNodes {
    int goodCount = 0;

    /**
     * Time Complexity - O(n)
     * Space Complexity Av - O(log n) --O(n) for skewed trees
     */
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return goodCount;
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) return;
        if (node.val >= max) {
            max = node.val;
            goodCount++;
        }
        dfs(node.left, max);
        dfs(node.right, max);
    }
}
