package linkedList;

public class LinkedList {
    private Node head;

    public void pushToHead(int data){
        Node temp = new Node();
        temp.value = data;
        temp.next = head; // ссылка указывается пока что на текущую (предыдущую голову списка)
        head = temp; // голова списка теперь ссылается на новую ноду
    }
    public void pushToTail(int data){
         Node temp = new Node();
         temp.value = data;

         if (head == null){ // если лист пустой то новый элемент становится головой
             head = temp;
             return;
         }

         Node end = head;
         while (end.next != null){
             end=end.next;
         }
         end.next = temp;
    }
    public void pushToIndex(int index, int data){
        Node temp = new Node();
        temp.value = data;

        if (index <=0 ) {
            pushToHead(data);
        }

        int counter = 0;
        Node t = head;
        while (t.next != null){
            if (counter +1 == index){
                break;
            }
            counter++;
            t=t.next;
        }
        temp.next = t.next;
        t.next = temp;
    }
    public void removeFirst(){
        if (head == null){
            System.out.println("List is already empty.");
        }
        head = head.next;
    }
    public void removeLast(){
        if (head == null){
            System.out.println("List is already empty.");
            return;
        }
        if (head.next == null){
            removeFirst();
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }
    public void removeByIndex(int index){
        if (head == null){
            System.out.println("List is already empty.");
            return;
        }
        if (index <= 0){
            removeFirst();
            return;
        }
        int counter = 0;
        Node temp = head;
        while (temp.next != null) {
            if (counter + 1 == index) {
                if (temp.next.next == null) {
                    temp.next = null;
                } else {
                    temp.next = temp.next.next;
                }
                return;
            }
            counter++;
            temp = temp.next;
        }
    }
    public int getIndex(int index){
        if (head == null) {
            System.out.println("List is empty.");
            return -1;
        }
        if (index < 0) {
            System.out.println("Index is not valid.");
            return -1;
        }
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            if (counter == index) {
                return temp.value;
            }
            counter++;
            temp = temp.next;
        }
        System.out.println("Index out of bounds.");
        return -1;
    }
    public int size(){
        if (head == null) {
            System.out.println("List is empty.");
            return -1;
        }
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }
    public void print(){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
class Node{
    int value;
    Node next;
}