package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author vkiprono
 * @created 1/22/24
 */


public class PreOrderTraversalOld {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("---------USING STACK-------");
        preOrderStack(root);
        System.out.println();
        System.out.println("----------------------------");
        preOrderTraversal(root);
    }

    //Using Recursion
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val+ " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //Using Stack
    public static void preOrderStack(TreeNode root){
        Deque<TreeNode> myStack = new ArrayDeque<>();
        if (root != null){
            myStack.push(root);
        }

        while(!myStack.isEmpty()){
            TreeNode temp = myStack.pop();

            if (temp.right != null){
                myStack.push(temp.right);
            }

            if (temp.left != null){
                myStack.push(temp.left);
            }
            System.out.print(temp.val + "->");
        }
    }
}