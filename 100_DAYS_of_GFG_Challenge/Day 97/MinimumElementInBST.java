/*
Task:
The task is to complete the function minValue() which takes root as the argument and 
returns the minimum element of BST. If the tree is empty, there is no minimum element, so return -1 in that case.

*/
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

class MinimumElementInBST {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // Base case: if the left child is null, then the minimum value is found.
        if (root.left == null)
            return root.data;

        // Traverse to the left subtree recursively to find the minimum value.
        return minValue(root.left);
    }

    // Function to construct the BST from the provided input.
    Node constructBST(String[] values) {
        if (values == null || values.length == 0 || values[0].equals("N"))
            return null;

        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            Node current = queue.poll();
            if (!values[i].equals("N")) {
                current.left = new Node(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;
            if (i < values.length && !values[i].equals("N")) {
                current.right = new Node(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinimumElementInBST tree = new MinimumElementInBST();

        System.out.println("Enter the elements of the BST (enter 'N' for null):");

        String input = scanner.nextLine();
        String[] values = input.split("\\s+");

        // Construct the BST based on the input provided.
        Node root = tree.constructBST(values);

        // Close the scanner after input is complete.
        scanner.close();

        // Call the minValue function to find the minimum element in the BST.
        int minimumValue = tree.minValue(root);
        System.out.println("Minimum element in the BST: " + minimumValue);
    }
}



