/*
Task:
The task is to complete the function findCity( ) which takes a number of nodes n, total number of edges m and vector of edges and distanceThreshold. and 
return the city with the smallest number of cities that are reachable through some path and whose distance is at most Threshold Distance. 
If there are multiple such cities, return the city with the greatest label.


*/




import java.util.Scanner;

class CityWithSmallestNeighborsAtThreshold {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    mat[i][j] = 0;
                } else {
                    mat[i][j] = (int) 1e9;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int r = edges[i][0];
            int c = edges[i][1];
            int w = edges[i][2];
            mat[r][c] = w;
            mat[c][r] = w;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = (int) Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }
        int min_city = (int) 1e9;
        int city = (int) 1e9;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] > 0 && mat[i][j] <= distanceThreshold) {
                    c++;
                }
            }
            if (c <= min_city) {
                min_city = c;
                city = i;
            }
        }
        return city;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
            edges[i][2] = scanner.nextInt();
        }
        int distanceThreshold = scanner.nextInt();
        CityWithSmallestNeighborsAtThreshold solution = new CityWithSmallestNeighborsAtThreshold();
        int result = solution.findCity(n, m, edges, distanceThreshold);
        System.out.println(result + " and class should be City With the Smallest Number of Neighbors at a Threshold Distance");
    }
}
