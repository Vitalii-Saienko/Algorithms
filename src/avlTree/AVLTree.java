package avlTree;

public class AVLTree {
    private Node root;

    private int getHeight(Node n) {
        return n == null ? -1 : n.height;
    }

    private void updateHeight(Node n) {
        n.height = Math.max(getHeight(n.leftChild), getHeight(n.rightChild)) + 1;
    }

    private int getBalance(Node n) {
        return (n == null) ? 0 : getHeight(n.rightChild) - getHeight(n.leftChild);
    }

    private Node rotateRight(Node y) {
        Node x = y.leftChild;
        Node z = x.rightChild;
        x.rightChild = y;
        y.leftChild = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

private Node rotateLeft(Node y) {
    if (y == null || y.rightChild == null) { //added null check
        return y;
    }

    Node x = y.rightChild;
    Node z = x.leftChild;

    x.leftChild = y;
    y.rightChild = z;

    updateHeight(y);
    updateHeight(x);

    return x;
}
    private Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (getHeight(z.rightChild.rightChild) <= getHeight(z.rightChild.leftChild)) {
                z.rightChild = rotateRight(z.rightChild);
            }
            z = rotateLeft(z);
        } else if (balance < -1) {
            if (getHeight(z.leftChild.leftChild) >= getHeight(z.leftChild.rightChild)) {
                z.leftChild = rotateLeft(z.leftChild);
            }
            z = rotateRight(z);
        }
        return z;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    // Рекурсивная реализация вставки в АВЛ-дерево
    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        //changed:
        if (key < node.key) {
            node.leftChild = insert(node.leftChild, key);
        } else if (key > node.key) {
            node.rightChild = insert(node.rightChild, key);
        } else {
            // Key already exists, no need to insert again
            return node;
        }

        return rebalance(node);
    }

    public void delete(int key) {
        root = delete(root, key);
    }
    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        } else if (node.key > key) {
            node.leftChild = delete(node.leftChild, key);
        } else if (node.key < key) {
            node.rightChild = delete(node.rightChild, key);
        } else {
            if (node.leftChild == null || node.rightChild == null) {
                node = (node.leftChild == null) ? node.rightChild : node.leftChild;
            } else {
                Node mostLeftChild = subtreeMin(node.rightChild);
                node.key = mostLeftChild.key;
                node.rightChild = delete(node.rightChild, mostLeftChild.key); // not delete(node.rightChild, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private Node subtreeMin(Node t) {
        while (t.leftChild != null) {
            t = t.leftChild;
        }
        return t;
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node node, int level) {
        if (node == null) {
            return;
        }

        printTree(node.rightChild, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("        ");
        }

        if (level == 0) {
            System.out.println("root:");
            System.out.println("| " + node.key + " |");
        } else {
            System.out.println(node.key);
        }

        printTree(node.leftChild, level + 1);
    }

    private class Node {
        int key;
        int height;
        Node leftChild, rightChild;

        public Node(int key) {
            this.key = key;
        }
    }
}
