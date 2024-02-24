/*
Task:
The task is to complete the function maxSum() which accepts an integer n and returns the maximum sum.

*/

import java.util.*;
public class Maximum_Sum_Problem{
    public static int maxSum(int n) 
    { 
        int ans = solve(n);
        return ans;
    }
    public static int solve(int n){
        
        if(n==0){
            return 0;
        }
        
        int ans = solve(n/2) + solve(n/3) + solve(n/4);
        
        return Math.max(n,ans);
    }


    public static void main(String args []){
        System.out.println("Enter your N value :  ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int res=maxSum(n);
        System.out.println("Output : "+res);
    }
}