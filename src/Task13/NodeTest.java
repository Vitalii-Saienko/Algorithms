package Task13;


public class NodeTest {
    public static void main(String[] args) {
        /*
                          100                            | 1
                   25                150                 | 2
               15     75       130         180           | 3
                        76              165     181      | 4
                                     164  166       182  | 5
         */

        Node root = new Node(100);
        root.leftChild = new Node(25);
        root.leftChild.leftChild = new Node(15);
        root.leftChild.rightChild = new Node(75);
        root.leftChild.rightChild.rightChild = new Node(76);

        root.rightChild = new Node(150);
        root.rightChild.leftChild = new Node(130);
        root.rightChild.rightChild = new Node(180);
        root.rightChild.rightChild.leftChild = new Node(165);
        root.rightChild.rightChild.leftChild.leftChild = new Node(164);
        root.rightChild.rightChild.leftChild.rightChild = new Node(166);
        root.rightChild.rightChild.rightChild = new Node(181);
        root.rightChild.rightChild.rightChild.rightChild = new Node(182);

        System.out.println("Task1 - iterative tree traversal:");
        Node.iterativeTreeTraversal(root);

        System.out.println("Task2 - find height: " + Node.findTreeHeight(root));

        System.out.println("Task3 - finish delete method, lets delete node with value=180: ");
        root.delete(root.rightChild.rightChild, root);
        Node.iterativeTreeTraversal(root);

    }
}
