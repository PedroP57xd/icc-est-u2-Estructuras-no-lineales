package Structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import Structures.nodes.Node;
import models.Person;

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

    public void bfs(Node<T> start) {
        Set<Node<T>> visitados = new LinkedHashSet();
        Queue<Node<T>> queue = new LinkedList<>();

        visitados.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {// para romper, debemos vaciar la cola
            Node<T> current = queue.poll();
            System.out.println(current.getValue() + " ");

            // Que me da el bfs? me da la busqueda en anchura, imprime primero la raiz,
            // despues todos sus conocidos, y despues los conocidos de los conocidos}
            for (Node<T> conocido : getNeighbors(current)) {
                if (!visitados.contains(conocido)) {
                    visitados.add(conocido);
                    queue.add(conocido);//
                }
            }
        }
    }

    public void dfs(Node<T> start) {
        Set<Node<T>> visitados = new LinkedHashSet<>();
        dfsRecursive(start, visitados);

    }

    private void dfsRecursive(Node<T> current, Set<Node<T>> visitados) {
        //como funciona? primero visita la raiz, despues visita el primer conocido, 
        // despues el conocido del conocido, hasta que no haya mas conocidos que visitar, 
        // luego vuelve atras y visita el siguiente conocido del nodo anterior, y asi sucesivamente.    

        visitados.add(current);
        System.out.println(current.getValue() + " ");

        for (Node<T> conocido : getNeighbors(current)) {
            if (!visitados.contains(conocido)) {
                dfsRecursive(conocido, visitados);
            }
        }
    }

    public void addConocido(T p1, T p2) {
        Node<T> np1 = new Node<>(p1);
        Node<T> np2 = new Node<>(p2);
        addEdge(np1, np2);
    }
}