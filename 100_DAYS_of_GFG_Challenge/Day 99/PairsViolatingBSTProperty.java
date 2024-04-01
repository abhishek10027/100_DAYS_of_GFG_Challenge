/*
Your task :
The task is to complete the function pairsViolatingBST() that takes the root of the tree and n as input and 
returns number of pairs violating BST property.
*/

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class PairsViolatingBSTProperty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = scanner.nextInt();
        System.out.println("Enter the values of the nodes (enter N for null nodes):");
        Node root = buildTree(scanner, n);
        Solution solution = new Solution();
        int pairsViolatingBST = solution.pairsViolatingBST(n, root);
        System.out.println("Output: " + pairsViolatingBST);
        scanner.close();
    }

    public static Node buildTree(Scanner scanner, int n) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            String valueStr = scanner.next();
            if (!valueStr.equals("N")) {
                int value = Integer.parseInt(valueStr);
                nodes[i] = new Node(value);
            } else {
                nodes[i] = null;
            }
        }
        Queue<Node> queue = new LinkedList<>();
        Node root = nodes[0];
        queue.add(root);
        for (int i = 0; i < n; i++) {
            Node current = queue.poll();
            if (current != null) {
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;
                if (leftIndex < n) {
                    current.left = nodes[leftIndex];
                    queue.add(nodes[leftIndex]);
                }
                if (rightIndex < n) {
                    current.right = nodes[rightIndex];
                    queue.add(nodes[rightIndex]);
                }
            }
        }
        return root;
    }
}

class Solution {
    public long merge(int[] arr, int s, int mid, int e) {
        long[] temp = new long[e - s + 1];
        int i = s;
        int j = mid + 1;
        int k = 0;
        long inversion = 0;

        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                inversion += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= e) {
            temp[k++] = arr[j++];
        }

        for (int l = s; l <= e; l++) {
            arr[l] = (int) temp[l - s + s]; // Adjusted indexing for temp
        }

        return inversion;
    }

    public long mergeSort(int[] arr, int s, int e) {
    System.out.println("mergeSort: s=" + s + ", e=" + e);
    long inversion = 0;

    if (s < e) {
        int mid = s + (e - s) / 2;
        inversion += mergeSort(arr, s, mid);
        inversion += mergeSort(arr, mid + 1, e);
        inversion += merge(arr, s, mid, e);
    }

    return inversion;
}

public int numberOfInversions(int[] a, int n) {
    System.out.println("numberOfInversions: n=" + n);
    return (int) mergeSort(a, 0, n - 1);
}


    public void inorder(Node root, ArrayList<Integer> nodes) {
        if (root == null) return;
        inorder(root.left, nodes);
        nodes.add(root.data);
        inorder(root.right, nodes);
    }

    /* You are required to complete below function */
    public int pairsViolatingBST(int n, Node root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return numberOfInversions(nodes.stream().mapToInt(i -> i).toArray(), n);
    }
}

