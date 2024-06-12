package dsa.binarytree.questions;

/**
 * @author vkiprono
 * @created 12/6/23
 */

import dsa.binarytree.TreeNode;

import java.util.*;

/**
 * LEETCODE 102. Binary Tree Level Order Traversal
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 */
public class BTreeLevelOrdTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> myQueue = new ArrayDeque<>();
        myQueue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while (!myQueue.isEmpty()) {
            int size = myQueue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode head = myQueue.remove();

                list.add(head.val);
                if (head.left != null) {
                    myQueue.add(head.left);
                }
                if (head.right != null) {
                    myQueue.add(head.right);
                }
                size--;
            }

            result.add(list);
        }
        return result;
    }

    /**
     * Time Complexity - O(l) - l is the largest level
     * Space Complexity - O(n) 
     */

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> myQueue = new ArrayDeque<>();
        myQueue.addLast(root);

        while(!myQueue.isEmpty()){
            int size = myQueue.size();
            List<Integer>myList = new ArrayList<>();

            for(int i = 0 ; i < size; i++){
                TreeNode temp = myQueue.removeFirst();
                if(temp.left != null) myQueue.addLast(temp.left);
                if(temp.right != null) myQueue.addLast(temp.right);
                myList.add(temp.val);
            }
            result.add(myList);

        }
        return result;
    }
}
