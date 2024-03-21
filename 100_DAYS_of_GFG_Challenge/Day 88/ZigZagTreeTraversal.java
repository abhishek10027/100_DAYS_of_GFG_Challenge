/* 
Task:
The task is to complete the function zigZagTraversal() which takes the root node of the Binary Tree as its input and
 returns a list containing the node values as they appear in the zig-zag level-order traversal of the tree.*/


import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class ZigZagTreeTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements of the binary tree separated by spaces:");
        String input = scanner.nextLine();
        scanner.close();

        String[] elements = input.split(" ");

        Node root = createTree(elements);

        ZigZagTreeTraversal zigZagTreeTraversal = new ZigZagTreeTraversal();
        ArrayList<Integer> result = zigZagTreeTraversal.zigZagTraversal(root);

        System.out.println("ZigZag Tree Traversal:");
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }

    static Node createTree(String[] elements) {
        if (elements.length == 0)
            return null;

        Node root = new Node(Integer.parseInt(elements[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < elements.length; i += 2) {
            Node currentNode = queue.poll();

            if (!elements[i].equals("null")) {
                currentNode.left = new Node(Integer.parseInt(elements[i]));
                queue.offer(currentNode.left);
            }

            if (i + 1 < elements.length && !elements[i + 1].equals("null")) {
                currentNode.right = new Node(Integer.parseInt(elements[i + 1]));
                queue.offer(currentNode.right);
            }
        }

        return root;
    }

    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        int cnt = 0;
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                temp.add(n.data);

                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
            }

            if (cnt % 2 != 0) {
                Collections.reverse(temp);
            }

            al.addAll(temp);
            cnt++;
        }

        return al;
    }
}

