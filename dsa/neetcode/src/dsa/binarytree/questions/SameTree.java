package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author vkiprono
 * @created 12/5/23
 *
 * LEETCODE 100. Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 * 
 */

public class SameTree {
    public static void main(String[] args) {
        TreeNode first = new TreeNode(1);
        first.left = new TreeNode(2);
        first.right = new TreeNode(3);

        TreeNode second = new TreeNode(1);
        second.left = new TreeNode(2);
        second.right = new TreeNode(3);

        System.out.println(isSameTree(first, second));

    }

    /**
     *
     * Using Queue:
     * Space - O(n)
     * Time - O(n)
     */
    public static boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(p);
        queue2.offer(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode first = queue1.poll();
            TreeNode second = queue2.poll();

            if (first == null && second == null) {
                continue;
            }
            if (first == null || second == null || first.val != second.val) {
                return false;
            }
            queue1.offer(first.left);
            queue1.offer(first.right);
            queue2.offer(second.left);
            queue2.offer(second.right);
        }
        return queue1.isEmpty() && queue2.isEmpty();

    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
