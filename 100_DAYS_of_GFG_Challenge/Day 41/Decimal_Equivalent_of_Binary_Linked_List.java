/* 
Task:
Complete the function decimalValue() which takes a head node of a linked list as an input parameter and 
returns decimal representation of it.

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

public class Decimal_Equivalent_of_Binary_Linked_List
 {
    public static long DecimalValue(Node head) {
        long ans = 0;
        long mod = 1000000007;

        while (head != null) {
            ans = (ans << 1) % mod;
            ans = (ans + head.data) % mod;
            head = head.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();

        Node head = null;
        Node tail = null;

        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Decimal_Equivalent_of_Binary_Linked_List solution = new Decimal_Equivalent_of_Binary_Linked_List();
        long result = solution.DecimalValue(head);

        System.out.println("Decimal Value: " + result);

        scanner.close();
    }
}
