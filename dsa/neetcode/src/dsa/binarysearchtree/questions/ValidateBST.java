package dsa.binarysearchtree.questions;

import java.util.List;
import java.util.ArrayList;
/**
 * @author vkiprono
 * @created 12/7/23
 */

import dsa.binarytree.TreeNode;

/**
 * LEETCODE 98. Validate Binary Search Tree
 * <p>
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left
 * subtree
 * of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {
    List<Integer> myList = new ArrayList<>();

    TreeNode root;
    public static void main(String[] args) {
        ValidateBST validateBST = new ValidateBST();

        validateBST.root= new TreeNode(100);
        validateBST.root.left= new TreeNode(90);
        validateBST.root.right= new TreeNode(110);
        validateBST.root.left.left= new TreeNode(80);
        validateBST.root.left.right= new TreeNode(95);

        System.out.println(validateBST.isValidBST(validateBST.root));
        System.out.println(validateBST.isValidBST1(validateBST.root));

    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * Using List
     */
    public boolean isValidBST(TreeNode root) {
        myList = inOrderTraversal(root);

        for (int i = 0; i < myList.size() - 1; i++) {
            if (myList.get(i) >= myList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> inOrderTraversal(TreeNode root) {

        if (root == null) {
            return null;
        }
        inOrderTraversal(root.left);
        myList.add(root.val);
        inOrderTraversal(root.right);
        return myList;
    }

    /**
     * Recursion - No List
     * Space - O(n)
     * Time - O(n)
     */

    public boolean isValidBST1(TreeNode root){
        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, Integer max, Integer min){

        if (root == null){
            return true;
        }
        else if(max != null && root.val >= max || min != null && root.val <= min ){
            return false;
        }
        else {
            return validate(root.left, root.val, min) && validate(root.right, max, root.val);
        }
    }

}
