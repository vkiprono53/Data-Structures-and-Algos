package dsa.binarytree.questions;

/**
 * @author vkiprono
 * @created 2/8/24
 */

import dsa.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LEETCODE 199. Binary Tree Right Side View
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 */
public class RightSideBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        System.out.println(rightSideView(root));
        Math.abs(0 - 1);

    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> myQueue = new ArrayDeque<>();
        myQueue.addLast(root);

        while (!myQueue.isEmpty()) {
            int size = myQueue.size();
            TreeNode top = myQueue.peekFirst();
            result.add(top.val);
            for (int i = 0; i < size; i++) {
                TreeNode temp = myQueue.removeFirst();
                if (temp.right != null) {
                    myQueue.addLast(temp.right);
                }
                if (temp.left != null) {
                    myQueue.addLast(temp.left);
                }
            }

        }
        return result;

    }
}
