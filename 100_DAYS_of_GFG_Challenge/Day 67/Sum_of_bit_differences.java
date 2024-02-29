/* 
Task:  

The task is to complete the function sumBitDifferences() which takes the array arr[] and n as inputs and 
return an integer that represents the sum of the bit differences between all possible pairs of elements in the array.

*/






import java.util.Scanner;

public class Sum_of_bit_differences {
    static long sumBitDifferences(int[] arr, int n) {
        long ans = 0; // Initialize the result

        // Traverse over all bits
        for (int i = 0; i < 32; i++) {
            // Count number of elements with i'th bit set
            int count = 0;

            for (int j = 0; j < n; j++)
                if ((arr[j] & (1 << i)) != 0)
                    count++;

            // Add "count * (n - count) * 2" to the answer
            ans += (long) count * (n - count) * 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements (n): ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        long result =sumBitDifferences(arr, n);
        System.out.println("Output: " + result);

        scanner.close();
    }
}
