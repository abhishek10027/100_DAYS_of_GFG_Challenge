/* 
Task:

Complete the function maxProfit() which takes an integer array price as the only argument and returns an integer, 
representing the maximum profit, if only two transactions are allowed.

*/

import java.util.Scanner;

public class Buy_and_Sell_a_Share_at_most_twice {
    public static int maxProfit(int n, int[] price) {
        int s1 = 0;
        int s2 = 0;
        int b1 = Integer.MAX_VALUE;
        int b2 = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int cur = price[i];
            b1 = Math.min(b1, cur);
            s1 = Math.max(s1, cur - b1);
            b2 = Math.min(b2, cur - s1);
            s2 = Math.max(s2, cur - b2);
        }
        
        return s2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        
        System.out.println("Enter the prices for each day:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        
        System.out.println("Maximum profit: " + maxProfit(n, prices));
    }
}
