package linkedList;

public class Demo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.pushToHead(1);
        linkedList.pushToHead(2);
        linkedList.pushToHead(3);
        linkedList.pushToHead(4);
        linkedList.pushToHead(5);
        linkedList.print();
        System.out.println("size: " + linkedList.size());
        System.out.println("element index 3: " + linkedList.getIndex(3));
        linkedList.removeFirst();
        System.out.println("list after removing first element:");
        linkedList.print();
        linkedList.pushToIndex(1,100);
        System.out.println("list after adding element 100 to index 1:");
        linkedList.print();
        linkedList.pushToTail(200);
        System.out.println("list after adding element 200 to the end:");
        linkedList.print();
        linkedList.removeByIndex(4);
        System.out.println("list after removing element with index 4:");
        linkedList.print();

    }
}
