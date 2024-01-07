
/* The task is to complete the function splitArray() 
which returns the maximum sum subarray after splitting the array into K subarrays such that 
maximum sum subarray is minimum possible.*/


public class Split_Array_Largest_Sum{
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int left=0;
        int right=0;
        int mid;
        for(int i:arr){
            left=Math.max(left,i);
            right+=i;
        }
        while(left<right){
            mid=left+(right-left)/2;
            if(cansplit(mid,arr,K)){
                right=mid;
            }
            else{
                left=mid+1;
            }
            
        }
        return left;
    }
    private static boolean cansplit(int sum,int [] arr,int K){
        int count =1;
        int total=0;
        for(int n:arr){
            total+=n;
            if(total>sum){
                total=n;
                count ++;
                
            }
            if(count>K) return false;
        }
        return true;
    }

    public static void main(String args[]){
       
        int N = 4, K = 3;
        int arr[] = {1, 2, 3, 4};

        int res=splitArray(arr,N,K);

        System.out.println("Larget sum is : " + res);
    }
}