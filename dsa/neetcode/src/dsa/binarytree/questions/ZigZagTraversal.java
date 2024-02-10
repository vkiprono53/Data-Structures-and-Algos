package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 */
public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        System.out.println(zigzag(root));
        System.out.println(zigzagLevelOrder(root));
    }

    //Using 2 stacks
    public static List<List<Integer>> zigzag(TreeNode root) {
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        int level = 0;
        if (root == null) {
            return null;
        }

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack2.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = stack2.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = stack2.pop();
                    // System.out.print(temp.val + " ");
                    list.add(temp.val);
                    if (temp.right != null) {
                        stack1.push(temp.right);
                    }
                    if (temp.left != null) {
                        stack1.push(temp.left);
                    }
                }
                result.add(list);

            }

            while (!stack1.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = stack1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = stack1.pop();
                    // System.out.print(temp.val + " ");
                    list.add(temp.val);
                    if (temp.left != null) {
                        stack2.push(temp.left);
                    }
                    if (temp.right != null) {
                        stack2.push(temp.right);
                    }
                }
                result.add(list);

            }

        }
        return result;
    }

    //Using DEQUE
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> myQueue = new ArrayDeque<>();
        int height = 0;
        myQueue.addLast(root);

        while (!myQueue.isEmpty()) {
            List<Integer> myList = new ArrayList<>();
            int size = myQueue.size();
            if (height % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode temp = myQueue.removeFirst();
                    myList.add(temp.val);
                    if (temp.left != null) {
                        myQueue.addLast(temp.left);
                    }
                    if (temp.right != null) {
                        myQueue.addLast(temp.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode temp = myQueue.removeLast();
                    if (temp.right != null) {
                        myQueue.addFirst(temp.right);
                    }
                    if (temp.left != null) {
                        myQueue.addFirst(temp.left);
                    }
                    myList.add(temp.val);
                }
            }
            result.add(myList);
            height++;
        }
        return result;
    }
}
