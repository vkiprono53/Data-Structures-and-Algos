package dsa.binarytree.questions;

import java.util.Deque;
import java.util.ArrayDeque;
/**
 * @author vkiprono
 * @created 12/4/23
 */

import dsa.binarytree.TreeNode;

/**
 * LEETCODE 104. Maximum Depth of Binary Tree
 * <p>
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 */
public class MaxDepthBinaryTree {
    TreeNode root;

    public static void main(String[] args) {

        MaxDepthBinaryTree tree = new MaxDepthBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        //  System.out.println(tree.maxDepth(tree.root));
        System.out.println(tree.maxDepth1(tree.root));
    }

    /**
     * DFS
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int countLeft = maxDepth(root.left);
        int countRight = maxDepth(root.right);

        return 1 + Math.max(countLeft, countRight);
    }

    /**
     * Time Complexity: O(N)
     * <p>
     * Space Complexity: O(N)
     */
    public int maxDepth1(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int level = 0;
        if (root == null) {
            return 0;
        }
        queue.addLast(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size > 0) {

                TreeNode toDelete = queue.removeFirst();
                if (toDelete.left != null) {
                    queue.addLast(toDelete.left);
                }
                if (toDelete.right != null) {
                    queue.addLast(toDelete.right);
                }

                size--;

            }

            level++;

        }

        return level;
    }


}
