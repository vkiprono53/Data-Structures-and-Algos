package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

/**
 * @author vkiprono
 * @created 2/6/24
 */

/**
 * Given a binary tree and a node, find the level order successor of the given node in the tree.
 * The level order successor is the node that appears right after the given node in the level order traversal.
 */
public class LevelOrderSuccessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrderSuccessor(root, 1));

    }

    public static int levelOrderSuccessor(TreeNode root, int nodeValue) {
        int successor = -1;
        if (root == null) {
            return successor;
        }
        Deque<TreeNode> myQueue = new ArrayDeque<>();
        myQueue.addLast(root);

        while (!myQueue.isEmpty()) {

            TreeNode temp = myQueue.removeFirst();

            if (temp.left != null) {
                myQueue.addLast(temp.left);
            }

            if (temp.right != null) {
                myQueue.addLast(temp.right);
            }
            if (temp.val == nodeValue && !myQueue.isEmpty()) {
                successor = myQueue.removeFirst().val;
                break;
            }

        }

        return successor;
    }
}
