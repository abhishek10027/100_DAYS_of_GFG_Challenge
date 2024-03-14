/*
Task:
The task is to complete the function largestSubsquare() which takes the integer n and the matrix a as input parameters and 
returns the size of the largest subsquare surrounded by 'X'.

 */



import java.util.Scanner;

public class LargestsubsquaresurroundedbyX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the grid (n): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        char[][] grid = new char[n][n];

        System.out.println("Enter the grid (use 'X' for occupied cells, 'O' for empty cells):");
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j * 2); // Skip the commas
            }
        }

        int result = largestSubsquare(n, grid);
        System.out.println("Largest subsquare surrounded by 'X' has size: " + result);

        scanner.close();
    }

    static int largestSubsquare(int n, char[][] a) {
        int[][] top = new int[n][n];
        int[][] left = new int[n][n];

        // Top metric
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'X') {
                    if (i != 0)
                        top[i][j] = top[i - 1][j] + 1;
                    else
                        top[i][j] = 1;
                }
            }
        }

        // Left metric
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'X') {
                    if (j != 0)
                        left[i][j] = left[i][j - 1] + 1;
                    else
                        left[i][j] = 1;
                }
            }
        }

        int maxSubSq = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (top[i][j] == 0 || left[i][j] == 0)
                    continue;

                int currentValue = Math.min(top[i][j], left[i][j]);

                while (currentValue > 0) {
                    int top1 = i - currentValue + 1;
                    int left1 = j - currentValue + 1;

                    if ((left[top1][j] >= currentValue) && (top[i][left1] >= currentValue)) {
                        maxSubSq = Math.max(maxSubSq, currentValue);
                        break;
                    }

                    currentValue--;
                }
            }
        }

        return maxSubSq;
    }
}
