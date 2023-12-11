package dsa.binarysearchtree.questions;

/**
 * @author vkiprono
 * @created 12/11/23
 */

import dsa.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LEETCODE 230. Kth Smallest Element in a BST
 * <p>
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestElement {
    int counter = 0;
    TreeNode root;

    List<Integer> myList = new ArrayList<>();

    public static void main(String[] args) {
        KthSmallestElement smallestElement = new KthSmallestElement();

        smallestElement.root = new TreeNode(100);
        smallestElement.root.left = new TreeNode(90);
        smallestElement.root.right = new TreeNode(110);
        smallestElement.root.left.left = new TreeNode(80);
        smallestElement.root.left.right = new TreeNode(95);

        System.out.println(smallestElement.kthSmallestList(smallestElement.root, 3));
    }


    /**
     *
     * Time complexity - O(n)
     * Space Complexity - O(n) 
     */

    public int kthSmallest(TreeNode root, int k){
      return inOrder(root, k).val;
    }
    private TreeNode inOrder(TreeNode root, int k){
        if (root == null){
            return null;
        }
        TreeNode left = inOrder(root.left,k);
        if (left != null){
            return left;
        }
        counter++;
        if (counter == k){
            return root;
        }
        return inOrder(root.right, k);
    }


    /**
     *
     * Time complexity - O(n)
     * Space Complexity - O(h) - h - height of a binary tree
     */
      public int kthSmallestList(TreeNode root, int k) {
        List<Integer>myList1 = myList(root);
        if (myList1.size() > 1){
            return myList1.get(k-1);
        }
        else{
            return 1;
        }
    }

    private List<Integer> myList(TreeNode root) {

        if (root == null) {
            return myList;
        }
        myList(root.left);
        myList.add(root.val);
        myList(root.right);
        return myList;
    }
}
