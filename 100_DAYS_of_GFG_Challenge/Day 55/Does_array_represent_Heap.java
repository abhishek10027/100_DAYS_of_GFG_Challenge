/* 
Task:  
The task is to complete the function isMaxHeap() which takes the array arr[] and its size n as inputs and 
returns True if the given array could represent a valid level order representation of a Max Heap, or else, it will return False.
*/



import java.util.*;

public class Does_array_represent_Heap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array (n): ");
        long n = scanner.nextLong();
        
        long[] arr = new long[(int) n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        
        System.out.println("Output:");
        if (countSub(arr, n)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
        
        scanner.close();
    }
    
    public static boolean countSub(long arr[], long n) {
        int x = 1;
        for(int i = 1; i < n; i++) {
            if(i % 2 == 0) {
                if(arr[i - x - 1] < arr[i]) {
                    return false;
                }
                x++;
            } else {
                if(arr[i - x] < arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
