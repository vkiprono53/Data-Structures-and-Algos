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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
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

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> myQueue = new ArrayDeque<>();
        myQueue.addLast(root);

        while(!myQueue.isEmpty()){
            int size = myQueue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = myQueue.removeFirst();
                if(temp.left != null) myQueue.addLast(temp.left);
                if(temp.right != null) myQueue.addLast(temp.right);

                if(i == size - 1) result.add(temp.val);
            }
        }
        return result;
    }
}
