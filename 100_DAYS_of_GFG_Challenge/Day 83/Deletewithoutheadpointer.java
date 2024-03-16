/*Task:
The task is  to complete the function deleteNode() which takes a reference of the deleting node value & delete the given node value.*/




import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Deletewithoutheadpointer {
    static Node head;

    static void deleteNode(Node dn) {
        if (dn == null || dn.next == null) {
            return;
        }
        while (dn.next.next != null) {
            dn.data = dn.next.data;
            dn = dn.next;
        }
        int lastNodeValue = dn.next.data;
        dn.next = null;
        dn.data = lastNodeValue;
    }

    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deletewithoutheadpointer list = new Deletewithoutheadpointer();

        System.out.print("Linked List = ");
        String input = scanner.nextLine();
        String[] values = input.split(" -> ");

        Node prev = null;
        for (String value : values) {
            int num = Integer.parseInt(value);
            Node newNode = new Node(num);
            if (prev != null) {
                prev.next = newNode;
            } else {
                head = newNode;
            }
            prev = newNode;
        }

        System.out.print("del_node = ");
        int delValue = scanner.nextInt();

        Node delNode = head;
        while (delNode != null && delNode.data != delValue) {
            delNode = delNode.next;
        }

        deleteNode(delNode);

        System.out.print("Output: ");
        printLinkedList(head);
    }
}
