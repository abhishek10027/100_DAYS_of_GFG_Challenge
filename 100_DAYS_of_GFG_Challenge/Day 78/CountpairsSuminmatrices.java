/* 
Task:
The task is to complete the function countPairs() which takes 4 arguments mat1, mat2, n, x, and 
returns the count of pairs whose sum equals to x. 
*/



import java.util.HashSet;
import java.util.Scanner;

public class CountpairsSuminmatrices{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the value of n: ");
        int n = scanner.nextInt();

        System.out.println("Enter the value of x: ");
        int x = scanner.nextInt();

        int[][] mat1 = new int[n][n];
        int[][] mat2 = new int[n][n];

        System.out.println("Enter the elements of mat1:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the elements of mat2:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat2[i][j] = scanner.nextInt();
            }
        }

        int result = countPairs(mat1, mat2, n, x);
        System.out.println("Number of pairs with sum " + x + " is: " + result);

        scanner.close();
    }

    static int countPairs(int mat1[][], int mat2[][], int n, int x) {
        int count = 0;
        HashSet<Integer> us = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                us.add(mat2[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (us.contains(x - mat1[i][j])) {
                    count++;
                }
            }
        }

        return count;
    }
}
