/* Your Task:
You do not need to read input or print anything. 
Your task is to complete the function numberSequence() which takes the number m and n as input parameters and 
returns the number of possible special sequences. */


import java.util.*;
public class Sequence_of_Sequence{
    static int numberSequence(int m, int n)
    {
        return solve(m,n);
    }
    
    static int solve(int m,int n){
        if(n==0) return 1;
        if(m==0) return 0;
        
        return solve(m/2,n-1)+solve(m-1,n);
    }


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your M :  ");
        int m=sc.nextInt();
        System.out.println("Enter your N : ");
        int n=sc.nextInt();

        int res=numberSequence(m,n);

        System.out.println("Your numberSequence is "+ res);
    }
}