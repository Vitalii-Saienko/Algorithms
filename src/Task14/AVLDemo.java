package Task14;

public class AVLDemo {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);
        tree.insert(5);
        tree.insert(20);
        tree.insert(30);

        tree.printTree();
    }
}
