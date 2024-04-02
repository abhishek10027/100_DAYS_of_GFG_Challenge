/*
Your Task:
Just complete the function absolute_diff() , that takes root as input and return minimum absolute difference between any two nodes.
*/

import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter space-separated numbers to create BST:");
        String input = scanner.nextLine();
        String[] values = input.split(" ");
        Node root = null;
        for (String value : values) {
            root = insert(root, Integer.parseInt(value));
        }
        System.out.println("Minimum Absolute Difference: " + absolute_diff(root));
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static int absolute_diff(Node root) {
        int prev[] = {-1};
        int min[] = {Integer.MAX_VALUE};
        inorder(root, prev, min);
        return min[0];
    }

    static void inorder(Node root, int prev[], int min[]) {
        if (root == null) return;
        inorder(root.left, prev, min);
        if (prev[0] != -1) {
            min[0] = Math.min(min[0], Math.abs(prev[0] - root.data));
        }
        prev[0] = root.data;
        inorder(root.right, prev, min);
    }
}
