/* 
Task:
The task is to complete the function isPossible() which takes adjacency matrix paths as an input parameter and 
returns 1 if it is possible to start traversing from a node, x, and 
come back to it after traversing all the vertices at least once, using each edge exactly once.

*/


import java.util.*;

public class Count_all_Possible_Path{
    public static int isPossible(int[][] paths) {
        int n = paths.length;

        // Check the degree of each vertex
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) {
                degree += paths[i][j];
            }
            if (degree % 2 != 0) {
                // If any vertex has an odd degree, return 0
                return 0;
            }
        }

        return 1;
    }

    // main class 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int n = scanner.nextInt();
        int[][] paths = new int[n][n];

        System.out.println("Enter the adjacency matrix representing the paths: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paths[i][j] = scanner.nextInt();
            }
        }

        int result = Count_all_Possible_Path.isPossible(paths);

        if (result == 1) {
            System.out.println("Output: 1");
        } else {
            System.out.println("Output: 0");
        }
    }
}