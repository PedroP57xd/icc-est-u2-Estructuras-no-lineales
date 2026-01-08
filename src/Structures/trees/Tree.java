package Structures.trees;

import Structures.nodes.Node;
import models.Person;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void insert(T value) {

        root = insertRecursive(root, value);

    }

    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<T>(value);
        }
        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    public void inOrder() {
        inOrderRecursive(root);
    }

    public void inOrderRecursive(Node<T> node) {
        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.print(node.getValue() + "\n   ");
            inOrderRecursive(node.getRight());
        }

    }

    public T search(T value) {
        return searchRecursive(root, value);
    }

    private T searchRecursive(Node<T> current, T value) {
        if (current == null) {
            return null;
        }
        int cmp = value.compareTo(current.getValue());
        if (cmp == 0) {
            return current.getValue();
        } else if (cmp < 0) {
            return searchRecursive(current.getLeft(), value);
        } else {
            return searchRecursive(current.getRight(), value);
        }
    }

    public T searchByAge(int edad) {
        return searchByAgeRecursive(root, edad);
    }

    private T searchByAgeRecursive(Node<T> current, int edad) {
        if (current == null) {
            return null;
        }

        // Como T es Person, podemos castear de forma segura
        Person persona = (Person) current.getValue();

        if (edad == persona.getEdad()) {
            return current.getValue(); // devuelve el objeto completo (tipo T, que es Person)
        } else if (edad < persona.getEdad()) {
            return searchByAgeRecursive(current.getLeft(), edad);
        } else {
            return searchByAgeRecursive(current.getRight(), edad);
        }
    }

}
