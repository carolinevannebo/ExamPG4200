package question3;

import nodes.TreeNode;

// 3.2
public class BinarySearchTree {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(90);
        tree.root.left = new TreeNode<>(60);
        tree.root.right = new TreeNode<>(95);
        tree.root.left.left = new TreeNode<>(25);
        tree.root.left.right = new TreeNode<>(75);
        tree.root.left.left.left = new TreeNode<>(15);
        tree.root.left.left.right = new TreeNode<>(30);
        tree.root.left.right.left = new TreeNode<>(65);
        tree.root.left.right.right = new TreeNode<>(85);

        System.out.println("Preorder traversal:");
        tree.preorderTraversal(); // Expected output: 90 60 25 15 30 75 65 85 95

        System.out.println("\nInorder traversal:");
        tree.inorderTraversal();   // Expected Output: 15 25 30 60 65 75 85 90 95

        tree.delete(60);
        System.out.println("\nInorder traversal after deleting 60:");
        tree.inorderTraversal(); // Expected output: 15 25 30 65 75 85 90 95
    }
}
