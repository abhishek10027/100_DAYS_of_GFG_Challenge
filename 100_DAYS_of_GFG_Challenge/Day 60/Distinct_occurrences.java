/*
Task:

The task is to complete the function subsequenceCount() which takes two strings as argument s and t and 
returns the count of the sub-sequences modulo 109 + 7.

*/


import java.util.*;

public class Distinct_occurrences{
    static int mod = (int) (1e9 + 7);
    static int[][] dp;
    static int m,n;
    static int helper(int i,int j,char[] s,char[] t){
        
        if(j==n)return 1;
        if(i==m)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s[i]==t[j]){
            return dp[i][j] = (helper(i+1,j+1,s,t)+helper(i+1,j,s,t))%mod;
        }
        return dp[i][j] = helper(i+1,j,s,t);
    }
    
    public static int  subsequenceCount(String s, String t)
    {
	// Your code here
	    m = s.length();
	    n = t.length();
	    dp = new int[m][n];
	    for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
	    return helper(0,0,s.toCharArray(),t.toCharArray());
    }

    public static void main(String args[]){
        System.out.println("Enter your string s : ");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        System.out.println("Enter your string t : ");
        Scanner st=new Scanner(System.in);
        String t=st.nextLine();

        int res=subsequenceCount(s,t);

        System.out.println("Output is : " + res);

    }
}