package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Leetcode 94. Binary Tree Inorder Traversal
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 */
public class InOrderTraversal {
    public static void main(String[] args) {
        InOrderTraversal traversal = new InOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(traversal.inorderTraversal(root));
    }

    /**
     *Time Complexity - O(n)
     * Space Complexity - O(n)--inbuilt stack
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        inOrder(root, result);
        return result;
    }
    private void inOrder(TreeNode root, List<Integer>result){
        if(root == null) return;
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }

    /**
     *
     * Using Stack - extra space
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> myStack = new ArrayDeque<>();

        while (root != null || !myStack.isEmpty()){
            while (root != null){
                myStack.push(root);
                root = root.left;
            }
            root = myStack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
