/* 
Task:
Complete the function peakElement() which takes the array arr[] and its size n as input parameters 
and return the index of the peak element.

*/

import java.util.Scanner;

public class Peak_element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int peakIndex = peakElement(arr, n);
        System.out.println("Peak Element's Index: " + peakIndex);
    }

    public static int peakElement(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return n - 1;
    }
}
