package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

public class BalanceBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);

        System.out.println(isBalancedTree(root));
    }

    /**
     * Time Complexity - O (n log n)
     * Space Complexity - O(h)
     */
    public static boolean isBalancedTree(TreeNode root){
        if (root == null){
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.abs(left - right) <= 1 && isBalancedTree(root.left) && isBalancedTree(root.right);
    }
    public static int height(TreeNode root){
        if (root == null){
            return 0;
        }
        //Commented this check
  /*      if (root.left == null && root.right == null){
            return 1;
        }*/
        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(h) - Height of the tree - O(n) - for a skewed tree
     *
     */
    public boolean isBalanced(TreeNode root){
        int depth = maxDepth(root);
        return depth != -1;
    }
    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1 ) return -1;
        return 1 + Math.max(left, right);
    }
}
