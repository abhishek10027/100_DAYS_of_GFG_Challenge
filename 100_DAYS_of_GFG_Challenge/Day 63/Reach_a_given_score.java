/*
Task: 

The task is to complete the function count( ) which takes n as input parameter and returns the answer to the problem.

*/


import java.util.*;

public class Reach_a_given_score {
    public static long count(int n) {
        long dp[] = new long[(int) n + 1];
        dp[0] = 1;

        for (int i = 3; i <= n; i++)
            dp[i] += dp[i - 3];

        for (int i = 5; i <= n; i++)
            dp[i] += dp[i - 5];

        for (int i = 10; i <= n; i++)
            dp[i] += dp[i - 10];

        return dp[n];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your N value: ");
        int n = sc.nextInt();
        System.out.println("Number of ways to reach score " + n + " is: " + count(n));
    }
}
