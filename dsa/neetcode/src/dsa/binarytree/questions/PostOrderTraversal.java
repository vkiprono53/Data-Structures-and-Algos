package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;
/**
 * @author vkiprono
 * @created 1/25/24
 */

public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("---------USING STACK-------");
        postOrderRecursion(root);
        System.out.println();
        System.out.println("----------------------------");
        postOrderTraversal(root);
    }

    //Using Recursion

    public static void postOrderRecursion(TreeNode root){
        if (root == null){
            return;
        }
        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        System.out.print(root.val + " ");
    }

    //Using Stack:
    public static void postOrderTraversal(TreeNode root){
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        if (root == null){
            return;
        }
        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode temp = stack1.pop();
            stack2.push(temp);


            if (temp.left != null){
                stack1.push(temp.left);
            }
            if (temp.right != null){
                stack1.push(temp.right);
            }
        }

        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().val + " ");;
        }

    }
}
