/* Problem :- Your task is to complete the function canPair() which takes array nums and k as input parameter and 
returns true if array can be divided into pairs such that sum of every pair is divisible by k otherwise returns false. */


public class Array_Pair_Sum_Divisibility_Problem{
    public static boolean canpair(int nums[],int k){
        if(nums.length%2==1) return false;

        int arr[]=new int[k];

        for(int i=0;i<nums.length;i++){
            arr[nums[i]%k]++;
        }

        int i=1;
        int j=k-1;

        while(i<=j){
            if(arr[i]!=arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    // main class
    public static void main(String args[]){
        int arr[]={4,4,4};
        int k=4;
        //call function
        boolean res=canpair(arr,k);
        // print result the function
        System.out.println("The output is : " + res);
    }
}