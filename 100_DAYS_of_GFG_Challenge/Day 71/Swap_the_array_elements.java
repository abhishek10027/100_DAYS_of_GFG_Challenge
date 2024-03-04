/* 
Task:

The task is to complete the function swapElements(), which should swap each ith element with (i+2)th element.

*/
import java.util.*;

public class Swap_the_array_elements {
    public int[] swapElements(int[] arr, int n) {
        for (int i = 0; i < n; i += 2) {
            if (i + 2 >=n) break;
            int temp = arr[i];
            arr[i] = arr[i + 2];
            arr[i + 2] = temp;
            
        }
        return arr;
    }

    public static void main(String args[]) {
        System.out.println("Enter the value of n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter elements for the array: ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Swap_the_array_elements obj = new Swap_the_array_elements();
        int res[] = obj.swapElements(arr, n);

        System.out.println("Output is : ");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
