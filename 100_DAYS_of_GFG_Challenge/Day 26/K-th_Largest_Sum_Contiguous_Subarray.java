/*
your task:-
Your task is to complete the function kthLargest() which takes the array Arr[] and its size N as inputs and 
returns the Kth largest subarray sum.

 */



public class K-th_Largest_Sum_Contiguous_Subarray{
    public static int kthLargest(int N, int K, int[] Arr) {
        // code here
        int sum=0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
              a.add(Arr[i]);
              sum = Arr[i];
            for(int j=i+1;j<N;j++)
            {
              sum=sum+Arr[j];
              a.add(sum);  
            } } Collections.sort(a,Collections.reverseOrder());
        return a.get(K-1);
    }
}