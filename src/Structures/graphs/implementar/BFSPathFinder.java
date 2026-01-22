package Structures.graphs.implementar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import Structures.graphs.Graph;
import Structures.graphs.PathFinder;
import Structures.graphs.PathResult;
import Structures.nodes.Node;

public class BFSPathFinder<T> implements PathFinder {

    @Override
    public PathResult find(Graph graph, Node start, Node end) {
        Queue<Node<T>> queue = new LinkedList<>();
        Set<Node<T>> visited = new HashSet<>();

        Map<Node<T>, Node<T>> parente = new HashMap<>();
        List<Node<T>> visitados = new ArrayList<>();

        queue.add(start);
        visited.add(start);
        parente.put(start, null);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            visitados.add(current);
            if (current.equals(end)) {
                return new PathResult<>(visitados, buildPath(parente,end));
            }
            for (Node<T> conocido : graph.getNeighbors(current)) {
                if (!visited.contains(conocido)) {
                    visited.add(conocido);
                    parente.put(conocido, current);
                    queue.add(conocido);
                }
            }
        }
        return new PathResult<>(visitados, List.of());
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
