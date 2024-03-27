/*
Task:

The task is to complete the function findShortestPath() which takes matrix as input parameter and 
return an integer denoting the shortest safe path form any cell in leftmost column to any cell in rightmost column of mat. 
If there is no possible path, return -1. 

*/



import java.util.*;

public class FindShortestSafeRouteInMatrix {

    static class Triplet {
        int r, c, step;
        
        Triplet(int r, int c, int step) {
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        
        int[][] matrix = new int[rows][cols];
        
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println("Shortest safe route length: " + findShortestPath(matrix));
    }

    public static int findShortestPath(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        int dx[] = {0, 0, 1, -1};
        int dy[] = {-1, 1, 0, 0};

        boolean v[][] = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0 && !v[i][j]) {
                    for (int k = 0; k < 4; k++) {
                        if (i + dx[k] >= 0 && i + dx[k] < r && j + dy[k] >= 0 && j + dy[k] < c) {
                            mat[i + dx[k]][j + dy[k]] = 0;
                            v[i + dx[k]][j + dy[k]] = true;
                        }
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            if (mat[i][0] == 1) {

                boolean visited[][] = new boolean[r][c];
                visited[i][0] = true;
                Queue<Triplet> q = new ArrayDeque<>();
                q.add(new Triplet(i, 0, 1));

                while (!q.isEmpty()) {
                    Triplet curr = q.poll();
                    int x = curr.r, y = curr.c, z = curr.step;
                    if (y == c - 1) {
                        res = Math.min(res, z);
                        break;
                    }
                    for (int k = 0; k < 4; k++) {
                        if (x + dx[k] >= 0 && x + dx[k] < r && y + dy[k] >= 0 && y + dy[k] < c) {
                            if (!visited[x + dx[k]][y + dy[k]] && mat[x + dx[k]][y + dy[k]] == 1) {
                                q.add(new Triplet(x + dx[k], y + dy[k], 1 + z));
                                visited[x + dx[k]][y + dy[k]] = true;
                            }
                        }
                    }
                }
            }
        }

        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }
}
