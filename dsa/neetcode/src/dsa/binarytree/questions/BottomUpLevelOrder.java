package dsa.binarytree.questions;

import java.util.*;
/**
 * @author vkiprono
 * @created 2/7/24
 */

import dsa.binarytree.TreeNode;

/**
 * LEETCODE 107 · Binary Tree Level Order Traversal II:
 * <p>
 * *******************************************************************************
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7]
 * [9,20],
 * [3],
 * ]
 * *******************************************************************************
 */
public class BottomUpLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        System.out.println(levelOrderBottom(root));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> myQueue = new ArrayDeque<>();

        myQueue.addLast(root);

        while (!myQueue.isEmpty()) {
            int size = myQueue.size();
            List<Integer> myList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = myQueue.removeFirst();
                if (temp.left != null) {
                    myQueue.addLast(temp.left);
                }
                if (temp.right != null) {
                    myQueue.addLast(temp.right);
                }
                myList.add(temp.val);
            }
            result.add(0, myList);
        }

        return result;
    }
}
