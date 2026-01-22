package Structures.nodes;

import java.util.List;

public class Node<T> implements Comparable<Node<T>> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    //trabaja con losnodos conocidos
    private List<Node<T>> conocidos;
    
    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "N["+value+"]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Node<?> other = (Node<?>) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public int compareTo(Node<T> o) {
        if (value instanceof Comparable) {
            return ((Comparable<T>) value).compareTo(o.value);
        }
        return 0;
    }

    
}
