package dsa.binarysearchtree.questions;

/**
 * @author vkiprono
 * @created 12/8/23
 */

import dsa.binarysearchtree.BSTNode;
import dsa.binarytree.TreeNode;

/**
 * LEETCODE 701. Insert into a Binary Search Tree
 * <p>
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 * <p>
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 */
public class InsertBST {
    public static void main(String[] args) {

    }

    /**
     *Iteration:
     * Time Complexity = O(log n)
     * Space Complexity - O(1)
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
            return root;
        }
        TreeNode temp = root;
        TreeNode parent = root;

        while (temp != null) {
            parent = temp;

            if (temp.val > val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (parent.val > val) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return root;
    }

    /**
     * Insert into BST - Recursion
     * Time Complexity -  O(log n)
     */
    public TreeNode insertIntoBSTIterate(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        } else if (val >= root.val) {
            root.right = insertIntoBSTIterate(root.right, val);
        } else {
            root.left = insertIntoBSTIterate(root.left, val);
        }
        return root;
    }
}
