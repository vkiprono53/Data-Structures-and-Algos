package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

/**
 * @author vkiprono
 * @created 12/1/23
 */

public class InvertBinaryTree {
    static TreeNode root;

    public InvertBinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        InvertBinaryTree binaryTree = new InvertBinaryTree();
        root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        binaryTree.invertTree(root);

    }

    /**
     *
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     *
     */
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

}

