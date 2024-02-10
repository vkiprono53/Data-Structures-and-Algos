package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

import java.util.List;
import java.util.ArrayList;

/**
 * @author vkiprono
 * @created 1/28/24
 */

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
        System.out.println(boundaryTraversal.printBoundary(root));
    }

    //Print
    public List<Integer> printBoundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (!isLeaf(root)){
            result.add(root.val);
        }
        addLeftBoundary(root, result);
        addLeaves(root, result);
        addRightBoundary(root, result);

        return result;
    }

    //Check isLeaf
    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }

    //Add left Boundary:
    public void addLeftBoundary(TreeNode root, List<Integer> result) {
        TreeNode temp = root.left;

        while (temp != null) {
            if (!isLeaf(temp)) {
                result.add(temp.val);
            }
            if (temp.left != null) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
    }

    //Add Leaves
    public void addLeaves(TreeNode root, List<Integer> result) {
        if (isLeaf(root)) {
            result.add(root.val);
            return;
        }
        if (root.left != null) {
            addLeaves(root.left, result);
        }
        if (root.right != null) {
            addLeaves(root.right, result);
        }
    }

    //Add right Boundary:
    public void addRightBoundary(TreeNode root, List<Integer> result) {
        List<Integer> temp = new ArrayList<>();

        TreeNode current = root.right;

        while (current != null) {
            if (!isLeaf(current)) {
                temp.add(current.val);
            }
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }
}
