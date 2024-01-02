/*  Your task is to complete the function maxSumWithK() which takes the array a[], 
    its size n and an integer k as inputs and returns the value of the largest sum of the subarray containing at least k numbers.*/

import java.util.*;
public class Largest_Sum_Subarray_of_Size_at_least_K{

    // function for finding a Largest_Sum_Subarray_of_Size_at_least_K
    public  static long maxSumWithK(long a[], long n, long k){
        long sum=0;
        long max=0;
        long prev=0;
        int i=0;
        int j=0;

        while(i<k){
            sum=sum+a[i++];

        }

        max=sum;

        while(i<n){
            sum=sum+a[i++];
            prev=prev+a[j++];
            max=Math.max(sum,max);

            if(prev<0){
                sum=sum-prev;
                prev=0;
                max=Math.max(sum,max);
            }
        }
        return max;
    }

    // main class 
    public static void main(String args[]){
        
        long a[] = {1, 1, 1, 1, 1, 1};
        long  k = 2;
        long n=a.length;

        // call function 
        long res=maxSumWithK(a,n,k);
        // print output of the function
        System.out.println("The Largest sum subarray of size at least k is :=  "+res);

    }
}