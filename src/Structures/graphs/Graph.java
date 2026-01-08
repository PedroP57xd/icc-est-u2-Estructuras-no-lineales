package Structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Structures.nodes.Node;

public class Graph<T> {
    // PRIMERA FORMA
    // TRABAJA CON LISTADO DE ADYACENCIA
    // List<Node<T>> nodes;

    // Segunda forma
    private Map<Node<T>, List<Node<T>>> mapa;

    public Graph() {
        // this.nodes = new ArrayList<>();
        this.mapa = new HashMap<Node<T>, List<Node<T>>>();

    }

    // Ingresa un vertice o nodo
    public void addNode(Node<T> node) {
        mapa.putIfAbsent(node, new ArrayList<>());
    }

    // Listado de los nodos con los hijos

    // public void insertNode(T value) {
    // Node<T> newNode = new Node<T>(value);
    // this.nodes.add(newNode);
    // }

    public void addEdge(Node<T> n1, Node<T> n2) {
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
        mapa.get(n2).add(n1);
    }

    public void printGraph() {

        for (Map.Entry<Node<T>, List<Node<T>>> entry : mapa.entrySet()) {
            System.out.print(entry.getKey() + "->");
            for (Node<T> neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public Node<T>[] getNeighbors(Node<T> node) {
        List<Node<T>> neighbors = mapa.get(node);

        if (neighbors == null) {
            return (Node<T>[]) new Node[0]; 
        }

        return neighbors.toArray((Node<T>[]) new Node[neighbors.size()]);
    }
}
