/* 
Task:
Complete the function levelOrder() that takes the root node as input parameter and 
returns a list of integers containing the level order traversal of the given Binary Tree.

*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Levelordertraversal {
    // Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node root) {
        // Your code here
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
            list.add(temp.data);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user for the tree structure
        System.out.println("Enter the root node value:");
        int rootValue = scanner.nextInt();
        Node root = new Node(rootValue);

        System.out.println("Enter the value of left child of " + rootValue + " (Enter -1 if no left child):");
        int leftValue = scanner.nextInt();
        if (leftValue != -1) {
            root.left = new Node(leftValue);
        }

        System.out.println("Enter the value of right child of " + rootValue + " (Enter -1 if no right child):");
        int rightValue = scanner.nextInt();
        if (rightValue != -1) {
            root.right = new Node(rightValue);
        }

        // Perform level order traversal
        ArrayList<Integer> result = levelOrder(root);

        // Print the level order traversal
        System.out.println("Level Order Traversal:");
        for (Integer val : result) {
            System.out.print(val + " ");
        }
    }
}
