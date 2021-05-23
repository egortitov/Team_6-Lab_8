package com.company.tree;

public class BST implements DataStructure {
    TreeNode root;

    @Override
    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    protected TreeNode insertRecursive(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRecursive(root.left, key);
        else if (key > root.key)
            root.right = insertRecursive(root.right, key);

        return root;
    }

    @Override
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    protected TreeNode deleteRecursive(TreeNode root, int key) {
            if (root == null) return root;

            if (key < root.key)
            root.left = deleteRecursive(root.left, key);
        else if (key > root.key)
            root.right = deleteRecursive(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.right = deleteRecursive(root.right, root.key);
        }
        return root;
    }

    @Override
    public boolean search(int key) {
        root = searchRecursive(root, key);
        return root != null;
    }

    protected TreeNode searchRecursive(TreeNode root, int key) {
        if (root == null || root.key == key)
            return root;
        if (root.key > key)
            return searchRecursive(root.left, key);
        return searchRecursive(root.right, key);
    }

    void updateHeight(TreeNode n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    int height(TreeNode n) {
        return n == null ? -1 : n.height;
    }

    int getBalance(TreeNode n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    TreeNode rotateRight(TreeNode y) {
        TreeNode x = y.left;
        TreeNode z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    TreeNode rotateLeft(TreeNode y) {
        TreeNode x = y.right;
        TreeNode z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    TreeNode rebalance(TreeNode z) {
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    public void balancing() {
        balancingRecursive(root);
    }

    void balancingRecursive(TreeNode root) {
        if (root != null) {
            balancingRecursive(rebalance(root.left));
            balancingRecursive(rebalance(root.right));
        }
    }


    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.key);
            traverseInOrder(node.right);
        }
    }

}

