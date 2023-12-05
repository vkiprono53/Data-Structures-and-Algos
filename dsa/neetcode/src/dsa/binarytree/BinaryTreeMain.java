package dsa.binarytree;

/**
 * @author vkiprono
 * @created 12/1/23
 */

public class BinaryTreeMain {
    static BTNode root;

    public BinaryTreeMain() {
        root = null;
    }

    public static void main(String[] args) {

        BinaryTreeMain binaryTreeMain = new BinaryTreeMain();
        System.out.println("Empty? " + binaryTreeMain.isEmpty());
        System.out.println(":::::INSERTION:::::");
        root = binaryTreeMain.insert(root, 5);

        binaryTreeMain.insert(root, 4);
        binaryTreeMain.insert(root, 8);
        binaryTreeMain.insert(root, 10);
        System.out.println("----TRAVERSAL----");
        binaryTreeMain.inOrderTraversal(root);
        System.out.println("----COUNT NODES---");
        System.out.println(binaryTreeMain.countNodes(root));
        System.out.println("------SEARCHING 9-------");
        System.out.println(binaryTreeMain.search(root, 1));

    }

    //Check if BT is Empty
    public boolean isEmpty() {
        return root == null;
    }

    private BTNode insert(BTNode root, int data) {
        BTNode newNode = new BTNode(data);
        if (root == null) {
            root = newNode;
        } else {
            if (root.left != null) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
        }
        return root;
    }

    //CountNodes;
    public int countNodes(BTNode root) {
        if (root == null) {
            return 0;
        } else {
            int count = 1;
            count += countNodes(root.left);
            count += countNodes(root.right);
            return count;
        }
    }

    //Search Binary tree:
    public boolean search(BTNode root, int val) {
        if (root.data == val) {
            return true;
        }
        if (root.left != null) {
            if (search(root.left, val)) {
                return true;
            }
        }
        if (root.right != null) {
            if (search(root.right, val)) {
                return true;
            }

        }
        return false;
    }

    //Inorder Traversal
    public void inOrderTraversal(BTNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + "->");
            inOrderTraversal(root.right);
        }
    }

    //Preorder
    public void preOrder(BTNode root) {
        if (root != null) {
            System.out.print(root.data + "->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //PostOrder
    public void postOrder(BTNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "->");
        }
    }

}
