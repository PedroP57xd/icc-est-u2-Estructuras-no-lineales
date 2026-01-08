import Structures.graphs.Graph;
import Structures.nodes.Node;
import Structures.trees.IntTree;
import Structures.trees.Tree;
import models.Person;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Arboles");
        // runIntTree();
        // runTree();
        runGraph();
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
