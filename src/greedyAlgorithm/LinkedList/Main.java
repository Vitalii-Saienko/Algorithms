package greedyAlgorithm.LinkedList;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(15);
        head.next = new ListNode(2);
        head.next.next = new ListNode(35);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(55);

        ListNode head2 = new ListNode(10);
        head2.next = new ListNode(20);
        head2.next.next = new ListNode(30);
        head2.next.next.next = new ListNode(40);
        head2.next.next.next.next = new ListNode(50);

        int n = 2;
        System.out.println("Before deleting:");
        printLinkedList(head);
        ListNode result = removeNthFromEnd(head, n);
        System.out.println("After:");
        printLinkedList(result);

    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fiction = new ListNode(0);
        fiction.next = head;
        ListNode first = fiction;
        ListNode second = fiction;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return fiction.next;
    }
}
