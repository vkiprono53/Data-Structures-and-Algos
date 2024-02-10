package dsa.binarytree.questions;

/**
 * @author vkiprono
 * @created 2/7/24
 */

import dsa.binarytree.TreeNode;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * LLETCODE 116. Populating Next Right Pointers in Each Node
 * <p>
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 */
public class PopulateNextRightPointers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        System.out.println(connect(root));
    }

    public static TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> myQueue = new ArrayDeque<>();
        myQueue.addLast(root);

        while (!myQueue.isEmpty()) {
            int size = myQueue.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = myQueue.removeFirst();
                if (temp.left != null) {
                    myQueue.addLast(temp.left);
                }
                if (temp.right != null) {
                    myQueue.addLast(temp.right);
                }
                if (i < size - 1) {
                    temp.next = myQueue.peekFirst();
                }
            }
        }
        return root;
    }
}
