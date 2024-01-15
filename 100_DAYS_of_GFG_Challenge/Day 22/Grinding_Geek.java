/* 
Your Task:

This is a function problem. The input is already taken care of by the driver code. 
You only need to complete the function max_courses() that takes N the number of days, 
the total amount, and the cost array as input argument and 
return the maximum amount of courses that could be purchased.

*/

public class Grinding_Geek{

    public int max_courses(int n, int total, int[] cost) {
        // code here
        int[][] dp = new int[n+1][total + 1];
        for (int sum=1;sum<=total;++sum) {
            for (int index = n-1; index >=0 ; index--) {
                int purchase = 0, notPurchase = 0;
                if (cost[index] <= sum) {
                    purchase = 1 + dp[index+1][sum - cost[index] + (cost[index] * 9) / 10];
                }
                notPurchase = dp[index+1][sum];

                dp[index][sum] = Math.max(purchase, notPurchase);
            }
        }
        return dp[0][total];
    }
}