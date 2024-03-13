/* 
Task:
The task is to implement the given function matrixDiagonally() which takes a matrix mat[][] of size n*n as an input and 
returns a list of integers containing the matrix diagonally. Do not read input, instead use the arguments given in the function.
*/

import java.util.Scanner;

public class PrintMatrixInDiagonalPattern {
    
    public static int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int ans[] = new int[n * n];
        
        int i = 0;
        int row = 0;
        int col = 0;
       
        // Initially we do up
        boolean isDirectionUp = true;
        while (i < ans.length) {
            if (isDirectionUp) {
                while (row < n && col < n && row >= 0 && col >= 0) {
                    ans[i++] = mat[row][col];
                    row--;
                    col++;
                }
                // Undo the last change
                row++;
                col--;
                // Now we should reverse the direction
                isDirectionUp = false;
                // Also make the necessary changes to go to down direction
                // Go right if possible
                if (col + 1 < n) {
                    // we can go right
                    col++;
                } else {
                    // we can go down
                    row++;
                }
            } else {
                while (row < n && col < n && row >= 0 && col >= 0) {
                    ans[i++] = mat[row][col];
                    row++;
                    col--;
                }
                row--;
                col--;
                
                isDirectionUp = true;
                // Try to go Down, if not possible go right
                if (row + 1 < n) {
                    row++;
                } else {
                    col++;
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the matrix (n): ");
        int n = scanner.nextInt();
        
        int[][] mat = new int[n][n];
        
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }
        
        int[] result = matrixDiagonally(mat);
        
        System.out.print("Output: {");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
        
        scanner.close();
    }
}
