import Structures.trees.IntTree;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Arboles");
        runIntTree();
    }
    public static void runIntTree(){
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
        System.out.print("Tamaño del arbol: "+ tree.size());

    }
}
