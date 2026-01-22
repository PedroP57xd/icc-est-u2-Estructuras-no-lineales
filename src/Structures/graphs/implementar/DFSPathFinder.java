package Structures.graphs.implementar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Structures.graphs.Graph;
import Structures.graphs.PathResult;
import Structures.nodes.Node;

public class DFSPathFinder <T>{
    public PathResult find(Graph graph, Node start, Node end) {
        Set<Node<T>> visitados = new LinkedHashSet<>();
        findResursive(graph, start, end);
        return null;
    }

    private PathResult findResursive(Graph graph, Node start, Node end) {
        Map<Node<T>, Node<T>> parente = new HashMap<>();
        List<Node<T>> visitados = new ArrayList<>();
        
        visitados.add(gra);
        System.out.println(gra.getValue() + " ");

        for (Node<T> conocido : getNeighbors(gra)) {
            if (!visitados.contains(conocido)) {
                dfsRecursive(conocido, visitados);
            }
        }
        return null;
    }


    private List<Node<T>> buildPath(Map<Node<T>,Node<T>> parent, Node end) {
        //Va a construir la ruta
        List<Node<T>> path=new ArrayList<>();
        for(Node<T> at =end; at!=null;at=parent.get(at)){
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}
