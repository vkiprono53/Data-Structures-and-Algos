package dsa.binarytree.questions;

import dsa.binarytree.TreeNode;

import java.util.Deque;
import java.util.ArrayDeque;

public class LowestCommonAncestor {
    TreeNode root;

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);

        TreeNode p = new TreeNode(8);
        TreeNode q = new TreeNode(12);

        System.out.println(tree.lowestCommonAncestor2(tree.root, p, q).val);
    }

    /**
     * Space complexity - O(n)
     * Time Complexity - O(n)
     * <p>
     * ---Balanced
     * Space complexity - O(log n)
     * Time Complexity - O(log n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pStack = new ArrayDeque<>();
        Deque<TreeNode> qStack = new ArrayDeque<>();

        pathToNode(root, p, pStack);
        pathToNode(root, q, qStack);

        while (!qStack.isEmpty()){
            TreeNode check = qStack.pop();
            if (pStack.contains(check)){
                return check;
            }
        }
        return null;
    }
    private void pathToNode(TreeNode root, TreeNode node, Deque<TreeNode> myStack) {
        if (root.val < node.val) {
            myStack.push(root);
            pathToNode(root.right, node, myStack);
        } else if (root.val > node.val) {
            myStack.push(root);
            pathToNode(root.left, node, myStack);
        } else {
            myStack.push(root);
        }
    }


}
