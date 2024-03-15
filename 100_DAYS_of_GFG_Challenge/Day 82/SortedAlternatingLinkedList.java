/*
Task:
The task is to complete the function sort() which should sort the linked list of size n in non-decreasing order. 

*/



import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SortedAlternatingLinkedList {

    public static Node sort(Node head) {
        Node odd = new Node(-1);
        Node even = new Node(-1);
        Node oddPointer = odd;
        Node evenPointer = even;
        int count = 1;

        while (head != null) {
            if (count % 2 == 0) {
                evenPointer.next = head;
                evenPointer = evenPointer.next;
            } else {
                oddPointer.next = head;
                oddPointer = oddPointer.next;
            }
            head = head.next;
            count++;
        }

        evenPointer.next = null;
        oddPointer.next = null;

        return merge(odd.next, reverse(even.next));
    }

    public static Node merge(Node odd, Node even) {
        Node dummy = new Node(-1);
        Node current = dummy;

        while (odd != null && even != null) {
            if (odd.data < even.data) {
                current.next = odd;
                odd = odd.next;
            } else {
                current.next = even;
                even = even.next;
            }
            current = current.next;
        }

        if (odd != null) {
            current.next = odd;
        }
        if (even != null) {
            current.next = even;
        }

        return dummy.next;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.print("Enter the elements of the linked list: ");
        Node head = new Node(scanner.nextInt());
        Node current = head;
        for (int i = 1; i < n; i++) {
            current.next = new Node(scanner.nextInt());
            current = current.next;
        }

        head = sort(head);

        System.out.print("Output: ");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
