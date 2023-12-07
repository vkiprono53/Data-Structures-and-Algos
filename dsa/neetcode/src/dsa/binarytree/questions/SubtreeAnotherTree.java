package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

/**
 * @author vkiprono
 * @created 12/6/23
 */

/**
 * LEETCODE 572. Subtree of Another Tree
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of
 * root with the same structure
 * and node values of subRoot and false otherwise.
 * <p>
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's
 * descendants. The tree tree could also be considered as a subtree of itself.
 */
public class SubtreeAnotherTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(10);

        TreeNode subRoot = new TreeNode(2);
        subRoot.left = new TreeNode(11);
        subRoot.right = new TreeNode(10);

        SubtreeAnotherTree tree = new SubtreeAnotherTree();
        System.out.println(tree.isSubtree(root, subRoot));

    }


    // Time Complexity: O(n)
     // Space Complexity: O(n)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
    }
}
