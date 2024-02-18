/* 
Task:
complete the function sumOfLeafNodes that takes root node of a BST with n nodes as parameter and returns the sum of leaf nodes. 
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

public class Sum_of_leaf_nodes_in_BST {
    public static int sumOfLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }
        return sumOfLeafNodes(root.left) + sumOfLeafNodes(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Node root = buildBST(arr);

        int sum = sumOfLeafNodes(root);
        System.out.println("Output: " + sum);

        scanner.close();
    }

    public static Node buildBST(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node root = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            insert(root, arr[i]);
        }
        return root;
    }

    public static void insert(Node root, int data) {
        if (data < root.data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                root.left = new Node(data);
            }
        } else {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                root.right = new Node(data);
            }
        }
    }
}
