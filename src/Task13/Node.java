package Task13;

import java.util.ArrayDeque;
import java.util.Deque;

public class Node {
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public static void iterativeTreeTraversal(Node root) {
        if (root == null) {
            return;
        }
        Deque<Node> tree = new ArrayDeque<>();
        Node currentNode = root;

        while (currentNode != null || !tree.isEmpty()) {
            while (currentNode != null) {
                tree.push(currentNode);
                currentNode = currentNode.leftChild;
            }

            Node forPrint = tree.pop();
            System.out.println("Node: " + forPrint.value);
            currentNode = forPrint.rightChild;

        }
    }

    public static int findTreeHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = findTreeHeight(root.leftChild);
        int rightHeight = findTreeHeight(root.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
