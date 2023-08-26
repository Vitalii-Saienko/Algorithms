package queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        System.out.println("is empty: " + queue.isEmpty());//test isEmpty
        queue.pushToEnd(1);//test pushToEnd()
        queue.pushToEnd(2);
        queue.pushToEnd(3);
        queue.pushToEnd(4);
        queue.pushToEnd(5);
        System.out.println(queue);
        System.out.println("size: " + queue.size() + " ,capacity: " + queue.getCapacity());//test size()
        queue.pushToEnd(6);//test increase capacity()
        System.out.println(queue);
        System.out.println("size: " + queue.size() + " ,capacity: " + queue.getCapacity());
        queue.remove();//test remove()
        System.out.println("queue after removing element: " + queue);
        System.out.println("size: " + queue.size() + " ,capacity: " + queue.getCapacity());
        System.out.println("peek: " + queue.peek());//test peek()
        System.out.println(queue);
        System.out.println("size: " + queue.size());
        System.out.println("is empty: " + queue.isEmpty());
    }
}
