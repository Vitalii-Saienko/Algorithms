package Task13;

import java.util.ArrayDeque;
import java.util.Deque;

public class Node {
    int value;
    Node leftChild;
    Node rightChild;
    private Node root = null;

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
    private Node searchParent(Node t, Node s) {
        if (s == root) {
            return null;
        }
        if (t.leftChild == s || t.rightChild == s) {
            return t;
        }
        if (s.value < t.value) {
            return searchParent(t.leftChild, s);
        } else {
            return searchParent(t.rightChild, s);
        }
    }
    // Находим минимальный элемент в поддереве элемента t
    private Node subtreeMin(Node t) {
        while (t.leftChild != null) {
            t = t.leftChild;
        }
        return t;
    }
    public void delete (Node t, Node root) {
        // Нам нужен parent элемента t. Найдем его
        Node parent = searchParent(root, t);
        if (t.leftChild == null && t.rightChild == null) {
            // Удаляется лист дерева
            if (parent.leftChild == t) {
                // У родителя удаляется левый потомок
                parent.leftChild = null;
            } else {
                // У родителя удаляется правый потомок
                parent.rightChild = null;
            }
        } else if (t.leftChild == null || t.rightChild == null) {
            // Удаляется элемент с одним потомком
            if (t.leftChild == null) {
                if (parent.leftChild == t) {
                    parent.leftChild = t.rightChild;
                } else {
                    parent.rightChild = t.rightChild;
                }
            } else {
                if (parent.leftChild == t) {
                    parent.leftChild = t.leftChild;
                } else {
                    parent.rightChild = t.leftChild;
                }
            }
        } else {
            // Удаляется элемент с двумя потомками
            // 1) Находим минимальный элемент в правом поддереве
            Node min = subtreeMin(t.rightChild);
            min.leftChild = t.leftChild; //переносим левую ветку удаляемого элемента на левую подветку элемента кот.станет на место удаляемого
            if (t.value < root.value){
                parent.leftChild = min;
            } else {
                parent.rightChild = min;
            }
        }
    }
}
