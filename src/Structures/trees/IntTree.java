package Structures.trees;

import Structures.nodes.Node;

public class IntTree {
    private Node<Integer> root;
    private int size = 0;

    public IntTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node<Integer> insertRecursive(Node<Integer> current, int value) {
        if (current == null) {
            return new Node<Integer>(value);
        }
        if (value < current.getValue()) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    public void preOrder() {
        size=0;
        preOrderRecursive(root);
    }

    public void preOrderRecursive(Node<Integer> node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            size++;
            preOrderRecursive(node.getLeft());
            preOrderRecursive(node.getRight());
        }
    }

    public void posOrder() {
        size = 0;
        posOrderRecursive(root);
    }

    public void posOrderRecursive(Node<Integer> node) {
        if (node != null) {
            posOrderRecursive(node.getLeft());
            posOrderRecursive(node.getRight());
            System.out.print(node.getValue() + " ");
            size++;
        }
    }

    public void inOrder() {
        size = 0;
        inOrderRecursive(root);
    }

    public void inOrderRecursive(Node<Integer> node) {
        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.print(node.getValue() + " ");
            size++;
            inOrderRecursive(node.getRight());
        }
    }

    public int size() {
        return size;
    }
}
