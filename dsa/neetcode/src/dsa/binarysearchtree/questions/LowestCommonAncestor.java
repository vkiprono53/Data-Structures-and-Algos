package dsa.binarysearchtree.questions;

/**
 * @author vkiprono
 * @created 12/8/23
 */

import dsa.binarytree.TreeNode;

/**
 * LEETCODE 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {
    TreeNode root;

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);

        TreeNode p = new TreeNode(10);
        TreeNode q = new TreeNode(14);

        System.out.println(tree.lowestCommonAncestor(tree.root, p, q).val);
    }

    /**
     *
     * Space complexity - O(n)
     * Time Complexity - O(n)
     *
     * ---Balanced
     * Space complexity - O(log n)
     * Time Complexity - O(log n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else{
            return root;
        }
    }
}
