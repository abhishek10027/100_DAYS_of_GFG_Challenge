/* 
Task:

The task is to complete the function maxIndexDiff() which finds and returns maximum index difference. 

*/


import java.util.*;
public class Maximum_Index{
    public static int maxIndexDiff(int arr[], int n){
        int i=0;
        int j=n-1;
        int ans=0;
        while(i<=j){
            if(arr[i]<=arr[j]){
                ans=Math.max(ans,j-i);
                i++;
                j=n-1;
            }
            else{
                j--;
            }
        }
        return ans;
    }
    //Driver class 

    public static void main(String args[]){
        System.out.println("Enter the n value: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("Enter the elements of array : ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Output is: " +  maxIndexDiff(arr,n));
    }
}
