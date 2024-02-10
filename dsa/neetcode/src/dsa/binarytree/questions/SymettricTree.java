package dsa.binarytree.questions;

/**
 * @author vkiprono
 * @created 2/9/24
 */

import dsa.binarytree.TreeNode;

/**
 * LEETCODE 101. Symmetric Tree
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 */
public class SymettricTree {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        return isSymmetrical(root.left, root.right);
    }
    public boolean isSymmetrical(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}
