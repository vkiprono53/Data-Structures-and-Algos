package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreOrderTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        System.out.println("----------USING STACK---------");
        preOrderIterative(root);
        System.out.println();
        System.out.println("----------USING RECURSION---------");
        System.out.println();
        preOrderRecursion(root);
    }

    //Iterative Approach - Using Stack
    public static void preOrderIterative(TreeNode root) {
        Deque<TreeNode> myStack = new ArrayDeque<>();

        if (root == null) {
            return;
        }
        myStack.push(root);

        while (!myStack.isEmpty()) {
            TreeNode temp = myStack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null) {
                myStack.push(temp.right);
            }
            if (temp.left != null) {
                myStack.push(temp.left);
            }
        }

    }

    //Using Recursion:

    public static void preOrderRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

}
