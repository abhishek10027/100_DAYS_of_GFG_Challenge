/* 
Task :- 

A function F is defined as follows F(n)= (1) +(2*3) + (4*5*6) ... upto n terms (look at the examples for better clarity). 
Given an integer n, determine the F(n).

Note: As the answer can be very large, return the answer modulo 109+7.
*/


import java.util.*;

public class Recursive_sequence{

    public static long sequence(int n){
        // code here
        
        long mod=1000000007;
        long sum=0;
        long count=1;
        
        for(int i=1;i<=n;i++){
            long mul=1;
            for(int j=1;j<=i;j++){
                mul=(mul*count)%mod;
                count++;
            }
            
            sum=(sum+mul)%mod;
        }
        
        return sum%mod;
    }

    //main Driver class 

    public static void main(String args[]){
        System.out.print("Enter your N value:  ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        

        long res=sequence(n);

        System.out.print("Your output is :  "+ res);
    }
}