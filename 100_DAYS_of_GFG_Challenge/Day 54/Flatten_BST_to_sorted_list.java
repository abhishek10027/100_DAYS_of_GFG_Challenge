/* 
Task:
The task is to complete the function flattenBST() which takes root node of the BST as input parameter and
 returns the root node after transforming the tree.

*/


import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Flatten_BST_to_sorted_list {
    void inOrder(Node root, List<Integer> in) {
        if (root != null) {
            inOrder(root.left, in);
            in.add(root.data);
            inOrder(root.right, in);
        }
    }

    public Node flattenBST(Node root) {
        List<Integer> in = new ArrayList<>();
        inOrder(root, in);

        Node head = new Node(in.get(0));
        Node p = head;

        for (int i = 1; i < in.size(); i++) {
            p.right = new Node(in.get(i));
            p.left = null;
            p = p.right;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of the binary search tree in level order (-1 for null):");
        Node root = buildTree(scanner);

        Flatten_BST_to_sorted_list solution = new Flatten_BST_to_sorted_list();
        Node flattenedTree = solution.flattenBST(root);

        System.out.println("Flattened BST:");
        printInOrder(flattenedTree);
    }

    private static Node buildTree(Scanner scanner) {
        Queue<Node> queue = new LinkedList<>();
        System.out.print("Enter root node value: ");
        int rootValue = scanner.nextInt();
        Node root = new Node(rootValue);
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            System.out.print("Enter left child of " + currentNode.data + " (-1 for null): ");
            int leftValue = scanner.nextInt();
            if (leftValue != -1) {
                currentNode.left = new Node(leftValue);
                queue.add(currentNode.left);
            }

            System.out.print("Enter right child of " + currentNode.data + " (-1 for null): ");
            int rightValue = scanner.nextInt();
            if (rightValue != -1) {
                currentNode.right = new Node(rightValue);
                queue.add(currentNode.right);
            }
        }
        return root;
    }

    private static void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }
}
