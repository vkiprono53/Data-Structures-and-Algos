package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author vkiprono
 * @created 2/5/24
 * <p>
 * LEETCODE 637 : Averages of Levels in Binary Tree
 * Given the root of a binary tree, return the average value of the nodes on each level in the
 * form of an array. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 */

public class AveragesOfLevels {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("LEVEL ORDER IS:::::");
        LevelOrder.levelOrder(root);
        System.out.println();
        System.out.println("================");
        System.out.println(averageOfLevels(root));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> myQueue = new ArrayDeque<>();

        myQueue.addLast(root);

        while (!myQueue.isEmpty()) {
            int size = myQueue.size();
            Double average = 0.00;
            Double sum = 0.00;

            for (int i = 0; i < size; i++) {
                TreeNode temp = myQueue.removeFirst();
                if (temp.left != null) {
                    myQueue.addLast(temp.left);
                }
                if (temp.right != null) {
                    myQueue.addLast(temp.right);
                }
                sum += temp.val;
            }
            average += sum / size;
            result.add(average);
        }
        return result;
    }
}
