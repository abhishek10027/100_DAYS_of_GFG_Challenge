/* 
Task:
The task is to complete the function criticalConnections() which takes the integer v denoting the number of vertices and 
an adjacency list adj as input parameters and 
returns  a list of lists containing the Critical connections in the sorted order.
*/


import java.util.*;

public class Find_all_Critical_Connections_in_the_Graph{
    private ArrayList<ArrayList<Integer>> ans;
    private int[] low, disc, parent;
    private int time;
    private boolean[] visited;

    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj) {
        ans = new ArrayList<>();
        low = new int[v];
        disc = new int[v];
        parent = new int[v];
        time = 0;
        visited = new boolean[v];

        // Calling ArticulationPoint function for each unvisited vertex
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArticulationPoint(i, adj);
            }
        }

        // Sorting the output in ascending order
        ans.sort((a, b) -> {
            if (a.get(0).equals(b.get(0))) {
                return a.get(1) - b.get(1);
            }
            return a.get(0) - b.get(0);
        });

        return ans;
    }

    private void ArticulationPoint(int u, ArrayList<ArrayList<Integer>> adj) {
        low[u] = time;
        disc[u] = time;
        time++;
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                parent[v] = u;
                ArticulationPoint(v, adj);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    ArrayList<Integer> connection = new ArrayList<>();
                    connection.add(Math.min(u, v));
                    connection.add(Math.max(u, v));
                    ans.add(connection);
                }
            } else if (parent[u] != v) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // main class 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int e = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (format: source destination): ");
        for (int i = 0; i < e; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            adj.get(source).add(destination);
            adj.get(destination).add(source); // Assuming undirected graph
        }

        Find_all_Critical_Connections_in_the_Graph criticalConnectionsFinder = new Find_all_Critical_Connections_in_the_Graph();
        ArrayList<ArrayList<Integer>> criticalConnections = criticalConnectionsFinder.criticalConnections(v, adj);

        System.out.println("Output:");
        for (ArrayList<Integer> connection : criticalConnections) {
            System.out.println(connection.get(0) + " " + connection.get(1));
        }

        scanner.close();
    }
}