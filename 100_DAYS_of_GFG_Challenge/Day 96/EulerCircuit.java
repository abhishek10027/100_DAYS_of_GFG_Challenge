/*
our Task:
The task is to complete the function isEularCircuitExist() which takes v and adjacency list adj[] as input parameter and 
returns boolean value 1 if Eular circuit exists otherwise returns 0.
*/


import java.util.*;

public class EulerCircuit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices (v): ");
        int v = scanner.nextInt();
        
        System.out.print("Enter the number of edges: ");
        int e = scanner.nextInt();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        
        System.out.println("Enter the edges in format (source destination):");
        for (int i = 0; i < e; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            adj.get(source).add(destination);
            adj.get(destination).add(source); // Undirected graph
        }
        
        EulerCircuit eulerCircuit = new EulerCircuit();
        if (eulerCircuit.isEularCircuitExist(v, adj)) {
            System.out.println("Euler Circuit exists in the graph.");
        } else {
            System.out.println("Euler Circuit does not exist in the graph.");
        }
        
        scanner.close();
    }

    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() % 2 != 0) return false;
        }
        return true;
    }
}
