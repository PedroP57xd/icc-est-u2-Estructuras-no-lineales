package Structures.graphs;

import java.util.List;

import Structures.nodes.Node;

public class PathResult <T>{
    private final List<Node<T>> visitados; 
    private final List<Node<T>> path;
    public PathResult(List<Node<T>> visitados, List<Node<T>> path) {
        this.visitados = visitados;
        this.path = path;
    }
    public List<Node<T>> getVisitados() {
        return visitados;
    }
    public List<Node<T>> getPath() {
        return path;
    }

    
}
