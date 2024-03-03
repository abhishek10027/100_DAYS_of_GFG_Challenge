/* 
Task:  
The task is to complete the function printLargest() which takes the array of strings arr[] as a parameter and 
returns a string denoting the answer.

*/


import java.util.Arrays;
import java.util.Scanner;

public class Largest_Number_formed_from_an_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String[] arr = new String[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }

        System.out.println("Output: " + printLargest(n, arr));
    }

    static String printLargest(int n, String[] arr) {
        StringBuilder res = new StringBuilder();
        Arrays.sort(arr, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        for (String x : arr) {
            res.append(x);
        }
        return res.toString();
    }
}
