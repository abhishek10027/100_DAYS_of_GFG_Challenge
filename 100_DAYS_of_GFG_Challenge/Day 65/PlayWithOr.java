/* 
Task :- 

You are given an array arr[] of length n, 
you have to re-construct the same array arr[] in-place. The arr[i] after reconstruction will become arr[i] OR arr[i+1],
where OR is bitwise or. If for some i, i+1 does not exists, then do not change arr[i].

*/


import java.util.Scanner;

public class PlayWithOr {
    public static int[] game_with_number(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i] | arr[i + 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array (n): ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] result = game_with_number(arr, n);

        System.out.println("Output:");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
