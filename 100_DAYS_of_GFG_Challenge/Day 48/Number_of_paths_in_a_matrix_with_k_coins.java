/* 
Task:  
The task is to complete the function numberOfPath() which takes n, k and 2D matrix arr[][] as input parameters and 
returns the number of possible paths.

*/


import java.util.Scanner;

public class Number_of_paths_in_a_matrix_with_k_coins{
    long solve(int i, int j, int val, int n, int k, int [][]arr, long [][][]dp) {
        if(i == n - 1 && j == n - 1 && val + arr[i][j] == k) 
            return 1;
        
        if(i >= n || j >= n || i < 0 || j < 0 || val > k)
            return 0;
            
        if(dp[i][j][val] != -1)
            return dp[i][j][val];
            
        long ans = 0;
        if(i + 1 < n)
            ans += solve(i + 1, j, val + arr[i][j], n, k, arr, dp);
        
        if(j + 1 < n)
            ans += solve(i, j + 1, val + arr[i][j], n, k, arr, dp);
            
        return dp[i][j][val] = ans;
    }
    
    long numberOfPath(int n, int k, int [][]arr) {
        long dp[][][] = new long[n][n][k + 1];
        for(int i = 0; i < n; i++)  
            for(int j = 0; j < n; j++)
                for(int m = 0; m <= k; m++)
                    dp[i][j][m] = -1;
                    
        return solve(0, 0, 0, n, k, arr, dp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the value of n (size of the matrix): ");
        int n = scanner.nextInt();
        
        int[][] arr = new int[n][n];
        System.out.println("Enter the elements of the matrix (row-wise):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        
        Number_of_paths_in_a_matrix_with_k_coins solution = new Number_of_paths_in_a_matrix_with_k_coins();
        long numberOfPaths = solution.numberOfPath(n, k, arr);
        System.out.println("Number of paths with " + k + " coins: " + numberOfPaths);
        
        scanner.close();
    }
}