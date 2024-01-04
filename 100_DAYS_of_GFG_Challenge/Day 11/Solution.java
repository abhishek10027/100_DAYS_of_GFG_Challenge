import java.util.*;
/*
Given an array of integers arr[] of length N, 
every element appears thrice except for one which occurs once.
Find that element which occurs once.
*/
//Problem name :- Find element occuring once when all other are present thrice

public class Solution{
    static int singleElement(int[] arr , int N) {
        // code here
        int res=0;
        for(int i=0;i<32;i++){
            int setbit=0;
            for(int j=0;j<N;j++){
                if((arr[j]&1<<i)!=0) setbit++;
            }
            if(setbit%3==1){
                res=res|(1<<i);
            }
        }
        return res;
    }


    public static void main(String args[]){
        int arr[] = {1, 10, 1, 1};
        int n=arr.length;
        int res=singleElement(arr,n);

        System.out.println("Single elements is : "+res);
    }
}