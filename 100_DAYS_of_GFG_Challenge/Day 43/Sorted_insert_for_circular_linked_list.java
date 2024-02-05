/* 
Task:

The task is to complete the function sortedInsert() which should insert the new node into the given circular linked list and 
return the head of the linked list.

*/

import java.util.Scanner;

// Node class representing a node in the linked list
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Sorted_insert_for_circular_linked_list class with the sortedInsert method
class Sorted_insert_for_circular_linked_list {
    public Node sortedInsert(Node head, int data) {
        Node newnode = new Node(data);

        // if circular linked list is empty
        if (head == null) {
            // point it to itself
            newnode.next = newnode;
            return newnode;
        }

        // insert at the beginning
        if (head.data >= data) {
            newnode.next = head;
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newnode;
            return newnode;
        }

        // insert at a position in between or end
        else {
            Node temp = head;
            while (temp.next != head && temp.next.data < data) {
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
            return head;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of nodes
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();

        // Input the linked list elements
        System.out.println("Enter the elements of the linked list:");
        Node head = null;
        Node tail = null;
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Connect the last node to the first to make it circular
        tail.next = head;

        // Input the data to be inserted
        System.out.println("Enter the data to be inserted:");
        int newData = sc.nextInt();

        // Create an instance of Sorted_insert_for_circular_linked_list class
        Sorted_insert_for_circular_linked_list solution = new Sorted_insert_for_circular_linked_list();

        // Perform sorted insertion
        head = solution.sortedInsert(head, newData);

        // Display the updated circular linked list
        displayCircularLinkedList(head);

        // Close the scanner
        sc.close();
    }

    // Display the circular linked list
    private static void displayCircularLinkedList(Node head) {
        System.out.println("Updated Circular Linked List:");
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }
}


