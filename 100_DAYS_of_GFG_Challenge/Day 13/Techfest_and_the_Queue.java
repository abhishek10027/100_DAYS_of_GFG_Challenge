//Problem :- Techfest and the Queue

/* 
Task :- Your task is to complete the function sumOfPowers() which takes a and b as input parameters 
and returns the sum of the power of primes that occur in prime factorization of the numbers between a to b (inclusive).

example :-

Input: 
a = 9
b = 12
Output: 
8
Explanation: 
For 9, prime factorization is:32 
So, sum of the powers of primes is: 2
For 10, prime factorization is : 21x51 
So, sum of the powers of primes is: 2
For 11, prime factorization is : 111 
So, sum of the powers of primes is: 1
For 12, prime factorization is : 22x 31 
So, sum of powers of primes is: 3
Therefore the total sum is 2+2+1+3=8.
*/

import java.util.*;

public class Techfest_and_the_Queue{
    public static long sumOfPowers(long a,long b){
        long ans=0;

        for(long i=a;i<=b;i++){
            ans = ans+primes(i);
        }

        return ans;
    }

    // prime function

    public static long primes(long x){
        long ans=0;

        for(long i=2;i*i<=x;i++){
            while(x%i==0){
                ans++;
                x=x/i;
            }
        }

        if(x!=1) ans++;
        return ans;
    }
    // main function

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        long a=sc.nextLong(); 
        System.out.print("Enter the value of b: ");
        long b=sc.nextLong();

        long res=sumOfPowers(a,b);

        System.out.print("The output is : "+res);
    }
}
