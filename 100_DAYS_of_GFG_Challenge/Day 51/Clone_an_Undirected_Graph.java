
/* 
Task:

The task is to complete the function cloneGraph( ) which takes a node will always be the first node of the graph as input 
and returns the copy of the given node as a reference to the cloned graph.

*/



import java.util.*;

class Node {
    int val;
    List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

public class Clone_an_Undirected_Graph {
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node adjacent : node.neighbors) {
            clone.neighbors.add(cloneGraph(adjacent));
        }
        return clone;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter adjacency list (format: {{1, 3}, {0, 2}, {1, 3}, {0, 2}}): ");
        String input = scanner.nextLine();
        
        // Parsing input
        input = input.replaceAll("[{}]", "");
        String[] lists = input.split(", ");
        List<List<Integer>> adjList = new ArrayList<>();
        for (String list : lists) {
            List<Integer> nums = new ArrayList<>();
            String[] elements = list.split(" ");
            for (String element : elements) {
                nums.add(Integer.parseInt(element));
            }
            adjList.add(nums);
        }
        
        // Constructing graph
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            nodes.add(new Node(i + 1)); // Start node values from 1
        }
        for (int i = 0; i < adjList.size(); i++) {
            List<Integer> neighbors = adjList.get(i);
            for (int neighbor : neighbors) {
                if (neighbor - 1 >= 0 && neighbor - 1 < nodes.size()) { // Check neighbor index
                    nodes.get(i).neighbors.add(nodes.get(neighbor - 1)); // Adjust neighbor index
                }
            }
        }

        Clone_an_Undirected_Graph graphClone = new Clone_an_Undirected_Graph();
        Node clonedNode = graphClone.cloneGraph(nodes.get(0)); // Assuming the first node as the starting node
        
        System.out.println("Output: " + clonedNode.val);
    }
}
