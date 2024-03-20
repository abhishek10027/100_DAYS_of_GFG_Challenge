/*
Task:
The task is to complete the function sumOfLongRootToLeafPath() which takes root node of the tree as input parameter and 
returns an integer denoting the sum of the longest root to leaf path of the tree.
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

public class LongestPathSum {

    int ans = 0;

    public int sumOfLongRootToLeafPath(Node root) {
        int ht = getH(root);
        ans = 0;
        solve(root, ht, 1, root.data);
        return ans;
    }

    public int getH(Node root) {
        if (root == null)
            return 0;
        int l = getH(root.left);
        int r = getH(root.right);
        return Math.max(l, r) + 1;
    }

    void solve(Node root, int ht, int c, int sum) {
        if (root == null)
            return;
        if (c == ht) {
            ans = Math.max(ans, sum);
        }
        if (root.left != null)
            solve(root.left, ht, c + 1, sum + root.left.data);
        if (root.right != null)
            solve(root.right, ht, c + 1, sum + root.right.data);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;

        // Input parsing
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        int n = tokens.length;

        Queue<Node> queue = new LinkedList<>();
        if (!tokens[0].equals("N")) {
            root = new Node(Integer.parseInt(tokens[0]));
            queue.add(root);
        }

        int i = 1;
        while (!queue.isEmpty() && i < n) {
            Node temp = queue.poll();

            if (!tokens[i].equals("N")) {
                temp.left = new Node(Integer.parseInt(tokens[i]));
                queue.add(temp.left);
            }
            i++;

            if (i < n && !tokens[i].equals("N")) {
                temp.right = new Node(Integer.parseInt(tokens[i]));
                queue.add(temp.right);
            }
            i++;
        }

        LongestPathSum obj = new LongestPathSum();
        int result = obj.sumOfLongRootToLeafPath(root);
        System.out.println("For Input:");
        System.out.println(input);
        System.out.println("Your Output:");
        System.out.println(result);
    }
}
