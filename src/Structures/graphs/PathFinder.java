package Structures.graphs;

import Structures.nodes.Node;

public interface PathFinder <T>{
    PathResult<T>find(Graph<T> graph ,Node<T> start,Node<T> end);
}
