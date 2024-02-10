package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
/**
 * @author vkiprono
 * @created 2/5/24
 */

/**
 * Given a Binary tree, find the summation of each level
 */
public class LevelOrderSummation {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(levelSum(root));
    }

    public static List<Integer> levelSum(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> myQueue = new ArrayDeque<>();

        myQueue.addLast(root);

        while (!myQueue.isEmpty()) {
            int size = myQueue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode temp = myQueue.removeFirst();
                sum += temp.val;

                if (temp.left != null) {
                    myQueue.add(temp.left);
                }
                if (temp.right != null) {
                    myQueue.add(temp.right);
                }
            }
            result.add(sum);
        }

        return result;
    }
}
