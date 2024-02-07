/* 
Task:
Task is to complete the function findDist() which takes the root node of the tree and the two node values a and b as input parameters and 
returns the minimum distance between the nodes represented by the two given node values.
*/



import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Min_distance_between_two_given_nodes_of_a_Binary_Tree {

    Node findLCA(Node node, int a, int b) {
        if (node == null || node.data == a || node.data == b)
            return node;

        Node left = findLCA(node.left, a, b);
        Node right = findLCA(node.right, a, b);

        if (left != null && right != null)
            return node;
        return (left != null) ? left : right;
    }

    int findDist(Node root, int a, int b) {
        Node lca = findLCA(root, a, b);

        int distA = findDistance(lca, a, 0);
        int distB = findDistance(lca, b, 0);

        return distA + distB;
    }

    int findDistance(Node node, int target, int depth) {
        if (node == null)
            return -1;

        if (node.data == target)
            return depth;

        int leftDist = findDistance(node.left, target, depth + 1);
        if (leftDist != -1)
            return leftDist;

        int rightDist = findDistance(node.right, target, depth + 1);
        return rightDist;
    }

    static Node buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null"))
            return null;

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(nodes[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            Node curr = queue.poll();

            if (!nodes[i].equals("null")) {
                curr.left = new Node(Integer.parseInt(nodes[i]));
                queue.add(curr.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("null")) {
                curr.right = new Node(Integer.parseInt(nodes[i]));
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Min_distance_between_two_given_nodes_of_a_Binary_Tree g = new Min_distance_between_two_given_nodes_of_a_Binary_Tree();

        while (true) {
            System.out.print("Enter the nodes of the binary tree separated by spaces (use 'null' for missing nodes): ");
            String[] nodesInput = scanner.nextLine().split("\\s+");

            if (nodesInput.length == 0 || nodesInput[0].equals("null"))
                break;

            Node root = buildTree(nodesInput);

            System.out.print("Enter the value of node 'a': ");
            int a = scanner.nextInt();
            System.out.print("Enter the value of node 'b': ");
            int b = scanner.nextInt();

            int distance = g.findDist(root, a, b);
            System.out.println("Distance between nodes " + a + " and " + b + " is: " + distance);

            scanner.nextLine(); // Consume newline
            System.out.print("Do you want to continue (yes/no)? ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (!input.equals("yes")) {
                break;
            }
        }
        scanner.close();
    }
}
