package dsa.binarytree;

/**
 * @author vkiprono
 * @created 12/1/23
 */

public class BTNode {
    BTNode right;
    BTNode left;
    int data;


    public BTNode(int data) {
        this.data = data;
    }

    public BTNode() {
        this.right = null;
        this.left = null;
        this.data = 0;
    }

    public BTNode(BTNode right, BTNode left, int data) {
        this.right = right;
        this.left = left;
        this.data = data;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
