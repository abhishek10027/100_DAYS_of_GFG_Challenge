/* 
Task:
The task is to complete the function Series() which takes an Integer n as input and returns a Fibonacci series up to the nth term.
*/

import java.util.*;

public class FibonacciseriesuptoNthterm{
    int[] Series(int n) {
        int[]fib = new int[n+1];
        fib[0] = 0;fib[1] = 1;
        int mod = 1000000007;
        for(int i=2;i<=n;i++)fib[i] = (fib[i-1]+fib[i-2])%mod;
        return fib;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();
        
        FibonacciseriesuptoNthterm fibonacci = new FibonacciseriesuptoNthterm();
        int[] series = fibonacci.Series(n);
        
        System.out.println("Fibonacci Series up to " + n + "th term:");
        for (int i = 0; i <= n; i++) {
            System.out.print(series[i] + " ");
        }
    }
}