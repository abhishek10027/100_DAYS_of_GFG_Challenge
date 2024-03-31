/*
Your task :

The task is to complete the function findMaxForN() which takes the root of the BST, and the integer n as input paramters and 
returns the greatest element less than or equal to n in the given BST.

*/



import java.util.*;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class ClosestNeighborInBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the BST elements separated by spaces followed by 'N' for null nodes:");
        Node root = null;
        String[] input = scanner.nextLine().split(" ");
        for (String s : input) {
            if (!s.equals("N")) {
                int val = Integer.parseInt(s);
                root = insert(root, val);
            }
        }
        System.out.println("Enter the value to find its closest neighbor:");
        int n = scanner.nextInt();
        int max = findMaxForN(root, n);
        System.out.println("Closest Neighbour in BST: " + max);
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key <= root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);
        return root;
    }

    public static int findMaxForN(Node root, int n) {
        int ans = -1;
        while (root != null) {
            if (root.key == n)
                return root.key;
            else if (root.key < n) {
                ans = root.key;
                root = root.right;
            } else
                root = root.left;
        }
        return ans;
    }
}
