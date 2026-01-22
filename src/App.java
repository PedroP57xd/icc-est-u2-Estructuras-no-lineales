import Structures.graphs.Graph;
import Structures.graphs.PathFinder;
import Structures.graphs.PathResult;
import Structures.graphs.implementar.BFSPathFinder;
import Structures.nodes.Node;
import Structures.trees.IntTree;
import Structures.trees.Tree;
import models.Person;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("GRAPHS");
        // runIntTree();
        // runTree();
        // runGraph();
        runGraphRecorridos();
    }

    private static void runGraphRecorridos() {
        Graph<Person> graph = new Graph<>();

        Person pC23 = new Person("Carlos", 23);
        Person pL18 = new Person("Luis", 18);
        Person pA23 = new Person("Andres", 23);
        Person pA30 = new Person("Ana", 30);
        Person pJ25 = new Person("Juan", 25);
        Person pAn20 = new Person("Ana", 20);
        Person pM10 = new Person("Mateo", 10);
        Person pJ10 = new Person("Julio", 10);

        graph.addEdge(new Node<>(pC23), new Node<>(pA30));
        graph.addConocido(pC23, pL18);
        graph.addConocido(pC23, pA23);
        graph.addConocido(pL18, pJ25);
        graph.addEdge(new Node<>(pL18), new Node<>(pA23));
        graph.addConocido(pAn20, pA30);
        graph.addEdge(new Node<>(pA30), new Node<>(pM10));
        graph.addEdge(new Node<>(pM10), new Node<>(pJ10));
        graph.bfs(new Node<Person>(pC23));
        System.out.println();
        graph.dfs(new Node<Person>(pC23));

        PathFinder<Person> finder = new BFSPathFinder<>();
        PathResult<Person> resultado=finder.find(graph, new Node(pC23), new Node(pJ10));
        System.out.println("Orden BFS");
        resultado.getVisitados().forEach(node->System.err.println(node.getValue()+""));
        System.out.println("Ruta encontrada por BBFS");
        resultado.getPath().forEach(node->System.err.println(node.getValue()+""));
        
    }

    private static void runGraph() {
        Graph<String> graph = new Graph<>();

        Node<String> nA = new Node<String>("A");
        Node<String> nB = new Node<String>("B");
        Node<String> nC = new Node<String>("C");
        Node<String> nD = new Node<String>("D");

        graph.addNode(nA);
        graph.addEdge(nA,nB);
        graph.addEdge(nA,nC);
        graph.addEdge(nB,nD);
        graph.addEdge(nC,nD);
        graph.printGraph();

        //Conectados a A
        Node<String>[] neighbors= graph.getNeighbors(nA);
        System.out.print("Neighbors de A: ");
        for (Node<String> neighbor : neighbors) {
            System.out.println(neighbor+" ");
        }
    }

    private static void runTree() {
        Tree<Person> tree = new Tree<Person>();
        tree.insert(new Person("Pablo", 21));
        tree.insert(new Person("Maria", 23));
        tree.insert(new Person("Ana", 25));
        tree.insert(new Person("Pedro", 23));
        tree.insert(new Person("Luis", 19));
        System.out.print("\n\nOrdenamientoo InOrder:\n   ");
        tree.inOrder();
        System.out.println("\n Busqueda de persona");
        Person findPerson = tree.searchByAge(23);
        if (findPerson != null) {
            System.out.println(findPerson);
        } else {

        }

    }

    public static void runIntTree() {
        IntTree tree = new IntTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(15);
        System.out.print("\nOrdenamientoo PreOrder:\n   ");
        tree.preOrder();
        System.out.print("\n\nOrdenamientoo PosOrder:\n   ");
        tree.posOrder();
        System.out.print("\n\nOrdenamientoo InOrder:\n   ");
        tree.inOrder();
        System.out.println(" ");
        System.out.print("Tamaño del arbol: " + tree.size());

    }
}
