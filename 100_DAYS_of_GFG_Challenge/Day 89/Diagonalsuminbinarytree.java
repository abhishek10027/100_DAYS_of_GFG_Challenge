/*
Task:
Just complete the function diagonalSum() that takes root node of the tree as parameter and
returns an array containing the diagonal sums for every diagonal present in the tree with slope -1.
*/


import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Diagonalsuminbinarytree {
    public static ArrayList<Integer> diagonalSum(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int n = q.size();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                while (node != null) {
                    sum += node.data;
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    node = node.right;
                }
            }
            ans.add(sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements of the binary tree (space-separated, use 'N' for null nodes):");
        Node root = buildTree(scanner.nextLine().split(" "));
        ArrayList<Integer> result = diagonalSum(root);
        System.out.println("Diagonal sums of the binary tree:");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static Node buildTree(String[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0].equals("N"))
            return null;
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(nodes[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            Node currNode = queue.poll();
            if (!nodes[i].equals("N")) {
                currNode.left = new Node(Integer.parseInt(nodes[i]));
                queue.add(currNode.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("N")) {
                currNode.right = new Node(Integer.parseInt(nodes[i]));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}
