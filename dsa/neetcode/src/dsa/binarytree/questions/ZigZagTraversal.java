package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        System.out.println(zigzag(root));
    }

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
}
